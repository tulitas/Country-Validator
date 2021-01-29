package validator.services;

import validator.table.TableLoad;

import java.io.IOException;


public class ValidationService {
    private String codeResult;

    public ValidationService(String inputCode) throws IOException {

//        inputCode = inputCode.substring(0, inputCode.length() - 8);


        if (inputCode.indexOf(" ") > 0) inputCode = inputCode.substring(0, inputCode.indexOf(" "));


        TableLoad tableLoad = new TableLoad();
        if (tableLoad.getCodes().get(inputCode) != null) {
            codeResult = tableLoad.getCodes().get(inputCode);
        } else if (tableLoad.getCodes().containsKey(inputCode)) {
            codeResult = String.valueOf(tableLoad.getCodes().containsKey(inputCode));
        } else codeResult = tableLoad.getCodes().getOrDefault(inputCode, "oops! Where is it?");
    }

    public String getCodeResult() {
        return codeResult;
    }

    public void setCodeResult(String codeResult) {
        this.codeResult = codeResult;
    }


}
