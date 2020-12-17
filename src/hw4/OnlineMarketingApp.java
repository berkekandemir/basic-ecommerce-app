package hw4;
/**
 * This is the main class of the app. It calls the necessary method to run the application.
 */
public class OnlineMarketingApp {


	public static void main(String[] args) throws ProductNotFoundException {
		OnlineMarketingAppMenu menu = new OnlineMarketingAppMenu();
		menu.menu();
	}

}
