package validator.services;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import validator.table.TableLoad;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ValidationService {
    private String codeResult;
    private TableLoad tableLoad = new TableLoad();

    public ValidationService(String inputCode) throws IOException {

        if(tableLoad.getCodes().get(inputCode) != null) {
            codeResult = tableLoad.getCodes().get(inputCode);
        }else codeResult = tableLoad.getCodes().getOrDefault(inputCode, "oops! Where is it?");
    }

    public String getCodeResult() {
        return codeResult;
    }

    public void setCodeResult(String codeResult) {
        this.codeResult = codeResult;
    }
}
