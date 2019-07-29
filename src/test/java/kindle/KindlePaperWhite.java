package kindle;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import wrappers.BaseWrapper;

/**
 * Created by Shykulad on 28/07/2019.
 */
public class KindlePaperWhite extends BaseWrapper {

    private By changeUserLocation  = By.xpath("//input[@data-action-type='SELECT_LOCATION']");
    private By enterUSAZip  = By.xpath("//input[@class='GLUX_Full_Width a-declarative']");
    private By applyUSAZip  = By.xpath("//input[@aria-labelledby='GLUXZipUpdate-announce']");
    private By continueUSAZip  = By.xpath("//*[@class='a-popover-footer']//input");
    private By kindlePrice  = By.xpath("//span[@id='priceblock_ourprice' and @class='a-size-medium a-color-price priceBlockBuyingPriceString']");

    @Test
    public void gerPaperWhitePrice() throws InterruptedException {
        driver.get("https://www.amazon.com/dp/B07DLPWYB7?ref_=nav_em_T1_0_4_11_1__k_ods_eink_jr&th=1");

           WebDriverWait explicitWait = new WebDriverWait(driver, 10);
           explicitWait.until(ExpectedConditions.presenceOfElementLocated(changeUserLocation));
            driver.findElement(changeUserLocation).click();
            driver.findElement(enterUSAZip).sendKeys("02140");
            driver.findElement(applyUSAZip).click();
                Thread.sleep(2000);
            driver.findElement(continueUSAZip).click();
                Thread.sleep(4000);

        String parseKindlePrice = driver.findElement(kindlePrice).getText();
        parseKindlePrice = parseKindlePrice.replaceAll("[$]", "").trim();
        double kindlePriceInINT = Double.parseDouble(parseKindlePrice); // getting minutes from film hours
        System.out.println("Kindle price is " + kindlePriceInINT);

        if (Double.valueOf(kindlePriceInINT) == 89.99) {
            System.out.println("Kindle price didn't change");
        } else if (kindlePriceInINT >= 90) {
            System.out.println("Kindle price is bigger than regular price");
        } else if (kindlePriceInINT <= 89.98) {
            System.out.println("Kindle price is lower than regular price! Time to buy");
        }

    }

}