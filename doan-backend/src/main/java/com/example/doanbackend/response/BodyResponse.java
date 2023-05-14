package com.example.doanbackend.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BodyResponse {
    private int status;
    private Object data;

}
