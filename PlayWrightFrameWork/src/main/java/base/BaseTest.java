package base;

import com.microsoft.playwright.Page;
import factory.PlaywrightFactory;
import org.testng.annotations.*;

public class BaseTest {

    private static Page page;

    @BeforeMethod
    public void setup() {

        setPage(PlaywrightFactory.initBrowser());
    }

    @AfterMethod
    public void tearDown() {

        PlaywrightFactory.closeBrowser();
    }

	public static Page getPage() {
		return page;
	}

	public static void setPage(Page page) {
		BaseTest.page = page;
	}
}