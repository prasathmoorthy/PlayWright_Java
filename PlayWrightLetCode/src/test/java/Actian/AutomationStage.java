package Actian;


import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class AutomationStage {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://console.stage.actiandataplatform.com/");
      page.locator("div").filter(new Locator.FilterOptions().setHasText("Login to Actian Data")).first().click(new Locator.ClickOptions()
        .setButton(MouseButton.RIGHT));
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).click();
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).fill("prasath.t@actian.com.idp");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
      page.navigate("https://identity-actian--full.sandbox.my.site.com/s/login/?ec=302&inst=VF&startURL=%2Fsetup%2Fsecur%2FRemoteAccessAuthorizationPage.apexp%3Fsource%3DCAAAAZhg_el-MDAwMDAwMDAwMDAwMDAwAAABADsom4ldOb3w3dH_GQ2S3nfaxdfkYWgh4yr-xFRkeTj4dYJL9DGyMAtKSG-SdHfS0j84P9pTg1b6XGOgC9n8Pu2haYtxoEBCAn4hyxTYxfIVA-Vk0IgFxTsP2r6zarT2Hujb26jELzJGmZ5J4OxImhDopnBffbr6LAzOgdO2Utu1fimBBHPH3yMf-YCNtQ1xVzoFRjJohvbr9wrDX2ibRVZL1ymgYNMctlKl9BAZC9M-h114w9jJlm33phSsSlYIt5RjNa6LCM03nXlJaGqCpc3F5DHkklz6OEGTDFfA7GePvNt4us7xjf_kDc2IfZAIkBR8snNun3Ht8tfn1v6-FQISCOz4Va9dh6xRkoGRktM-zBk0uukgJuQk85bdLfSWxJTHwP5ZnVxGe63y_5Oa6MMHJmTFEs1jm_VDRmUHVBrQYmLUarZkFfPitbJNnHMP_bXpa-TerDFPUx6sT0PBWzYRkpqV7eoT5_YfxvJPe5eTl9P_aLSfyt_XnzlKxuQHXTpuP_nN8ip4a6xwfBRBFQSpUHXLSi5obBQoGJSNq1xfox2ip9xE-AbJrtJb56RG7TogJ9pF9p6fminxo0_jJQiM5xvl-mtAjrpPnrX3VpMEcgy1r4KXioHKY9L78KJlztsjuEpDF3qRdIhnda7LtCeLXXcJKg2Nc9-9l6HakvGIWlnBJOuy8UJ1jkH-CjyeX3NV5NNBe6hd6Vj9y7zf4gb42kXA-lf2HTOpV7pNUHHMO1maz2FxWNnORMxYMgi3RUkcL-b_5hLn7uaBZBMPmGUOnTMhhmjTF2hoez3saTSGkdflxkglg3ZLz9LCOailSlNdYnfXUK4Vxa3rDwF-034jKmEyrS9y54Lz-fQjox-j%26login_hint%3Dprasath.t%2540actian.com.idp");
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("Tommy@Naayae28");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();
      page.navigate("https://console.stage.actiandataplatform.com/home");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Warehouses")).click();
      page.locator(".dropdown-toggle.btn.btn-outline-stopped").first().click();
      page.locator(".dropdown-item").first().click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();
      page.locator(".dropdown-toggle.btn.btn-outline-stopped").first().click();
      page.locator(".dropdown-content.dropdown-menu.ng-star-inserted.show > a").first().click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();
      page.locator(".dropdown-toggle.btn.btn-outline-stopped").first().click();
      page.locator(".dropdown-content.dropdown-menu.ng-star-inserted.show > a").first().click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();
    }
  }
}