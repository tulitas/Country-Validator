package validator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import validator.services.Response;
import validator.table.TableLoad;


import java.io.IOException;


@Controller
@RequestMapping("/")
public class ValidationController {
    private String message = "oops! Where is it?";

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public @ResponseBody
    Response getCharNum(@RequestParam String text) throws IOException {
        Response result = new Response();
        if (text.indexOf(" ") > 0) text = text.substring(0, text.indexOf(" "));
        TableLoad tableLoad = new TableLoad();
        if (tableLoad.getCodes().get(text) != null) {
            result.setText(tableLoad.getCodes().get(text));
        } else result.setText(tableLoad.getCodes().getOrDefault(text, message));
        return result;
    }

    @RequestMapping(value = "/makeTest", method = RequestMethod.GET)
    public String test(Model model) throws IOException {
        TableLoad tableLoad = new TableLoad();
        Integer count = tableLoad.getHashMapSize();
        String link = tableLoad.getLink();
        String tableName = tableLoad.getTableName();
        model.addAttribute("count", count);
        model.addAttribute("link", link);
        model.addAttribute("tableName", tableName);
        return "test";
    }

    String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

