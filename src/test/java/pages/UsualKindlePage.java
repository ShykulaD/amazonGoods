package pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import wrappers.BasePage;

/**
 * Created by ShykulaD on 03/08/2019.
 */

public class UsualKindlePage extends BasePage {

    private String[] kindleList = new String[]{"https://www.amazon.com/dp/B07DLPWYB7?ref=ods_ucc_eink_kindle_nrc_ucc",
            "https://www.amazon.com/dp/B07CXG6C9W?ref=ods_ucc_eink_pprwhite_nrc_ucc",
            "https://www.amazon.com/dp/B07F7TLZF4?ref=ods_ucc_eink_oasis_nrc_ucc"};

    private By kindlePrice = By.xpath("//span[@id='priceblock_ourprice' and " +
            "@class='a-size-medium a-color-price priceBlockBuyingPriceString']");

    @Test
    public void getUsualKindel() {
        driver.get(kindleList[0]);

        String parseUsualKindlePrice = driver.findElement(kindlePrice).getText();
        parseUsualKindlePrice = parseUsualKindlePrice.replaceAll("[$]", "").trim();
        double kindleUsualPriceInINT = Double.parseDouble(parseUsualKindlePrice);
        System.out.println("Usual Kindel price is " + kindleUsualPriceInINT);

        if (Double.valueOf(kindleUsualPriceInINT) == 89.99) {
            System.out.println("Usual Kindel price didn't change \n");
        } else if (kindleUsualPriceInINT >= 90) {
            System.out.println("Usual Kindel price is bigger than regular price \n");
        } else if (kindleUsualPriceInINT <= 89.98) {
            System.out.println("Usual Kindel price is lower than regular price! Time to buy \n");
        }

    }
}