package gettingStarted;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UtilitySS {
    public static byte[] captureScreenShot(Page page)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String date = sdf.format(new Date());
        byte[] arr=page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Screenshots/"+date+".png")));
        return arr;
    }

    public static byte[] CaptureElementScreenShot(Page page, String selector)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss_1.0");
        String date = sdf.format(new Date());
        Locator element = page.locator(selector);
        byte[] arr=element.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("Screenshots/"+date+".png")));
        return arr;
    }
    }

