package kindles;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import wrappers.BasePage;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Shykulad on 28/07/2019.
 */
public class KindleDevices extends BasePage {

    private By changeUserLocation = By.xpath("//input[@data-action-type='SELECT_LOCATION']");
    private By enterUSAZip = By.xpath("//input[@class='GLUX_Full_Width a-declarative']");
    private By applyUSAZip = By.xpath("//input[@aria-labelledby='GLUXZipUpdate-announce']");
    private By continueUSAZip = By.xpath("//*[@class='a-popover-footer']//input");

    List<String> kindleList = Arrays.asList("https://www.amazon.com/dp/B07DLPWYB7?ref=ods_ucc_eink_kindle_nrc_ucc",
            "https://www.amazon.com/dp/B07CXG6C9W?ref=ods_ucc_eink_pprwhite_nrc_ucc",
            "https://www.amazon.com/dp/B07F7TLZF4?ref=ods_ucc_eink_oasis_nrc_ucc");
    private By kindlePrice = By.xpath("//span[@id='priceblock_ourprice']");

    @BeforeClass
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
    private void getUsualKindel() {
        driver.get(kindleList.get(0));

        String parseUsualKindlePrice = driver.findElement(kindlePrice).getText();
        parseUsualKindlePrice = parseUsualKindlePrice.replaceAll("[$]", "").trim();
        double kindleUsualPriceInDouble = Double.parseDouble(parseUsualKindlePrice);
        System.out.println("Usual Kindel price is " + kindleUsualPriceInDouble);

        try {
            Assert.assertEquals(kindleUsualPriceInDouble, 89.99, "Usual Kindel CHANGED!!!");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Test
    private void getPaperWhitePrice() {
        driver.get(kindleList.get((1)));

        String parseKindlePrice = driver.findElement(kindlePrice).getText();
        parseKindlePrice = parseKindlePrice.replaceAll("[$]", "").trim();
        double kindlePaperWhitePriceInDouble = Double.parseDouble(parseKindlePrice);
        System.out.println("KindlePaperWhite price is " + kindlePaperWhitePriceInDouble);

        try {
            Assert.assertEquals(kindlePaperWhitePriceInDouble, 129.99, "KindlePaperWhite price CHANGED");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Test
    private void getOasisWhitePrice() {
        driver.get(kindleList.get(2));

        String parseKindleOasisPrice = driver.findElement(kindlePrice).getText();
        parseKindleOasisPrice = parseKindleOasisPrice.replaceAll("[$]", "").trim();
        double kindleOasisPriceInDouble = Double.parseDouble(parseKindleOasisPrice);
        System.out.println("KindleOasis price is " + kindleOasisPriceInDouble);

        try {
            Assert.assertEquals(kindleOasisPriceInDouble, 249.99, "KindleOasis price CHANGED");
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
