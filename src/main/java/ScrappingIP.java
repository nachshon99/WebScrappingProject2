import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ScrappingIP {
    public ScrappingIP(){
        try{
            Document ipWeb = Jsoup.connect("https://lite.ip2location.com/ip-address-ranges-by-country").get();
            Elements elements = ipWeb.getElementsByTag("div");
            //https://lite.ip2location.com/afghanistan-ip-address-ranges
            System.out.println(elements);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
