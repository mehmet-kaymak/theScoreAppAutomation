package screens;

import utilities.DriverUtilities;

public class HomeScreen {
  private DriverUtilities du;

	// Locators
  private String userProfileImageButtonXpath = "//android.widget.ImageButton";
  private String leaguesBottomNavigation = "Leagues";
  private String leaguePageTitleId = "com.fivemobile.thescore:id/titleTextView";

  public HomeScreen(DriverUtilities du) {
    this.du = du;
  }

  // Methods
  public boolean isUserProfileImageDisplayed(){
    return du.isElementDisplayed(userProfileImageButtonXpath);
  }

  public void openLeague(String league) {
    du.clickElementByAccessibilityID(leaguesBottomNavigation);
    du.clickElementByText(league);
  }



}
