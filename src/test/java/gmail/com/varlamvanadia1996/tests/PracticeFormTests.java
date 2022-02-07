package gmail.com.varlamvanadia1996.tests;

import com.codeborne.selenide.Configuration;
import gmail.com.varlamvanadia1996.helpers.Attach;
import gmail.com.varlamvanadia1996.pages.RegistrationPage;
import gmail.com.varlamvanadia1996.pages.StudentData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class PracticeFormTests {

    RegistrationPage registrationPage = new RegistrationPage();
    StudentData studentData = new StudentData();

    @BeforeAll
    static void setUp() {
        String login = System.getProperty("login");
        String password = System.getProperty("password");
        String url = System.getProperty("url");
        String browser = System.getProperty("browser", "chrome1");
        String version = System.getProperty("version", "92");


        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = browser;
        Configuration.browserVersion = version;
        String remote = "https://" + login + ":" + password + "@" + url;
        Configuration.remote = remote;
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @Test
    void successTests() {
        registrationPage.openPage()
                .typeFirstName(studentData.firstName)
                .typeLastName(studentData.lastName)
                .typeUserEmail(studentData.userEmail)
                .typeGender(studentData.gender)
                .typePhone(studentData.phone);
        registrationPage.calendarComponent.setDae(studentData.year, studentData.month, studentData.day);
        registrationPage.typeSubject(studentData.subjects)
                .typeHobbies(studentData.hobbiesSports)
                .typeHobbies(studentData.hobbiesReading)
                .typeHobbies(studentData.hobbiesMusic)
//                .uploadPicture(studentData.fileName)
                .setAddress(studentData.address)
                .selectStateAndCity(studentData.state, studentData.city)
                .submitForm()
                .checkResults(studentData);
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
