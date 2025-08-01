package com.mtcoding.springv1b.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(BoardRepository.class)
@DataJpaTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void findAll_test() {
        // given
        // when
        List<Board> boardList = boardRepository.findAll();
        // eye
        for (Board board : boardList) {
            System.out.println(board.getId());
            System.out.println(board.getTitle());
            System.out.println(board.getContent());
            System.out.println("-----------------");
        }
    }

    @Test
    public void findAllV2_test() {
        // given
        // when
        List<Board> boardList = boardRepository.findAllV2();
        for (Board board : boardList) {
            System.out.println(board.getId());
            System.out.println(board.getTitle());
            System.out.println(board.getContent());
        }
    }

    @Test
    public void findByIdV2_test() {
        // given
        int id = 2;

        // when
        Board board = boardRepository.findByIdV2(id);

        // eye (눈으로 검증하기)
        if (board == null) {
            System.out.println("조회가 안됐어 ! 그 번호 없나봐");
        } else {
            System.out.println(board.getId());
            System.out.println(board.getTitle());
            System.out.println(board.getContent());
        }
    }

    @Test
    public void findById_test() {
        // given
        int id = 6;

        // when
        Board board = boardRepository.findById(id);

        // eye (눈으로 검증하기)
        if (board == null) {
            System.out.println("조회가 안됐어 ! 그 번호 없나봐");
        } else {
            System.out.println(board.getId());
            System.out.println(board.getTitle());
            System.out.println(board.getContent());
        }
    }
}
