package validator.table;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TableLoad {
    private Map<String, String> codes = new HashMap<>();
    private Integer hashMapSize = 0;
    public TableLoad() throws IOException {
        Document document = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_country_calling_codes").get();
        Element table = document.select("table.wikitable").get(1);
        Elements body = table.select("tbody");
        Elements rows = body.select("tr");

        for (Element row : rows) {
            Elements columns = row.select("td");
            if (columns.size() > 2) {
                String name = columns.get(0).text();
                String code = columns.get(1).text().replace(" ", "");
                codes.put(code, name);
            }
        }
        codes.forEach((n, c) -> System.out.println(n + " -> " + c));
        hashMapSize = codes.size();
    }

    public Map<String, String> getCodes() {
        return codes;
    }

    public void setCodes(Map<String, String> codes) {
        this.codes = codes;
    }

    public Integer getHashMapSize() {
        return hashMapSize;
    }

    public void setHashMapSize(Integer hashMapSize) {
        this.hashMapSize = hashMapSize;
    }
}
