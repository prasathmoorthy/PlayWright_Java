package gettingStarted;

import com.microsoft.playwright.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownload {
    public static void main(String[] args) throws IOException {
        Browser browser= Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        Page page=browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/download");
        Download download=page.waitForDownload(()->
        {
            page.locator("//a[text()='testfile.txt']").click();
        });
        String downloadPath=System.getProperty("user.dir")+"\\Downloads\\"+download.suggestedFilename();
        System.out.println(downloadPath);
        download.saveAs(Paths.get(downloadPath));


        //-----------------
        if(downloadPath.endsWith(".txt")){
            System.out.println("File type Verified");
        }else {
            System.out.println("File type Not Verified");
            browser.close();
            return;
        }
        //------------------

        if(Files.size(Paths.get(downloadPath)) > 0){
            System.out.println("File size is Verified");
        }else {
            System.out.println("File size Not Verified");
            browser.close();
            return;
        }
        //---------------------
        String dataFromFile=Files.readString(Paths.get(downloadPath));
        if(dataFromFile.contains("This is a test file for upload testing.")){
            System.out.println("File is a test file for upload testing.");
        }else {
            System.out.println("File is not a test file for upload testing.");
            browser.close();
            return;
        }

    }
}
