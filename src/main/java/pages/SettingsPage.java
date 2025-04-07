package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Dropdown;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class SettingsPage extends BasePage{

    public static final SelenideElement SETTINGS = $x("//*[contains(text(), 'Settings')]");
    public static final SelenideElement COLOUR_SCHEME_BLOCK = $x("//*[@ng-class=\"cssClass('color_scheme')\"]");
    public static final SelenideElement OK_BUTTON = $x("//*[@type=\"submit\"]");
    public static final SelenideElement COLOUR_SCHEME_CHANGE_MESSAGE = $x("//*[contains(text(), 'Your colour scheme has been changed successfully')]");
    public static final SelenideElement LANGUAGE = $x("//*[@ng-class=\"cssClass('locale')\"]");
    public static final SelenideElement LANGUAGE_CHANGE_MESSAGE = $x("//*[contains(text(), 'Your language has been changed successfully')]");

    /**
     * Open settings page settings page.
     *
     * @param url the url
     * @return the settings page
     */
    public SettingsPage openSettingsPage(String url) {
        open(url);
        return this;
    }

    /**
     * Instantiates a new Settings page.
     */
    public SettingsPage() {
    }

    /**
     * Change colour scheme settings page.
     *
     * @return the settings page
     */
    public SettingsPage changeColourScheme() {
        new Button().click(SETTINGS);
        new Button().click(COLOUR_SCHEME_BLOCK);
        new Dropdown("selectLocale").selectByVisibleText("Dark");
        new Button().click(OK_BUTTON);
        return this;
    }

    /**
     * Success change colour scheme text string.
     *
     * @return the string
     */
    public static String successChangeColourSchemeText() {
        return COLOUR_SCHEME_CHANGE_MESSAGE.getText();
    }

    /**
     * Change language settings page.
     *
     * @return the settings page
     */
    public SettingsPage changeLanguage() {
        new Button().click(SETTINGS);
        new Button().click(LANGUAGE);
        new Dropdown("selectLocale").selectByVisibleText("Deutsch");
        new Button().click(OK_BUTTON);
        new Dropdown("selectLocale").selectByVisibleText("English");
        new Button().click(OK_BUTTON);
        return this;
    }

    /**
     * Success change language text string.
     *
     * @return the string
     */
    public static String successChangeLanguageText() {
        return LANGUAGE_CHANGE_MESSAGE.getText();
    }
}
