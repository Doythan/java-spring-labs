package com.mtcoding.springv1b.controller;

import com.mtcoding.springv1b.controller.dto.BoardDetailResponseDTO;
import com.mtcoding.springv1b.controller.dto.BoardListResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {

    @GetMapping("/board")
    public String list(HttpServletRequest request) {

        List<BoardListResponseDTO> resDTO = new ArrayList<>();
        BoardListResponseDTO boardlist1 = new BoardListResponseDTO();
        BoardListResponseDTO boardlist2 = new BoardListResponseDTO();
        boardlist1.setId(1);
        boardlist1.setTitle("1번 제목");
        boardlist2.setId(2);
        boardlist2.setTitle("2번 제목");
        resDTO.add(boardlist1);
        resDTO.add(boardlist2);
        request.setAttribute("models", resDTO);

        return "board/list";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable("id") int id, HttpServletRequest request) {

        BoardDetailResponseDTO resDTO = new BoardDetailResponseDTO();
        resDTO.setId(id);
        resDTO.setTitle("제목"+id);
        resDTO.setContent("내용"+id);
        request.setAttribute("model", resDTO);

        return "board/detail";
    }

    @GetMapping("/board/save-form")
    public String saveForm(){
        return "board/save-form";
    }

    @GetMapping("/board/{id}/update-form")
    public String updateForm(@PathVariable("id") int id, HttpServletRequest request){
        BoardDetailResponseDTO resDTO = new BoardDetailResponseDTO();
        resDTO.setId(id);
        resDTO.setTitle("기존 제목");
        resDTO.setContent("기존 내용");
        request.setAttribute("model", resDTO);
        return "board/update-form";
    }
}
