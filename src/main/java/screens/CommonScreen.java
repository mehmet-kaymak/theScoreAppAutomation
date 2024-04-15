package screens;

import utilities.DriverUtilities;

public class CommonScreen {
  private DriverUtilities du;

	// Locators
  private String backButtonAccessibilityId = "Navigate up";

  public CommonScreen(DriverUtilities du) {
    this.du = du;
  }

  // Methods

  public void navigateBack() {
    du.clickElementByAccessibilityID(backButtonAccessibilityId);
  }



}
