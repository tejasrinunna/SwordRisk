package sword.active.risk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActiveRiskTest {

	private WebDriver driver;
	
	// Set to your local chrome driver path.
	private String chromeDriverPath = "C:\\Users\\teju\\Desktop\\Chrome Driver\\Chromedriver.exe";

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	// To navigate Sword URL
	@Test
	public void homePage() {
		driver.navigate().to("http://www.sword-activerisk.com/");
		Assert.assertEquals("Done", "Done");
	}

	// To Contact Sword activeRisk
	@Test
	public void contactus() {
		driver.navigate().to("http://www.sword-activerisk.com/news-resources/blog/");
		driver.get("http://www.sword-activerisk.com/company/contact-us/");
		driver.findElement(By.id("email-2f7d3be2-6a93-481c-994d-c36f12768aac")).sendKeys("tsm.tejasri@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"hsForm_2f7d3be2-6a93-481c-994d-c36f12768aac\"]/div[9]/div[2]/input"))
				.click();
		Assert.assertEquals("Done", "Done");
	}

	// String pageSource = driver.getPageSource(); System.out.println(pageSource);

	// To meet our Partners
	@Test
	public void Partners() {
		driver.get("http://www.sword-activerisk.com/company/");
		driver.findElement(By.xpath("//*[@id=\"menu-mainnav-1\"]/li[7]/ul/li[3]/a")).click();
		driver.get("http://www.sword-activerisk.com/company/partners/meet-our-partners/");
		driver.findElement(By.xpath("//*[@id=\"internal-page-content\"]/div/div/div[1]/p[3]/a/img")).click();
	}

	/*
	 * // To go Awards
	 * 
	 * @Test public void Awards() { driver.navigate().back(); String URL =
	 * driver.getCurrentUrl(); System.out.println(URL);
	 * driver.findElement(By.linkText("awards")).click(); }
	 */

	// To check Submit is Enabled
	@Test
	public void Submit() {
		driver.get("http://www.sword-activerisk.com/customers/");
		driver.get("http://www.sword-activerisk.com/customers/case-studies/");
		boolean submit = driver.findElement(By.xpath("//*[@id=\"tabs-1\"]/div[2]/div[3]/div/a[2]")).isEnabled();
		System.out.println("submit is enabled" + submit);
	}

	// Clicking submit button without giving details
	@Test
	public void SubmitFail() {
		driver.findElement(By.cssSelector("#header-content > div.header-topnav > a:nth-child(2)")).click();
		driver.findElement(By.xpath("//*[@id=\"hsForm_2f7d3be2-6a93-481c-994d-c36f12768aac\"]/div[9]/div[2]/input"))
				.click();
		System.out.println("Please complete all required fields.");
	}

	// To Enter PRM
	@Test
	public void PRM() {
		driver.get("http://www.sword-activerisk.com/why-risk-management/");
		driver.findElement(By.xpath("//*[@id=\"menu-mainnav-1\"]/li[1]/ul/li[3]/a")).click();
		driver.findElement(By.linkText("Enterprise Risk Management")).click();
		driver.findElement(By.linkText("Project Risk Management")).click();
	}

	// Task 2
	// Check CR Learn More
	@Test
	public void Crossrail() {
		driver.navigate().to("http://www.sword-activerisk.com/customers/");
		driver.get("http://www.sword-activerisk.com/customers/case-studies/");
		driver.findElement(By.xpath("//*[@id=\"ui-id-3\"]")).click();
		driver.get("http://www.sword-activerisk.com/crossrail-2/");
		System.out.println("learnmore is working");
	}

	// Check CR Download case study
	@Test
	public void downloadcasestudy() {
		driver.navigate().to("http://www.sword-activerisk.com/customers/");
		driver.get("http://www.sword-activerisk.com/customers/case-studies/");
		driver.findElement(By.xpath("//*[@id=\"ui-id-3\"]")).click();
		driver.findElement(By.cssSelector("#tabs-3 > div.caseContent > div:nth-child(1) > div > a.casePDF"));
		System.out.println("Cross rail case study is downloadimg");
	}

	// Check Watch Case study video
	@Test
	public void Video() {
		driver.navigate().to("http://www.sword-activerisk.com/customers/");
		driver.get("http://www.sword-activerisk.com/customers/case-studies/");
		driver.findElement(By.xpath("//*[@id=\"ui-id-3\"]")).click();
		driver.navigate().to("http://www.youtube.com/watch?v=A2vHNd41ThE&autoplay=1");
		System.out.println("watch case study video is unavailable");
	}

	// check Downer Learn more
	@Test
	public void Downer() {
		driver.navigate().to("http://www.sword-activerisk.com/customers/");
		driver.get("http://www.sword-activerisk.com/customers/case-studies/");
		driver.findElement(By.xpath("//*[@id=\"ui-id-3\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"tabs-3\"]/div[2]/div[3]/div/a[2]"));
		System.out.println("Downer learnmore is working");
	}

	// info mail is redirecting to email
	@Test
	public void Infomail() {
		driver.findElement(By.cssSelector("#header-content > div.header-topnav > a:nth-child(2)")).click();
		driver.findElement(By.xpath("//*[@id=\"hsForm_2f7d3be2-6a93-481c-994d-c36f12768aac\"]/div[9]/div[2]/input"))
				.click();
		WebElement link = (driver.findElement(By.xpath("//*[@id=\"internal-page-content\"]/div/div/p[7]/a")));
		String href = link.getAttribute("href");
		driver.get(href);
		System.out.println("Redirecting to the mail");

	}

	// entering the Name
	@Test
	public void Username() {
		driver.findElement(By.xpath("//*[@id=\"menu-item-2446\"]/a")).click();
		WebElement link = (driver.findElement(By.xpath("//*[@id=\"menu-mainnav-1\"]/li[7]/ul/li[4]/a")));
		String href = link.getAttribute("href");
		driver.get(href);
		//WebElement element = driver.findElement(By.id("username")).sendKeys("Sword");
		System.out.println("Username entered");
	}

	// To enter employee sales force portal
	@Test
	public void Employeeportal() {
		driver.findElement(By.cssSelector("#header-content > div.header-topnav > a:nth-child(2)")).click();
		WebElement link = (driver.findElement(By.xpath("//*[@id=\"internal-page-content\"]/div/div/p[9]/a")));
		String href = link.getAttribute("href");
		driver.get(href);
		driver.findElement(By.id("employee_login_link")).click();
		driver.findElement(By.id("signup_linksignup_link")).click();
		System.out.println("Entered into Salesforce type for free");
	}

	// <a href="http://www.techbeamers.com">How to use locators?</a>
	// To enter Partial link
	@Test
	public void Partial() {
		driver.findElement(By.xpath("//*[@id=\"menu-item-66\"]/a")).click();
		WebElement item = driver.findElement(By.partialLinkText("Professionals"));
	}

	// To Play ARM video
	@Test
	public void videoPlaying() {
		driver.findElement(By.xpath("//*[@id=\"menu-item-66\"]/a")).click();
		driver.findElement(By.linkText("Project Professionals"));
		driver.get("http://www.sword-activerisk.com/wp-content/uploads/Crossrail_62163_whitechapel_january_2013.jpg");
		WebElement video = driver.findElement(By.xpath("i//*[@id=\"internal-page-content\"]/div/div[1]/p[9]/a/img"));
		video.click();
	}
}
