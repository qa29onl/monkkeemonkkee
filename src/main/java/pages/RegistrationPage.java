package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Checkbox;
import elements.Input;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class RegistrationPage extends BasePage{

    public static final SelenideElement OK_BUTTON = $x("//button[@type='submit']");
    public static final SelenideElement CHECKBOX_TERMS_OF_USE = $x("//input[@id='registration_terms_of_use']");
    public static final SelenideElement CHECKBOX_LOST_PASSWORD_WARNING_REGISTERED = $x("//input[@id='registration_lost_password_warning_registered']");
    public static final SelenideElement USER_REGISTERED_XPATH = $x("//*[contains(text(), 'User registered')]");
    public static final SelenideElement VALIDATION_MESSAGE_SHORT_PASSWORD = $x("//*[@id='registration_password-strength-indicator' and contains(text(), 'Password is too short')]");
    public static final SelenideElement VALIDATION_MESSAGE_BAD_PASSWORD = $x("//*[contains(text(), 'Password strength: Bad')]");
    public static final SelenideElement VALIDATION_MESSAGE_STRONG_PASSWORD = $x("//*[contains(text(), 'Password strength: Strong')]");
    public static final SelenideElement VALIDATION_MESSAGE_PASSWORD_BACKGROUND = $x("//*[@id = 'registration_password-strength-indicator']");
    public static final SelenideElement VALIDATION_MESSAGE_PASSWORD_CONFIRMATION = $x("//*[contains(text(), 'Password confirmation doesn’t match')]");

    /**
     * Instantiates a new Registration page.
     */
    public RegistrationPage(){
    }

    /**
     * Open registration page registration page.
     *
     * @param url the url
     * @return the registration page
     */
    public RegistrationPage openRegistrationPage(String url) {
        open(url);
        return this;
    }

    /**
     * Registration new account registration page.
     *
     * @param email                the email
     * @param password             the password
     * @param passwordConfirmation the password confirmation
     * @param passwordHint         the password hint
     * @return the registration page
     */
    public RegistrationPage registrationNewAccount(String email, String password, String passwordConfirmation, String passwordHint) {
        new Input("registration_email").writeRegistrationFields(email);
        new Input("registration_password").writeRegistrationFields(password);
        new Input("registration_password_confirmation").writeRegistrationFields(passwordConfirmation);
        new Input("registration_password_hint").writeRegistrationFields(passwordHint);
        new Checkbox().selectCheckbox(CHECKBOX_TERMS_OF_USE);
        new Checkbox().selectCheckbox(CHECKBOX_LOST_PASSWORD_WARNING_REGISTERED);
        new Button().click(OK_BUTTON);
        return this;
    }

    /**
     * Success user registered text string.
     *
     * @return the string
     */
    public static String successUserRegisteredText() {
        return USER_REGISTERED_XPATH.getText();
    }

    /**
     * Registration input password field registration page.
     *
     * @param password the password
     * @return the registration page
     */
    public RegistrationPage registrationInputPasswordField(String password) {
        new Input("registration_password").writeRegistrationFields(password);
        return this;
    }

    /**
     * Registration input password and password confirmation fields registration page.
     *
     * @param password             the password
     * @param passwordConfirmation the password confirmation
     * @return the registration page
     */
    public RegistrationPage registrationInputPasswordAndPasswordConfirmationFields(String password, String passwordConfirmation) {
        new Input("registration_password").writeRegistrationFields(password);
        new Input("registration_password_confirmation").writeRegistrationFields(passwordConfirmation);
        new Button().click(OK_BUTTON);
        return this;
    }

    /**
     * Registration short password validation message string.
     *
     * @return the string
     */
    public static String registrationShortPasswordValidationMessage() {
        return VALIDATION_MESSAGE_SHORT_PASSWORD.getText();
    }

    /**
     * Registration bad password validation message string.
     *
     * @return the string
     */
    public static String registrationBadPasswordValidationMessage() {
        return VALIDATION_MESSAGE_BAD_PASSWORD.getText();
    }

    /**
     * Registration strong password validation message string.
     *
     * @return the string
     */
    public static String registrationStrongPasswordValidationMessage() {
        return VALIDATION_MESSAGE_STRONG_PASSWORD.getText();
    }

    /**
     * Registration password confirmation validation message string.
     *
     * @return the string
     */
    public static String registrationPasswordConfirmationValidationMessage() {
        return VALIDATION_MESSAGE_PASSWORD_CONFIRMATION.getText();
    }
}
