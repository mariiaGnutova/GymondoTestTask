
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Case {

WebDriver driver;
    String baseUrl;
    public  void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
      baseUrl = "https://www.gymondo.de/";
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }


}
