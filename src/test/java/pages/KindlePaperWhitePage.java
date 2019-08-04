package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import wrappers.BaseWrapper;

/**
 * Created by ShykulaD on 03/08/2019.
 */


public class KindlePaperWhitePage {

    public WebDriver driver;

    private String[] kindleList = new String[]{"https://www.amazon.com/dp/B07DLPWYB7?ref=ods_ucc_eink_kindle_nrc_ucc",
            "https://www.amazon.com/dp/B07CXG6C9W?ref=ods_ucc_eink_pprwhite_nrc_ucc",
            "https://www.amazon.com/dp/B07F7TLZF4?ref=ods_ucc_eink_oasis_nrc_ucc"};

    private By kindlePrice = By.xpath("//span[@id='priceblock_ourprice' and @class='a-size-medium a-color-price priceBlockBuyingPriceString']");

    @Test
    public void getPaperWhitePrice() {
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

}