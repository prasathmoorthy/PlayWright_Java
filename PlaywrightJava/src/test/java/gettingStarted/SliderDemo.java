package gettingStarted;

import com.microsoft.playwright.*;

public class SliderDemo {
    public static void main(String[] args) {
        Browser browser= Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page page=browser.newPage();
        page.navigate("https://jqueryui.com/slider/");
        FrameLocator frameLocator= page.frameLocator(".demo-frame");
        Locator locator=frameLocator.locator("//span[contains(@class,'ui-slider-handle')]");
        locator.focus();
        for(int i=0;i<10;i++){
            page.keyboard().press("ArrowRight");
        }
        for(int i=0;i<11;i++){
            page.keyboard().press("ArrowLeft");
        }
    }
}
