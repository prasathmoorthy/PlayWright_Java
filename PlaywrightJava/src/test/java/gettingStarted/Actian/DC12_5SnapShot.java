package gettingStarted.Actian;


import com.microsoft.playwright.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DC12_5SnapShot {
    public static void main(String[] args) throws IOException {
        Browser browser= Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        Page page=browser.newPage();
        //page.navigate("(//a[substring(@href, string-length(@href) - 3) = '.exe'])[last()]");
        page.navigate("https://alm.actian.com/nexus/content/repositories/pervasive-snapshot/com/pervasive/di/install/nsis/di.install.nsis.win64.rcp/12.5.0-SNAPSHOT/");
        Download download=page.waitForDownload(()->{
            page.locator("(//a[substring(@href, string-length(@href) - 3) = '.exe'])[last()]").click();
        });
        // String downloadPath=System.getProperty("user.dir")+"\\Download\\"+download.suggestedFilename();
        String downloadPath = "C:\\Users\\prasatht\\Downloads\\" + download.suggestedFilename();
        System.out.println("Download Path: " + downloadPath);
        download.saveAs(Paths.get(downloadPath));

        //------------
        if(downloadPath.endsWith(".exe")){
            System.out.println("Download FileType is verified");
        }else{
            System.out.println("Download FileType is not verified");
            browser.close();
            return;
        }
        //----------
        if(Files.size(Paths.get(downloadPath)) > 0){
            System.out.println("File Size is verified");
        }else {
            System.out.println("File Size is not verified");
            browser.close();
            return;
        }
        //---------
        browser.close();

    }
}
