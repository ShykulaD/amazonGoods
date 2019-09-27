package pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import wrappers.BasePage;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ShykulaD on 03/08/2019.
 */

public class KindleOasisPage extends BasePage {

    List<String> kindleList = Arrays.asList("https://www.amazon.com/dp/B07DLPWYB7?ref=ods_ucc_eink_kindle_nrc_ucc",
            "https://www.amazon.com/dp/B07CXG6C9W?ref=ods_ucc_eink_pprwhite_nrc_ucc",
            "https://www.amazon.com/dp/B07F7TLZF4?ref=ods_ucc_eink_oasis_nrc_ucc");

    private By kindlePrice = By.xpath("//span[@id='priceblock_ourprice']");

    @Test
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