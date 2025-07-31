package com.mtcoding.springv1b.controller;

import com.mtcoding.springv1b.controller.dto.BoardDetailResponseDTO;
import com.mtcoding.springv1b.controller.dto.BoardListResponseDTO;
import com.mtcoding.springv1b.controller.dto.BoardSaveRequestDTO;
import com.mtcoding.springv1b.controller.dto.BoardUpdateRequestDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {

    @GetMapping("/board")
    public String list(HttpServletRequest request) {

        List<BoardListResponseDTO> resDTO = new ArrayList<>();
        BoardListResponseDTO boardlist1 = new BoardListResponseDTO();
        BoardListResponseDTO boardlist2 = new BoardListResponseDTO();
        BoardListResponseDTO boardlist3 = new BoardListResponseDTO();
        boardlist1.setId(1);
        boardlist1.setTitle("1번 제목");
        boardlist2.setId(2);
        boardlist2.setTitle("2번 제목");
        boardlist3.setId(3);
        boardlist3.setTitle("3번 제목");
        resDTO.add(boardlist1);
        resDTO.add(boardlist2);
        resDTO.add(boardlist3);
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

    @PostMapping("/board/save")
    public String save(BoardSaveRequestDTO reqDTO) {
        return "redirect:/board";
    }

    @PostMapping("/board/{id}/delete")
    public String deleteById(@PathVariable("id") int id) {
        return "redirect:/board";
    }

    @PostMapping("/board/{id}/update")
    public String updateById(BoardUpdateRequestDTO reqDTO, @PathVariable("id") int id) {
        return "redirect:/board/" + id;
    }
}
