package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import wrappers.BasePage;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ShykulaD on 03/10/2019.
 */
public class Kindels extends BasePage {
    List<String> kindleList = Arrays.asList("https://www.amazon.com/dp/B07DLPWYB7?ref=ods_ucc_eink_kindle_nrc_ucc",
            "https://www.amazon.com/dp/B07CXG6C9W?ref=ods_ucc_eink_pprwhite_nrc_ucc",
            "https://www.amazon.com/dp/B07F7TLZF4?ref=ods_ucc_eink_oasis_nrc_ucc");

    private By kindlePrice = By.xpath("//span[@id='priceblock_ourprice']");


    @Test (alwaysRun = true)
    public void getUsualKindel() {
        driver.get(kindleList.get(0));

        String parseUsualKindlePrice = driver.findElement(kindlePrice).getText();
        parseUsualKindlePrice = parseUsualKindlePrice.replaceAll("[$]", "").trim();
        double kindleUsualPriceInDouble = Double.parseDouble(parseUsualKindlePrice);
        System.out.println("Usual Kindel price is " + kindleUsualPriceInDouble);
        kindleUsualPriceInDouble = 90.99;

        try {
            SoftAssert soft = new SoftAssert();
                 Assert.assertEquals(kindleUsualPriceInDouble, 89.99, "Usual Kindel price didn't change");
        } catch (Exception e) {
            System.out.println("Usual Kindle price changed");
            System.out.println("Now Usual Kindel price is " + kindleUsualPriceInDouble);

        }
    }

    @Test (alwaysRun = true)
    public void getPaperWhitePrice() {
        driver.get(kindleList.get((1)));

        String parseKindlePrice = driver.findElement(kindlePrice).getText();
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
        String parseKindleOasisPrice = driver.findElement(kindlePrice).getText();
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
