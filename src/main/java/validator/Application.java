package validator;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Configuration
public class Application extends SpringBootServletInitializer {
    private static HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Document document =
                Jsoup.connect(
                        "https://en.wikipedia.org/wiki/List_of_country_calling_codes").get();
        Element table = document.select("table.wikitable").get(1);
        Elements body = table.select("tbody");
        Elements rows = body.select("tr");

        Map<String, String> codes =
                new HashMap<>();
        for (Element row : rows) {
            Elements columns = row.select("td");
            if (columns.size() > 2) {
                String name = columns.get(0).text();
                String code = columns.get(1).text();
                codes.put(code, name);
            }
        }
        codes.forEach((n,c) -> System.out.println(n + " -> " + c));
        System.out.println(codes.get("+371"));
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {

        return applicationBuilder.sources(Application.class);
    }
}