package test_pack;

import java.util.Arrays;

/**
 * Created by ShykulaD on 17/10/2019.
 */
public class TestSortSrrStrings {

    public static void main(String[] args) {
        String[] templates = {
                "String 2",
                "String 3"
        };
        Arrays.sort(templates);

        for (String template: templates)
        {
            System.out.print("String " + template.toUpperCase().replaceAll(" ", "_").replaceAll("-", "_")  + ' ' + '=' + ' ' + '"'  );
            System.out.println(template + '"' + ';');
        }
    }
}
