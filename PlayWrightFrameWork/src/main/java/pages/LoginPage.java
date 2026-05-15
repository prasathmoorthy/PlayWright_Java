package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    Page page;

    public LoginPage(Page page) {

        this.page = page;
    }

    String username = "input[name='username']";
    String password = "input[name='password']";
    String loginBtn = "button[type='submit']";

    public void login(String user, String pass) {

        page.fill(username, user);

        page.fill(password, pass);

        page.click(loginBtn);
    }
}