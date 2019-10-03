package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.BasePage;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ShykulaD on 03/08/2019.
 */

public class UsualKindlePage extends BasePage {

    List<String> kindleList = Arrays.asList("https://www.amazon.com/dp/B07DLPWYB7?ref=ods_ucc_eink_kindle_nrc_ucc",
            "https://www.amazon.com/dp/B07CXG6C9W?ref=ods_ucc_eink_pprwhite_nrc_ucc",
            "https://www.amazon.com/dp/B07F7TLZF4?ref=ods_ucc_eink_oasis_nrc_ucc");

    private By kindlePrice = By.xpath("//span[@id='priceblock_ourprice']");


    @Test
    public void getUsualKindel() {
        driver.get(kindleList.get(0));

        String parseUsualKindlePrice = driver.findElement(kindlePrice).getText();
        parseUsualKindlePrice = parseUsualKindlePrice.replaceAll("[$]", "").trim();
        double kindleUsualPriceInDouble = Double.parseDouble(parseUsualKindlePrice);
        System.out.println("Usual Kindel price is " + kindleUsualPriceInDouble);
        kindleUsualPriceInDouble = 90.99;

        try {
            Assert.assertEquals(kindleUsualPriceInDouble, 89.99, "Usual Kindel price didn't change");
        } catch (Exception e) {
            System.out.println("Usual Kindle price changed");
            System.out.println("Now Usual Kindel price is " + kindleUsualPriceInDouble);

        }

//        if (Double.valueOf(kindleUsualPriceInDouble) == 89.99) {
//            System.out.println("Usual Kindel price didn't change \n");
//        } else if (kindleUsualPriceInDouble >= 90) {
//            System.out.println("Usual Kindel price is bigger than regular price \n");
//        } else if (kindleUsualPriceInDouble <= 89.98) {
//            System.out.println("Usual Kindel price is lower than regular price! Time to buy \n");
//        }

    }
}