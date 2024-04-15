package common.tests;

import constants.DataConstants;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ScoreAppTests extends BaseTest {

	@Test
	public void verify001AppOnboarding() {
		test.info("Test Description: Verify Successful Onboarding the Scope App");
		du.clickElementByText(DataConstants.GET_STARTED_BUTTON);
		for(String league: DataConstants.FAVORITE_LEAGUES){
			du.clickElementByText(league);
		}
		du.clickElementByText(DataConstants.CONTINUE_BUTTON);
		du.clickElementByTextIfExists(DataConstants.ALLOW_LOCATION_BUTTON);
		du.clickElementByTextIfExists(DataConstants.ONLY_THIS_TIME_BUTTON);
		for(String team: DataConstants.FAVORITE_TEAMS){
			du.clickElementByText(team);
		}
		du.clickElementByText(DataConstants.CONTINUE_BUTTON);
		du.clickElementByText(DataConstants.DONE_BUTTON);
		du.clickElementByTextIfExists(DataConstants.MAY_BE_LATER_BUTTON);
		du.clickElementByTextIfExists(DataConstants.ALLOW_BUTTON);

		Assert.assertTrue(hs.isUserProfileImageDisplayed(), "Home Screen not displayed. Onboarding is incomplete");

	}

	@Test
	public void verify002OpeningLeaguePage() {
		test.info("Test Description: Verify Opening a League Page");
		hs.openLeague(DataConstants.LEAGUE);
		Assert.assertEquals(ls.getLeagueTitle(), DataConstants.LEAGUE, "League Title on the screen does not match.");
	}

	@Test
	public void verify003OpeningLeagueSubTab() {
		test.info("Test Description: Verify Opening a League Sub Tab");
		ls.selectLeagueSubTab(DataConstants.LEAGUE_SUB_TAB);
		Assert.assertTrue(ls.verifyLeadersSectionDisplayed(), "League Subtitle Screen is incorrect");
	}

	@Test
	public void verifyNavigatingBackFromLeagueSubTab(){
		test.info("Test Description: Verify Navigating Back from League Sub Tab");
		cs.navigateBack();
		Assert.assertEquals(ls.getLeagueTitle(), DataConstants.LEAGUES, "Leagues Title on the screen does not match.");
	}
	
}