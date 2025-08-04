package com.mtcoding.springv1b.domain;

import com.mtcoding.springv1b.controller.dto.BoardDetailResponseDTO;
import com.mtcoding.springv1b.controller.dto.BoardListResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 비즈니스 로직, 트랜잭션 관리, 응답DTO 생성
@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public List<BoardListResponseDTO> 게시글목록() {
        List<Board> boardList = boardRepository.findAll();

        List<BoardListResponseDTO> respDTO = new ArrayList<>();
        for (Board board : boardList) {
            BoardListResponseDTO boardListResponseDTO = new BoardListResponseDTO();
            boardListResponseDTO.setId(board.getId());
            boardListResponseDTO.setTitle(board.getTitle());
            respDTO.add(boardListResponseDTO);
        }

        return respDTO;
    }


    public BoardDetailResponseDTO  게시글상세(int id){
        Board board = boardRepository.findById(id);

        BoardDetailResponseDTO respDTO = new BoardDetailResponseDTO();
        respDTO.setId(board.getId());
        respDTO.setTitle(board.getTitle());
        respDTO.setContent(board.getContent());

        return respDTO;
    }

    public void 게시글쓰기(){}

    public void 게시글삭제(){}

    public void 게시글수정(){}
}
