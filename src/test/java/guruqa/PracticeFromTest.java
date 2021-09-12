package guruqa;

import com.github.javafaker.Faker;
import guruqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class PracticeFromTest extends TestBase {
    Faker faker = new Faker();
    RegistrationPage registrationPage = new RegistrationPage();
    String firstname = faker.name().firstName();
    String lastname = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String address = faker.address().fullAddress();
    String gender = "Other";
    String subject = "Math";
    String hobbie = "Sports";
    String stateName = "NCR";
    String cityName = "Delhi";

    @Test
    void testFormPractice() {
        registrationPage.openPage();
        registrationPage.typeFirstname(firstname);
        registrationPage.typeLastName(lastname);
        registrationPage.typeEmail(email);
        registrationPage.typeGenderMale(gender);
        registrationPage.typeNumber(userNumber);
        registrationPage.calendar.setDate("28", "July", "2005");
        registrationPage.typeSubject(subject);
        registrationPage.typeHobbie(hobbie);
        registrationPage.typeAddress(address);
        registrationPage.choiceState(stateName);
        registrationPage.choiseCity(cityName);
        registrationPage.submitForm();
        // Проверка Формы
        registrationPage.checkResult("Student Name", firstname + " " + lastname);
        registrationPage.checkResult("Student Email", email);
        registrationPage.checkResult("Gender", gender);
        registrationPage.checkResult("Date of Birth", "28" + " " + "July" + "," + "2005");
        registrationPage.checkResult("Subjects", subject);
        registrationPage.checkResult("Hobbies", hobbie);
        registrationPage.checkResult("Address", address);
        registrationPage.checkResult("State and City", stateName + " " + cityName);

    }
}
