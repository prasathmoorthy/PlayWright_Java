
package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void clickLogin() {
        page.click("text=Log in");
    }

    public void login(String email, String password) {
        page.fill("#email", email);
        page.fill("#password", password);
        page.click("button:text('LOGIN')");
    }
}
