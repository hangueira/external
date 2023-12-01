package com.hks.external.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hks.external.api.dto.TransForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receive/bank/account")
@RequiredArgsConstructor
public class BankAccountSystemFrontController {

    private final Gson gson;

    @PostMapping
    public TransForm receive(@RequestBody String requestJsonString) {
        TransForm transForm;
        String ifId = getIfId(requestJsonString);
        return createReponseTransForm(ifId);
    }

    private static TransForm createReponseTransForm(String ifId) {
        TransForm transForm;
        switch (ifId) {
            case "customer":
                transForm = new CustomerFactory().createTransForm(ifId);
                break;
            case "contract":
                transForm = new CustomerFactory().createTransForm(ifId);
                break;
            default:
                transForm = new CustomerFactory().createTransForm(ifId);
                break;
        }

        return transForm;
    }

    /**
     * interfaceId 값 추출
     * @param requestJsonString
     * @return
     */
    private String getIfId(String requestJsonString) {
        JsonObject jsonObject = gson.fromJson(requestJsonString, JsonObject.class);
        return jsonObject.getAsJsonObject("head").get("if_id").getAsString();
    }
}
