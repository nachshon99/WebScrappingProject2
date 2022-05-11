import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ScrappingCurrencyValue {

    public static final int SLEEP_TIME = 5;
    public static final String ID_1 = "pair_1";
    public static final String ID_2 = "pair_2";
    public static final String ID_63 = "pair_63";
    public static final String ID_4 = "pair_4";
    public static final String ID_3 = "pair_3";
    public static final String TD_ELEMENT = "td";
    public static final int INDEX2_ELEMENT = 2;
    public static final int INDEX3_ELEMENT = 3;

    public static final Map<String,String> CURRENCY_VALUES = currencyValue() ;
    private static String url;


    public ScrappingCurrencyValue() {
        url = "https://il.investing.com/currencies/";
    }

    public static Map currencyValue() {
        Map<String,String> currencyMap = new HashMap<>();
        new Thread(() -> {
            try {
                while (true) {
                    try {
                        Document foreignCurrencyWeb = Jsoup.connect(url).get();
                        addElementToMap(currencyMap,foreignCurrencyWeb,ID_1);
                        addElementToMap(currencyMap,foreignCurrencyWeb,ID_2);
                        addElementToMap(currencyMap,foreignCurrencyWeb,ID_63);
                        addElementToMap(currencyMap,foreignCurrencyWeb,ID_4);
                        addElementToMap(currencyMap,foreignCurrencyWeb,ID_3);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Thread.sleep(SLEEP_TIME);
                }
            } catch (InterruptedException e) {
            }

        }).start();

        return currencyMap;
    }

    public static void addElementToMap(Map map, Document document, String id){
        Element eurUsdCurrency = document.body().getElementById(id);
        map.put(eurUsdCurrency.getElementsByTag(TD_ELEMENT).get(INDEX2_ELEMENT).text(),eurUsdCurrency.getElementsByTag(TD_ELEMENT).get(INDEX3_ELEMENT).text());
    }

}




