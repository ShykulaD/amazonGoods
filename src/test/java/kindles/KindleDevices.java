package kindles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.KindleOasisPage;
import pages.KindlePaperWhitePage;
import pages.UsualKindlePage;
import wrappers.BaseWrapper;

/**
 * Created by Shykulad on 28/07/2019.
 */
public class KindleDevices extends BaseWrapper {

    private By changeUserLocation = By.xpath("//input[@data-action-type='SELECT_LOCATION']");
    private By enterUSAZip = By.xpath("//input[@class='GLUX_Full_Width a-declarative']");
    private By applyUSAZip = By.xpath("//input[@aria-labelledby='GLUXZipUpdate-announce']");
    private By continueUSAZip = By.xpath("//*[@class='a-popover-footer']//input");

    @BeforeTest
    public void configureAmazon() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(changeUserLocation));
        driver.findElement(changeUserLocation).click();
        driver.findElement(enterUSAZip).sendKeys("10001");
        driver.findElement(applyUSAZip).click();
        driver.findElement(continueUSAZip).click();
        Thread.sleep(4000);
    }

    @Test
    public void BaseTest() {
        UsualKindlePage usualKindlePage = new UsualKindlePage();
        usualKindlePage.getUsualKindel();

        KindlePaperWhitePage kindlePaperWhitePage = new KindlePaperWhitePage();
        kindlePaperWhitePage.getPaperWhitePrice();

        KindleOasisPage kindleOasisPage = new KindleOasisPage();
        kindleOasisPage.getOasisWhitePrice();
    }


}
