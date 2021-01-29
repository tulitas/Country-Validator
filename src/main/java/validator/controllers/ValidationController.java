package validator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import validator.services.ValidationService;

import java.io.IOException;


@Controller
@RequestMapping("/")
public class ValidationController {

    public ValidationController() throws IOException {
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public String ValidateProcess(String inputPhone, Model model) throws IOException {
        ValidationService validationService = new ValidationService(inputPhone);
        model.addAttribute("validationResult", validationService.getCodeResult());
        return "/result";
    }
}
