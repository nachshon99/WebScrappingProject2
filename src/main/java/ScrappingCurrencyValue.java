import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ScrappingCurrencyValue {

    public static final int SLEEP_TIME = 1000;
    public static final ArrayList<String> CURRENCY_VALUES = currencyValue();
    private static String url;


    public ScrappingCurrencyValue() {
        //url= "https://www.boi.org.il/he/markets/ExchangeRates/Pages/Default.aspx";
        url = "https://il.investing.com/currencies/";

    }

    public static ArrayList currencyValue() {
        ArrayList<String> currencyList = new ArrayList<>();
        new Thread(() -> {
            try {
                while (true) {
                    try {
                        Document foreignCurrencyWeb = Jsoup.connect(url).get();
                        Elements tagElements = foreignCurrencyWeb.getElementsByTag("tr");
                        for (Element element : tagElements) {
                            Elements tdElements = element.getElementsByTag("td");
                            for (int i = 0; i < 10; i++)
                                System.out.println(tdElements.get(i).text());
                                //currencyList.add(currencyValue);
                                //System.out.println(currencyValue);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Thread.sleep(SLEEP_TIME);
                }
            } catch (InterruptedException e) {
            }

        }).start();


        return currencyList;

    }
    /*public static ArrayList currencyValue(){
        ArrayList<String> currencyList = new ArrayList<>();;
        new Thread(() -> {
            try {
                while (true){
                    try {
                        Document foreignCurrencyWeb = Jsoup.connect(url).get();
                        Elements tagElements = foreignCurrencyWeb.getElementsByTag("tr");
                        for (int i = 1; i < tagElements.size()-1; i++){
                            Elements tdElements = tagElements.get(i).getElementsByTag("td");
                            String currencyValue = tdElements.get(3).text();
                            currencyList.add(currencyValue);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Thread.sleep(SLEEP_TIME);
                }
            }catch (InterruptedException e){
            }

        }).start();



        return currencyList;

    }*/

}






/*
String url = "https://www.nirsoft.net/countryip/";

        // Names of countries
        List<String> countriesName =  new ArrayList<>();
        // url of countries
        List<String> urlWebCountriesList = new ArrayList<>();

        try {
            Document ipWeb = Jsoup.connect(url).get();


            ArrayList<Element> aElements = ipWeb.body().select("a");

            for (int i = 28; i < aElements.size(); i++){
                countriesName.add(aElements.get(i).text());
                String urlWebCountry = aElements.get(i).attr("href");
                urlWebCountriesList.add(urlWebCountry);
                //System.out.println(url + urlWebCountry);
            }
            Elements elements = null;
            for (String currentUrl : urlWebCountriesList){
                Document countryWeb = Jsoup.connect(url + currentUrl).get();
                elements = countryWeb.getElementsByClass("iptableheader");


            }
            System.out.println(elements.get(0).text());

            public boolean isInRange(String inputIp, String startIpRange, String endIpRange){
                boolean inRange  = false;

            }
*/
