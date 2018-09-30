import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Dimension;


public class Login extends Case {
    int a = 0;
    public void loginTest() throws Exception {

        super.setUp();
        driver.get(baseUrl);
        driver.manage().window().setSize(new Dimension(1300, 950));

        String mail = "gnutovamaria85@gmail.com";
        String password = "Test1234";

        ifElementLoaded2("//button[contains(text(),'Einloggen')]");
        WebElement loggingButton = driver.findElement(By.xpath("//button[contains(text(),'Einloggen')]"));

        try {
            a = 0;
            loggingButton.click();
            ifElementLoaded2("//*[@class='modal-content']");
            a = 1;
            WebElement logginnPopup = driver.findElement(By.xpath("//*[@class='modal-content']"));
            WebElement logging = logginnPopup.findElement(By.xpath("//*[@id='login-form__mail']"));
            WebElement pass = logginnPopup.findElement(By.xpath("//*[@id='login-form__secret']"));
            logging.sendKeys(mail);
            pass.sendKeys(password);
            a = 2;
            logginnPopup.findElement(By.xpath(".//button[contains(text(),'Einloggen')]")).click();
            a = 3;
            //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
            ifElementLoaded2("//*[@ui-sref='recipes'][@class='navigation--link ng-scope']");
            driver.findElement(By.xpath("//*[@ui-sref='recipes'][@class='navigation--link ng-scope']")).click();
            a = 4;
            ifElementLoaded2("//*[@id='sb-recipes']");
            WebElement search = driver.findElement(By.xpath("//*[@id='sb-recipes']"));
            search.sendKeys("Rogg'n Roll");
            search.sendKeys(Keys.RETURN);
            ifElementLoaded2("//*[@class='rl-right__bd']");
            WebElement searchResults = driver.findElement(By.xpath("//*[@class='rl-right__bd']"));
            a = 5;
            ifElementLoaded2("//*[@class='rl-right__bd']//*[contains(text(),\"Rogg 'n Roll\")]");
            searchResults.findElement(By.xpath("//*[contains(text(),\"Rogg 'n Roll\")]")).click();
            checkRecipePage();

        } catch (Exception e) {
            switch (a) {
                case 0:
                    System.out.println("*ERROR*   I can't click on  " + loggingButton);
                    break;
                case 1:
                    System.out.println("*ERROR*   Pop Up wasn't opened");
                    break;
                case 2:
                    System.out.println("*ERROR*   logging button on popup is lost");
                    break;
                case 3:
                    System.out.println("*ERROR*   Link recipes doesn't exist");
                    break;
                case 4:
                    System.out.println("*ERROR*   Search Input field not found");
                    break;
                case 5:
                    System.out.println("*ERROR*   Rogg 'n Roll not found");
                    break;
                case 6:
                    System.out.println("*ERROR*    Header wasn't loaded");
                    break;
                case 7:
                    System.out.println("*ERROR*   Image wasn't loaded");
                    break;
                case 8:
                    System.out.println("*ERROR*   Recipe Main on Rogg 'n Roll page  wasn't loaded");
                    break;
                case 9:
                    System.out.println("*ERROR*   recomended Recipe on Rogg 'n Roll page  wasn't loaded");
                    break;
            }
        }

        driver.close();

    }

    public void ifElementLoaded2(String waitedElement) throws Exception {
        int timOut = 0;
        int wait = 500;

        while (!(driver.findElement(By.xpath(waitedElement)).isDisplayed()) && (timOut <= 30000)) {
            Thread.sleep(wait);
            timOut = timOut + wait;
        }


    }
    public void checkRecipePage () throws Exception {
        a = 6;
        ifElementLoaded2("//*[@class='navigation--list nav navbar-nav']");
        a = 7;
        ifElementLoaded2("//img[@class='recipe-top__print']");
        a = 8;
        ifElementLoaded2("//*[@class='recipe-main row']");
        a = 9;
        ifElementLoaded2("//*[@class='gym-rmd__bd']");
        System.out.println("Page Rogg'n Roll load successfull" );
    }

}