package com.mtcoding.springv1b.controller;

import com.mtcoding.springv1b.controller.dto.BoardDetailResponseDTO;
import com.mtcoding.springv1b.controller.dto.BoardListResponseDTO;
import com.mtcoding.springv1b.controller.dto.BoardSaveRequestDTO;
import com.mtcoding.springv1b.controller.dto.BoardUpdateRequestDTO;
import com.mtcoding.springv1b.domain.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;


    @GetMapping("/board")
    public String list(HttpServletRequest request) {

        List<BoardListResponseDTO> respDTO = boardService.게시글목록();

        request.setAttribute("models", respDTO);

        return "board/list";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable("id") int id, HttpServletRequest request) {

        BoardDetailResponseDTO respDTO = boardService.게시글상세(id);

        request.setAttribute("model", respDTO);

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

    // selete * from board_tb where title = '스프링; 주소를 보면 쿼리가 보여야함
    // localhost:8080/board?title=스프링 -> String으로 받으면 된다 ? , 쿼리스트림
    // selete * from board_tb where id = 1;
    // localhost:8080/board/1 -> PathValue
    @PostMapping("/board/{id}/update")
    public String updateById(BoardUpdateRequestDTO reqDTO, @PathVariable("id") int id) {
        return "redirect:/board/" + id;
    }
}
