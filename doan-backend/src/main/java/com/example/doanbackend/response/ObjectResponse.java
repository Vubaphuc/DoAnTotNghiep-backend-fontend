package com.example.doanbackend.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObjectResponse {
    private int httpStatus;
    private Object data;
    private String messageId;
    private Object errorMessage;
}
