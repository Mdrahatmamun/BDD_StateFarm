package stateFarm.bdd.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import stateFarm.bdd.common.CommonFunctions;
import stateFarm.bdd.common.CommonWaits;
import stateFarm.bdd.objects.AutoQuote;
import stateFarm.bdd.objects.HomePage;
import stateFarm.bdd.utils.Configuration;

public class BaseClass {
	
	public Configuration configuration = Configuration.getInstance();
	public static WebDriver driver;
	public static WebDriverWait wait;
	

	protected static CommonFunctions commons;
	protected static CommonWaits waits;

	protected static HomePage homePage;
	protected static AutoQuote autoQuote;
	
	
	
	
	

	

	public void setUp(String browser1) {
		driver = localDriver(browser1);
		driver.manage().window().maximize();
		driver.get(configuration.get("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.get("pageloadWait"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.get("implicitWait"))));
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(configuration.get("explicitWait"))));
		initClasses();
	}
	

	private WebDriver localDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}

	public static void initClasses() {

		waits = new CommonWaits(wait);
		commons = new CommonFunctions(driver, waits);
		homePage = new HomePage(driver, commons);
		autoQuote = new AutoQuote(driver, commons);

	}

	protected WebDriver getDriver() {
		return driver;
	}

	
	public void terminate() {
		driver.quit();
	}

}
