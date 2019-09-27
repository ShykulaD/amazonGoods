package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import wrappers.BasePage;

/**
 * Created by ShykulaD on 03/08/2019.
 */
public class KindleOasisPage extends BasePage {


   private String[] kindleList = new String[]{"https://www.amazon.com/dp/B07DLPWYB7?ref=ods_ucc_eink_kindle_nrc_ucc",
            "https://www.amazon.com/dp/B07CXG6C9W?ref=ods_ucc_eink_pprwhite_nrc_ucc",
            "https://www.amazon.com/dp/B07F7TLZF4?ref=ods_ucc_eink_oasis_nrc_ucc"};

    private By kindlePrice = By.xpath("//span[@id='priceblock_ourprice' and @class='a-size-medium a-color-price priceBlockBuyingPriceString']");

    @Test
    public void getOasisWhitePrice(WebDriver driver) {
        this.driver.get(kindleList[2]);

        String parseKindleOasisPrice = this.driver.findElement(kindlePrice).getText();
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