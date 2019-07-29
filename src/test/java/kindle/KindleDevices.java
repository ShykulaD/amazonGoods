package kindle;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import wrappers.BaseWrapper;

/**
 * Created by Shykulad on 28/07/2019.
 */
public class KindleDevices extends BaseWrapper {

    private By changeUserLocation = By.xpath("//input[@data-action-type='SELECT_LOCATION']");
    private By enterUSAZip = By.xpath("//input[@class='GLUX_Full_Width a-declarative']");
    private By applyUSAZip = By.xpath("//input[@aria-labelledby='GLUXZipUpdate-announce']");
    private By continueUSAZip = By.xpath("//*[@class='a-popover-footer']//input");
    private By kindlePrice = By.xpath("//span[@id='priceblock_ourprice' and @class='a-size-medium a-color-price priceBlockBuyingPriceString']");

    String[] kindleList = new String[]{"https://www.amazon.com/dp/B07DLPWYB7?ref=ods_ucc_eink_kindle_nrc_ucc",
            "https://www.amazon.com/dp/B07CXG6C9W?ref=ods_ucc_eink_pprwhite_nrc_ucc",
            "https://www.amazon.com/dp/B07F7TLZF4?ref=ods_ucc_eink_oasis_nrc_ucc"};


    @Test(priority = 1, alwaysRun = true)
    public void getUsualKindel() throws InterruptedException {
        driver.get(kindleList[0]);

        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(changeUserLocation));
        driver.findElement(changeUserLocation).click();
        driver.findElement(enterUSAZip).sendKeys("02140");
        driver.findElement(applyUSAZip).click();
        driver.findElement(continueUSAZip).click();
        Thread.sleep(3000);

        String parseUsualKindlePrice = driver.findElement(kindlePrice).getText();
        parseUsualKindlePrice = parseUsualKindlePrice.replaceAll("[$]", "").trim();
        double kindleUsualPriceInINT = Double.parseDouble(parseUsualKindlePrice);
        System.out.println("Usual Kindel price is " + kindleUsualPriceInINT);

        if (Double.valueOf(kindleUsualPriceInINT) == 89.99) {
            System.out.println("Usual Kindel price didn't change");
        } else if (kindleUsualPriceInINT >= 90) {
            System.out.println("Usual Kindel price is bigger than regular price");
        } else if (kindleUsualPriceInINT <= 89.98) {
            System.out.println("Usual Kindel price is lower than regular price! Time to buy");
        }

    }

    @Test(priority = 2, alwaysRun = true)
    public void getPaperWhitePrice() throws InterruptedException {
        driver.get(kindleList[1]);

        String parseKindlePrice = driver.findElement(kindlePrice).getText();
        parseKindlePrice = parseKindlePrice.replaceAll("[$]", "").trim();
        double kindlePaperWhitePriceInINT = Double.parseDouble(parseKindlePrice);
        System.out.println("KindlePaperWhite price is " + kindlePaperWhitePriceInINT);

        if (Double.valueOf(kindlePaperWhitePriceInINT) == 129.99) {
            System.out.println("KindlePaperWhite price didn't change");
        } else if (kindlePaperWhitePriceInINT >= 130) {
            System.out.println("KindlePaperWhite price is bigger than regular price");
        } else if (kindlePaperWhitePriceInINT <= 129.98) {
            System.out.println("KindlePaperWhite price is lower than regular price! Time to buy");
        }

    }


    @Test(priority = 3, alwaysRun = true)
    public void getOasisWhitePrice() {
        driver.get(kindleList[2]);

        String parseKindleOasisPrice = driver.findElement(kindlePrice).getText();
        parseKindleOasisPrice = parseKindleOasisPrice.replaceAll("[$]", "").trim();
        double kindleOasisPriceInINT = Double.parseDouble(parseKindleOasisPrice);
        System.out.println("KindleOasis price is " + kindleOasisPriceInINT);

        if (Double.valueOf(kindleOasisPriceInINT) == 249.99) {
            System.out.println("KindleOasis price didn't change");
        } else if (kindleOasisPriceInINT >= 250) {
            System.out.println("KindleOasis price is bigger than regular price");
        } else if (kindleOasisPriceInINT <= 249.98) {
            System.out.println("KindleOasis price is lower than regular price! Time to buy");
        }

    }


}
