package com.mtcoding.springv1b.controller.dto;

import lombok.Data;

@Data
public class BoardDetailResponseDTO {
    private int id;
    private String title;
    private String content;
}
