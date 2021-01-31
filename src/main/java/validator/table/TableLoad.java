package validator.table;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TableLoad {
    private Map<String, String> codes = new HashMap<>();
    private String link = "https://en.wikipedia.org/wiki/List_of_country_calling_codes";
    private Integer hashMapSize = 0;
    private Document document = Jsoup.connect(link).get();
    public TableLoad() throws IOException {
        Element table = document.select("table.wikitable").get(1);
        Elements body = table.select("tbody");
        Elements rows = body.select("tr");

        for (Element row : rows) {
            Elements columns = row.select("td");
            if (columns.size() > 2) {
                String name = columns.get(0).text();
                String code = columns.get(1).text().replace(" ", "");
                if(code.contains(",")){
//                   String[] code2 = (code.split(","));
//                    String[] codeValues = code2[0].split(String.valueOf(code.length()));
//
//                    codes.put(Arrays.toString(codeValues), Arrays.toString(code2));
                    String[] keyValues = code.split("=", 2);
                    String[] keys = keyValues[0].split("-");
                    String[] values = keyValues[0].split("-", keys.length);
                    Map<String, String> map = IntStream.range(0, keys.length).boxed()
                            .collect(Collectors.toMap(i -> keys[i], i -> name));
                    System.out.println(map);
                }

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

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
