package screens;

import utilities.DriverUtilities;

public class LeagueScreen {
  private DriverUtilities du;

	// Locators
  private String leaguePageTitleId = "com.fivemobile.thescore:id/titleTextView";
  private String leaderSectionXpath = "(//android.view.ViewGroup[@resource-id='com.fivemobile.thescore:id/big_leader'])[1]";

  public LeagueScreen(DriverUtilities du) {
    this.du = du;
  }

  // Methods
  public String getLeagueTitle(){
    return du.getElementText(leaguePageTitleId);
  }

  public void selectLeagueSubTab(String leagueSubTab) {
    du.clickElementByText(leagueSubTab);
  }

  public boolean verifyLeadersSectionDisplayed() {
    return du.isElementDisplayed(leaderSectionXpath);
  }
}
