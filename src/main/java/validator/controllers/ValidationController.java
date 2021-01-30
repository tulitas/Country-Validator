package validator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import validator.services.Response;
import validator.services.ValidationService;
import validator.table.TableLoad;


import java.io.IOException;


@Controller
@RequestMapping("/")
public class ValidationController {

//    public ValidationController() throws IOException {
//    }

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public @ResponseBody
    Response getCharNum(@RequestParam String text) throws IOException {

        Response result = new Response();
        if (text.indexOf(" ") > 0) text = text.substring(0, text.indexOf(" "));
        TableLoad tableLoad = new TableLoad();
        if (tableLoad.getCodes().get(text) != null) {
            result.setText(tableLoad.getCodes().get(text));
        } else if (tableLoad.getCodes().containsKey(text)) {
            result.setText(String.valueOf(tableLoad.getCodes().containsKey(text)));
        } else result.setText(tableLoad.getCodes().getOrDefault(text, "oops! Where is it?"));
//        if (text != null) {
//            result.setText(text);
//            result.setCount(text.length());
//        }

        return result;
    }

//    @RequestMapping(value = "/getCharNum", method = RequestMethod.GET)
//    public @ResponseBody Response getCharNum(@RequestParam String text) throws IOException {
//
//        Response result = new Response();
//        if (text.indexOf(" ") > 0) text = text.substring(0, text.indexOf(" "));
//        TableLoad tableLoad = new TableLoad();
//        if (tableLoad.getCodes().get(text) != null) {
//            result.setText(tableLoad.getCodes().get(text));
//        } else if (tableLoad.getCodes().containsKey(text)) {
//            result.setText(String.valueOf(tableLoad.getCodes().containsKey(text)));
//        } else result.setText(tableLoad.getCodes().getOrDefault(text, "oops! Where is it?"));
////        if (text != null) {
////            result.setText(text);
////            result.setCount(text.length());
////        }

//        return result;
}

