package pages;

import com.sun.javafx.binding.Logging;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import wrappers.BasePage;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by ShykulaD on 03/10/2019.
 */
public class Kindles extends BasePage {
    List<String> kindleList = Arrays.asList("https://www.amazon.com/dp/B07DLPWYB7?ref=ods_ucc_eink_kindle_nrc_ucc",
            "https://www.amazon.com/dp/B07CXG6C9W?ref=ods_ucc_eink_pprwhite_nrc_ucc",
            "https://www.amazon.com/dp/B07F7TLZF4?ref=ods_ucc_eink_oasis_nrc_ucc");

    private By usualKindlePrice = By.cssSelector("#priceblock_ourprice");
    private By dealKindlePrice = By.cssSelector("#priceblock_dealprice");

    @Test (alwaysRun = true)
    public void getUsualKindle() {
        double kindleUsualPriceInDouble = 0;
        driver.get(kindleList.get(0));

         try {
             String parseUsualKindlePrice = driver.findElement(usualKindlePrice).getText();
             parseUsualKindlePrice = parseUsualKindlePrice.replaceAll("[$]", "").trim();
             kindleUsualPriceInDouble = Double.parseDouble(parseUsualKindlePrice);
             System.out.println("Usual Kindle price is " + kindleUsualPriceInDouble);
             kindleUsualPriceInDouble = 90.99;
             SoftAssert soft = new SoftAssert();
             Assert.assertEquals(kindleUsualPriceInDouble, 89.99, "Usual Kindle price didn't change");
         } catch (NoSuchElementException exception) {
             System.out.println("Usual Kindle price changed");
             System.out.println("Now Usual Kindle price is " + kindleUsualPriceInDouble);
             String parseUsualKindlePriceNew = driver.findElement(dealKindlePrice).getText();
             parseUsualKindlePriceNew = parseUsualKindlePriceNew.replaceAll("[$]", "").trim();
             kindleUsualPriceInDouble = Double.parseDouble(parseUsualKindlePriceNew);
             System.out.println("Usual Kindle price is " + kindleUsualPriceInDouble);
         }

    }

    @Test (alwaysRun = true)
    public void getPaperWhitePrice() {
        driver.get(kindleList.get((1)));

        String parseKindlePrice = driver.findElement(usualKindlePrice).getText();
        parseKindlePrice = parseKindlePrice.replaceAll("[$]", "").trim();
        double kindlePaperWhitePriceInINT = Double.parseDouble(parseKindlePrice);
        System.out.println("KindlePaperWhite price is " + kindlePaperWhitePriceInINT);

        if (Double.valueOf(kindlePaperWhitePriceInINT) == 129.99) {
            System.out.println("KindlePaperWhite price didn't change \n");
        } else if (kindlePaperWhitePriceInINT >= 130) {
            System.out.println("KindlePaperWhite price is bigger than regular price \n");
        } else if (kindlePaperWhitePriceInINT <= 129.98) {
            System.out.println("KindlePaperWhite price is lower than regular price! Time to buy \n");
        }

    }

    @Test (alwaysRun = true)
    public void getOasisWhitePrice() {

        driver.get(kindleList.get(2));
        String parseKindleOasisPrice = driver.findElement(usualKindlePrice).getText();
        parseKindleOasisPrice = parseKindleOasisPrice.replaceAll("[$]", "").trim();
        double kindleOasisPriceInINT = Double.parseDouble(parseKindleOasisPrice);
        System.out.println("KindleOasis price is " + kindleOasisPriceInINT);

        if (Double.valueOf(kindleOasisPriceInINT) == 249.99) {
            System.out.println("KindleOasis price didn't change \n");
        } else if (kindleOasisPriceInINT >= 250) {
            System.out.println("KindleOasis price is bigger than regular price \n");
        } else if (kindleOasisPriceInINT <= 249.98) {
            System.out.println("KindleOasis price is lower than regular price! Time to buy \n");
        }

    }
}
