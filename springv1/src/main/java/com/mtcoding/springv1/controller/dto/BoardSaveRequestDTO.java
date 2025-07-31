package com.mtcoding.springv1.controller.dto;

import lombok.Data;

@Data  // getter, setter, toString 이 들어가 있음
public class BoardSaveRequestDTO {
    private String title;
    private String content;
}
