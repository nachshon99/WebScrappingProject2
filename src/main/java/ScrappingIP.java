import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScrappingIP {
    public ScrappingIP() {
        String url = "https://lite.ip2location.com/ip-address-ranges-by-country";
        List<String> citiesName =  new ArrayList<>();

        try {
            Document ipWeb = Jsoup.connect(url).get();
            ArrayList<Element> elements = ipWeb.getElementsByClass("card");
            for (Element element: elements){
                citiesName.add(element.text());
            }

            /*System.out.println(citiesName);*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
