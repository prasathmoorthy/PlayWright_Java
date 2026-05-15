package gettingStarted.Practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityVideoRec {

    public static BrowserContext CaptureVideo(Browser browser) {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        String date = sdf.format(new Date());

        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoSize(1280, 720)
                .setRecordVideoDir(Paths.get("Videos/" + date + "_1.0")));

        return context;
    }
}