package com.mtcoding.springv1b.controller.dto;

import lombok.Data;

@Data
public class BoardUpdateRequestDTO {
    private String title;
    private String content;
}
