package com.mtcoding.springv1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller  // DS(디스패처서블릿)이 endpoint로 찾을 수 있고, 파일을 찾아서 응답
public class BoardController {

    @GetMapping("/board")
    public String list(HttpServletRequest request) {
        request.setAttribute("id", "1");
        request.setAttribute("title", "제목1");
        return "board/list";  // text/html
    }

    @GetMapping("/board/save-form")
    public String saveForm() {
        return "board/save-form";
    }

    @GetMapping("/board/update-form")
    public String updateForm() {
        return "board/update-form";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable("id") int id) {
        return "board/detail";
    }
}
