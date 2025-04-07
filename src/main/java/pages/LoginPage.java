package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage extends BasePage{

    public static final SelenideElement LOGIN = $x("//*[@type='submit']");
    public static final SelenideElement MANDATORY_FIELD_MESSAGE = $x("//*[contains(text(), 'Mandatory field')]");
    public static final SelenideElement LOGIN_FAILED_MESSAGE = $x("//*[contains(text(), 'Login failed')]");
    public static final SelenideElement LOGO_BUTTON = $x("//*[@alt='Logo']");

    /**
     * Instantiates a new Login page.
     */
    public LoginPage() {
    }

    /**
     * Open login page login page.
     *
     * @param url the url
     * @return the login page
     */
    public LoginPage openLoginPage(String url) {
        open(url);
        return this;
    }

    /**
     * Is opened login page.
     *
     * @return the login page
     */
    public LoginPage isOpened() {
        LOGIN.shouldBe(Condition.visible);
        return this;
    }

    private LoginPage fillLoginAndPasswordToLogin(String login, String password) {
        new Input("login").writeLoginFields(login);
        new Input("password").writeLoginFields(password);
        new Button().click(LOGIN);
        return this;
    }

    /**
     * Login to main page main page.
     *
     * @param login    the login
     * @param password the password
     * @return the main page
     */
    public MainPage loginToMainPage(String login, String password) {
        fillLoginAndPasswordToLogin(login, password);
        return new MainPage();
    }

    private LoginPage fillOnlyUserToLogin(String login) {
        new Input("login").writeLoginFields(login);
        new Button().click(LOGIN);
        return this;
    }

    /**
     * Login with only login main page.
     *
     * @param login the login
     * @return the main page
     */
    public MainPage loginWithOnlyLogin(String login) {
        fillOnlyUserToLogin(login);
        return new MainPage();
    }

    private LoginPage fillOnlyPasswordToLogin(String password) {
        new Input("password").writeLoginFields(password);
        new Button().click(LOGIN);
        return this;
    }

    /**
     * Login with only password main page.
     *
     * @param password the password
     * @return the main page
     */
    public MainPage loginWithOnlyPassword(String password) {
        fillOnlyPasswordToLogin(password);
        return new MainPage();
    }

    /**
     * Login failed text string.
     *
     * @return the string
     */
    public static String loginFailedText() {
        return LOGIN_FAILED_MESSAGE.getText();
    }

    /**
     * Click logo login page.
     *
     * @return the login page
     */
    public LoginPage clickLogo(){
        new Button().click(LOGO_BUTTON);
        return this;
    }
}
