package pages;

import com.microsoft.playwright.Page;

public class DashboardPage {

    Page page;

    public DashboardPage(Page page) {

        this.page = page;
    }

    String dashboardText = "text=Dashboard";

    public boolean isDashboardVisible() {

        return page.isVisible(dashboardText);
    }
}