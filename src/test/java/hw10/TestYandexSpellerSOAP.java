package hw10;

import hw10.core.YandexSpellerSOAP;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;

import static hw10.core.YandexSpellerConstants.*;

public class TestYandexSpellerSOAP {

    @Test
    public void simpleCall(){
        YandexSpellerSOAP
                .with().text(SimpleWord.BROTHER.getWrongVersion())
                .callSOAP()
                .then()
                .body(Matchers.stringContainsInOrder
                        (Arrays.asList(SimpleWord.BROTHER.getWrongVersion(), SimpleWord.BROTHER.getCorrectVersion())));
    }

    @Test
    public void useRequestBuilderToChangeParams(){
        YandexSpellerSOAP.with()
                .language(Language.EN)
                .text(SimpleWord.BROTHER.getWrongVersion())
                .options("6")
                .action(SoapAction.CHECK_TEXTS)
                .callSOAP()
                .then()
                .body(Matchers.stringContainsInOrder
                        (Arrays.asList(SimpleWord.BROTHER.getWrongVersion(), SimpleWord.BROTHER.getCorrectVersion())));
    }
}

