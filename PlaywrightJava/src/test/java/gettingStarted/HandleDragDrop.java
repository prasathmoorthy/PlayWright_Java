package gettingStarted;

import com.microsoft.playwright.*;

public class HandleDragDrop {
    public static void main(String[] args) {
        Browser browser = Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(750));
        Page page = browser.newPage();
        page.navigate("https://jqueryui.com/droppable/");
        FrameLocator frameLocator= page.frameLocator(".demo-frame");
        frameLocator.locator("#draggable").dragTo(frameLocator.locator("#droppable"));
    }
}
