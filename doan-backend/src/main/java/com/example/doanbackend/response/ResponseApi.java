package com.example.doanbackend.response;

import lombok.*;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;


public class ResponseApi extends ResponseEntity<ObjectResponse> {


    public ResponseApi(HttpStatusCode status) {
        super(status);
    }

    public ResponseApi(ObjectResponse body, HttpStatusCode status) {
        super(body, status);
    }

    public ResponseApi(MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(headers, status);
    }

    public ResponseApi(ObjectResponse body, MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(body, headers, status);
    }

    public ResponseApi(ObjectResponse body, MultiValueMap<String, String> headers, int rawStatus) {
        super(body, headers, rawStatus);
    }
}
