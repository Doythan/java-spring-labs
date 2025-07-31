package com.mtcoding.springv1.controller;

import com.mtcoding.springv1.controller.dto.BoardDetailResponseDTO;
import com.mtcoding.springv1.controller.dto.BoardSaveRequestDTO;
import com.mtcoding.springv1.controller.dto.BoardResponseDTO;
import com.mtcoding.springv1.controller.dto.BoardUpdateRequestDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller  // DS(디스패처서블릿)이 endpoint로 찾을 수 있고, 파일을 찾아서 응답
public class BoardController {

    // 게시글 수정 처리 (POST)
    @PostMapping("/board/{id}/update")
    public String update(BoardUpdateRequestDTO boardUpdateRequestDTO, @PathVariable int id) {
        return "redirect:/board/" + id;
    }

    // 게시글 삭제 처리 (POST)
    @PostMapping("/board/{id}/delete")
    public String deleteById(@PathVariable("id") int id) {
        return "redirect:/board";
    }

    // 게시글 저장(삽입) 처리 (POST)
    @PostMapping("/board/save")
    public String save(BoardSaveRequestDTO reqDTO) {
        return "redirect:/board";
    }

    // 게시글 목록 조회 (GET)
    @GetMapping("/board")
    public String list(HttpServletRequest request) {

        List<BoardResponseDTO> resDTO = new ArrayList<>();
        BoardResponseDTO b1 = new BoardResponseDTO();
        b1.setId(1);
        b1.setTitle("제목1");
        BoardResponseDTO b2 = new BoardResponseDTO();
        b2.setId(2);
        b2.setTitle("제목2");
        BoardResponseDTO b3 = new BoardResponseDTO();
        b3.setId(3);
        b3.setTitle("제목3");

        resDTO.add(b1);
        resDTO.add(b2);
        resDTO.add(b3);

        request.setAttribute("models", resDTO);

        return "board/list";
    }

    // 게시글 작성 폼 페이지 (GET)
    @GetMapping("/board/save-form")
    public String saveForm() {
        return "board/save-form";
    }

    // 게시글 수정 폼 페이지 (GET)
    @GetMapping("/board/{id}/update-form")
    public String updateForm(@PathVariable("id") int id, HttpServletRequest request) {
        BoardUpdateRequestDTO boardUpdateRequestDTO = new BoardUpdateRequestDTO();
        boardUpdateRequestDTO.setId(id);
        boardUpdateRequestDTO.setTitle("기존의 제목");
        boardUpdateRequestDTO.setContent("기존의 내용");
        request.setAttribute("model", boardUpdateRequestDTO);
        return "board/update-form";
    }

    // 게시글 상세 페이지 (GET)
    @GetMapping("/board/{id}")
    public String detail(@PathVariable("id") int id, HttpServletRequest request) {
        BoardDetailResponseDTO resDTO = new BoardDetailResponseDTO();
        resDTO.setId(id);
        resDTO.setTitle("제목");
        resDTO.setContent("내용");
        request.setAttribute("model", resDTO);
        return "board/detail";
    }
}
