import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class PracticeFormDataTest {

    @Test
    public void CheckDataRegistrationForm() {

        String baseUrl = "https://demoqa.com/automation-practice-form";

        String firstName = "Paul";
        String lastName = "McCartney";
        String userEmail = "paul.mccartney@yahoo.com";
        String userNumber = "2173999999";
        String subject = "Maths";
        String birthdayMonth = "May";
        String birthdayYear = "1990";
        String file = "maxresdefault.jpg";
        String currentAddress = "38 Circle Road str., 333 apt.";
        String city = "Lucknow";
        String state = "Uttar Pradesh";

        open(baseUrl);
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText(birthdayMonth);
        $(".react-datepicker__year-select").selectOptionByValue(birthdayYear);
        $(".react-datepicker__day--001").click();

        $("#subjectsInput").setValue(subject).pressTab();
        $("label[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath(file);
        $("#currentAddress").setValue(currentAddress);

        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();

        $("#submit").click();

        $(".table-responsive").shouldHave(
                Condition.text(firstName + " " + lastName),
                Condition.text(userEmail),
                Condition.text("Male"),
                Condition.text(birthdayMonth),
                Condition.text(birthdayYear),
                Condition.text(subject),
                Condition.text("Music"),
                Condition.text(file),
                Condition.text(currentAddress),
                Condition.text(state + " " + city));
    }
}
