package guruqa.pages;

import com.codeborne.selenide.SelenideElement;
import guruqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneNumber = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            pickHobbie = $("#hobbiesWrapper"),
            addressInput = $("#currentAddress"),
            selectState = $("#state"),
            selectStateCity = $("#stateCity-wrapper"),
            selectCity = $("#city"),
            selectGender = $("#genterWrapper");

    public CalendarComponent calendar = new CalendarComponent();

    private final String FORM_TITLE = "Student Registration Form";
    private final String SUBMIT_TITLE = "Thanks for submitting the form";

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text("Student Registration Form"));
    }

    public void typeFirstname(String value) {
        firstNameInput.setValue(value);

    }

    public void typeLastName(String value) {
        lastNameInput.setValue(value);

    }

    public void typeEmail(String value) {
        emailInput.setValue(value);

    }

    public void typeGenderMale(String gender) {

        selectGender.$(byText(gender)).click();
    }

    public void typeNumber(String value) {
        phoneNumber.setValue(value);

    }

    public void typeSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
    }

    public void typeHobbie(String hobbie) {
        pickHobbie.$(byText(hobbie)).click();
    }

    public void typeAddress(String value) {
        addressInput.setValue(value);
    }

    public void choiceState(String stateName) {
        selectState.click();
        selectStateCity.$(byText(stateName)).click();
    }

    public void choiseCity(String cityName) {
        selectCity.click();
        selectStateCity.$(byText(cityName)).click();

    }

    public void submitForm() {
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void checkResult(String nameForm, String valueForm) {
        $x("//td[text()=" + "'" + nameForm + "'" + "]/following-sibling::td").shouldHave(text(valueForm));
    }
}




