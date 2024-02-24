package com.happydev.FoodCoService.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class ResponseModel<T> extends ResponseEntity<T> {
    
    private static String message;
    
    public ResponseModel(HttpStatusCode status) {
        super(status);
    }

    public ResponseModel(T body, HttpStatusCode status) {
        super(body, status);
    }

    public ResponseModel(MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(headers, status);
    }

    public ResponseModel(T body, MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(body, headers, status);
    }

    public ResponseModel(T body, MultiValueMap<String, String> headers, int rawStatus) {
        super(body, headers, rawStatus);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
