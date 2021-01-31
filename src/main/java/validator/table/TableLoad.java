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
    private String link = "http://euservice24.info/idc.html";
    private String tableName = "tabpd5";
    private Integer hashMapSize = 0;
    private Document document = Jsoup.connect(link).get();

    public TableLoad() throws IOException {
        Element table = document.select("table." + tableName).get(1);
        Elements body = table.select("tbody");
        Elements rows = body.select("tr");
        for (Element row : rows) {
            Elements columns = row.select("td");
            if (columns.size() > 2) {
                String name = columns.get(1).text();
                String code = columns.get(2).text().replace(" ", "");
                {
                    codes.put(code, name);
                }
            }
        }
//        codes.forEach((n, c) -> System.out.println(n + " -> " + c));
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

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
