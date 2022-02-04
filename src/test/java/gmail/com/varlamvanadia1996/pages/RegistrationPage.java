package gmail.com.varlamvanadia1996.pages;

import com.codeborne.selenide.SelenideElement;
import gmail.com.varlamvanadia1996.pages.components.CalendarComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            popupResults = $(".modal-content"),
            tableResults = $(".table"),
            userEmailInput = $("#userEmail"),
            phoneInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            uploadPictureInput = $("#uploadPicture"),
            addressInput = $x("//textarea[@id=\"currentAddress\"]"),
            stateSelect = $("#react-select-3-input"),
            citySelect = $("#react-select-4-input"),
            submitButton = $("#submit");

    public CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Открываем страницу")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    @Step("Заполняем Имя")
    public RegistrationPage typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Заполняем Фамилию")
    public RegistrationPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Заполняем email")
    public RegistrationPage typeUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    @Step("Выбираем пол")
    public RegistrationPage typeGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    @Step("Заполняем телефон")
    public RegistrationPage typePhone(String phone) {
        phoneInput.setValue(phone);
        return this;
    }

    @Step("Выбираем предметы")
    public RegistrationPage typeSubject(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    @Step("Выбираем хобби")
    public RegistrationPage typeHobbies(String hobbies) {
        $(byText(hobbies)).click();
        return this;
    }

    @Step("Заполняем адрес")
    public RegistrationPage setAddress(String address) {
        addressInput.sendKeys(address);
        return this;
    }

    @Step("Загружаем файл")
    public RegistrationPage uploadPicture(String fileName) {
        uploadPictureInput.uploadFromClasspath(fileName);
        return this;
    }

    @Step("Выбираем государство и город")
    public RegistrationPage selectStateAndCity(String state, String city) {
        stateSelect.setValue(state).pressEnter();
        citySelect.setValue(city).pressEnter();
        return this;
    }

    @Step("Нажимаем кнопку отправки формы")
    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }

    @Step("Проверяем наличие данных в таблице с результатом отправки формы")
    public RegistrationPage checkResults(StudentData studentData) {
        popupResults.shouldBe(visible);
        tableResults.shouldHave(text(studentData.firstName + " " + studentData.lastName),
                text(studentData.userEmail),
                text(studentData.gender),
                text(studentData.phone),
                text(studentData.year),
                text(studentData.month),
                text(studentData.day),
                text(studentData.subjects),
                text(studentData.hobbiesSports),
                text(studentData.hobbiesReading),
                text(studentData.hobbiesMusic),
//                text(studentData.fileName),
                text(studentData.address),
                text(studentData.state + " " + studentData.city));
        return this;
    }
}
