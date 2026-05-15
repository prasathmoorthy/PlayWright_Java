package day5;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://letcode.in/");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Work-Space")).click();
      page.getByText("Button", new Page.GetByTextOptions().setExact(true)).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Click")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Find the color of the button")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("How tall & fat I am?")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Button Hold!")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("letcode")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Courses").setExact(true)).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("letcode")).click();
    }
  }
}