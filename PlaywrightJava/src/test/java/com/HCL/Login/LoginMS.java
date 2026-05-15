package com.HCL.Login;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class LoginMS {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://login.microsoftonline.com/189de737-c93a-4f5a-8b68-6f4ca9941912/oauth2/authorize?client%5Fid=00000003%2D0000%2D0ff1%2Dce00%2D000000000000&response%5Fmode=form%5Fpost&response%5Ftype=code%20id%5Ftoken&resource=00000003%2D0000%2D0ff1%2Dce00%2D000000000000&scope=openid&nonce=04E425ABF9B8138F37FBEC5D6633642879B7CC127EF1288D%2D6398F5D79879D0B51FE311373A7F7995F501A0B1CD892D46EB5B0060737167D6&redirect%5Furi=https%3A%2F%2Fhclo365%2Esharepoint%2Ecom%2F%5Fforms%2Fdefault%2Easpx&state=OD0w&claims=%7B%22id%5Ftoken%22%3A%7B%22xms%5Fcc%22%3A%7B%22values%22%3A%5B%22CP1%22%5D%7D%7D%7D&wsucxt=1&cobrandid=11bd8083%2D87e0%2D41b5%2Dbb78%2D0bc43c8a8e8a&client%2Drequest%2Did=729eeda1%2D1071%2D6000%2D66d5%2Dd4ac6f415cb4&sso_reload=true");
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Sign in"))).isVisible();
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("someone@example.com")).click();
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("someone@example.com")).fill("prasath.t@hcl.com");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Enter password"))).isVisible();
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter the password for")).click();
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter the password for")).fill("BubuTommy@28");
      assertThat(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in"))).isVisible();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
      page.navigate("https://login.microsoftonline.com/common/SAS/ProcessAuth");
      assertThat(page.getByText("Don't show this again")).isVisible();
      page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Don't show this again")).check();
      Page page1 = page.waitForPopup(() -> {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
      });
      page1.navigate("https://hclo365.sharepoint.com/SitePages/homenew.aspx#code=1.AQ8AN-edGDrJWk-LaG9MqZQZEicyJ-v6AWFPn1pEEN64avEPAHMPAA.BQABBAIAAAADAOz_BQD0_0V2b1N0c0FydGlmYWN0cwIAAAAAALh0i55WGpsDo41d3pn3s-Hbd424IDdZ4x4Jfm2h9KvELWT4nocWEP0kIj1ImaJvLTSAjr78XWKMF7SR--mvCfEx-0DULQNyJn9LFrxllgCDw_pM3jDrcvRbl0ALuXYz6SzHib9-adylp6ppgae-v3o_DpnHjOKj9y5WWh_1pGtuIJyquy42hhlRAq2nkmEXpfYsFqz6-Tav_x1x0KGHlarVDGQmsUfQGp-8PK5R0cQ9eKpJgRjvH1fmfpUzhMpHMBdRl8OqKWA8lD1gd1bBAG3f4SH3GCjPks39MbUYy3GikpT38Os51nSkGeoCNAOLZDXLYpcdIdSRkQlbtSEQ3LMncglMILBqNdeucp2JED6PC34HZWq3soHmMq17sZj-hf9rWRX3QZTbFhFia3ld98IOESoZCklPggamWYYdbJtvYcJU7B2JcnowAIPiCbd2neum9-kYqN3BOyVOgI3t3zFEidSgKmMkaadNfd3R0w3Z9M9IaPz0X4l7s21O703SY8p-FnSusUj0VQ7HWCi1AQNHJQ4cxFjjWs34CysWBpIqvkOq50WXEzFLmbZs0urq1vdbd3zDWhSt_px1-8uXKixQbhcO79piGbUSVK6GPXYMixMV7_E4s9La3siAzb3x5-BJXK70K9e3x763TMW-K5CnqiLFziEDsGPBex7duxVzbi0tq64ltBzq_i8qrAcDH_JH7L55O0Cmvt7GsNKO22VbM-fes0uig8GXruCRKloj6z1ljKhQGUYaENwCdLzIRA-RZ2zNd-MlaqqlIoQDVo6i3kw6Cz05akB23_koUl8EF5QntfKvXqziGZeHuXlcGPq2buvhMD5ckO95Q1MRdF2zbfCNCyHQOjolc41TGWxevq2ZW8dog5kF0mkiq5TdtdNjelaomBiKMvybUhECCqOyCUTZOi6ubnzY7bU7Tui02s3O02hnEfA48PhQeifYPcvMY2XiTHZpaQMO8lGlRjTH1nylDN3rnLhQxqlsV_jX7fwCgcQ1Nwxk_Rx4kuSbirn69uO28o0GPpm15h2hFSfP-O6JkkI6LVQ8TmA8_kmS-fOrLHfT0Z2-GIPleUic8_NsobsWT7-VhGMxD3Ch5vL8WqxsoYYx5kKVjEH_J7Z4mrbG9cSZoi2LEM-xaZAb3n2jdQxtpWcVqXFzcYPzqPHcsp_Nc1EzfaRU2cLsY_P-Ytbvfh9WTnN-0Ile4PSdPNxC-nuZoPgTBdBmxz0Shi-EbdGVTQNxdkEE53yVnANTTkWIgxLd9Wtf3-hDB1GhhAdKp3yrjGEdGiGNBjRclPPSTQT6Jra0Y60WLzxAKxb1yVxy5RTPy9qjt3RR-Uwa_KF2WgA1_OogPSdaM8N3DKBlOYVbOFoEtNUhpyjwF2zrIvsxZZtH2kqlAcrPdjoB84ja2IjRGOpTZA_GJQ&client_info=eyJ1aWQiOiI3NzcxN2I2Ni1kMDhkLTRlYWEtYTk2Ny0wYWJjMDA5YWUzM2YiLCJ1dGlkIjoiMTg5ZGU3MzctYzkzYS00ZjVhLThiNjgtNmY0Y2E5OTQxOTEyIn0&state=eyJpZCI6IjBmMjI3YTUzLWQzODEtNGM3Ny1iY2IzLTllMzM4MGI3MjVkYSIsIm1ldGEiOnsiaW50ZXJhY3Rpb25UeXBlIjoicG9wdXAifX0%3d&session_state=0011bb2a-e7af-1f9d-8a57-58a43d9080d6");
      page1.close();
      assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Time Sheet Management (iTime)"))).isVisible();
      Page page2 = page.waitForPopup(() -> {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Time Sheet Management (iTime)")).click();
      });
      page2.navigate("https://wf24.myhcl.com/iTime/ngiTime/home");
      assertThat(page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("×"))).isVisible();
      page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("×")).click();
      assertThat(page2.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("iTime"))).isVisible();
      page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Move to Next Week")).click();
    }
  }
}
