package gmail.com.varlamvanadia1996.pages;

import com.github.javafaker.Faker;

public class StudentData {
    Faker faker = new Faker();
    public final String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = "Female",
            phone = faker.phoneNumber().subscriberNumber(10),
            year = String.valueOf(faker.number().numberBetween(1990, 2020)),
            month = "March",
            day = String.valueOf(faker.number().numberBetween(1, 31)),
            subjects = "Maths",
            hobbiesSports = "Sports",
            hobbiesReading = "Reading",
            hobbiesMusic = "Music",
            fileName = "test.txt",
            address = faker.address().fullAddress(),
            state = "Haryana",
            city = "Karnal";
}
