package validator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import validator.services.ValidationService;

import java.io.IOException;


@Controller
@RequestMapping("/")
public class ValidationController {

    public ValidationController() throws IOException {
    }

    @RequestMapping(value = "/validate")
    public String ValidateProcess(String inputPhone, Model model) throws IOException {
        ValidationService validationService = new ValidationService(inputPhone);
        model.addAttribute("validationResult", validationService.getCodeResult());
        System.out.println(inputPhone);
        return "/result";
    }
}
