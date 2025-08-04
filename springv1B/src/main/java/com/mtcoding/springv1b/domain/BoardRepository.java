package com.mtcoding.springv1b.domain;

import com.mtcoding.springv1b.controller.dto.BoardUpdateRequestDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardRepository {
    private final EntityManager em;

    public void deleteById(int id) {
        Query query = em.createNativeQuery("delete from board_tb where id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public void updateById(int id, String title, String content) {
        Query query = em.createNativeQuery("update board_tb set title = ?, content = ? where id = ?");
        query.setParameter(1, title);
        query.setParameter(2, content);
        query.setParameter(3, id);
        query.executeUpdate();  // insert, delete, update 시에 사용
    }

    public void save(String title, String content) {
        Query query = em.createNativeQuery("insert into board_tb(title, content) values(?, ?)");
        query.setParameter(1, title);
        query.setParameter(2, content);
        query.executeUpdate();  // insert, delete, update 시에 사용
    }

    public List<Board> findAll() {
        Query query = em.createNativeQuery("SELECT id, title, content FROM board_tb order by id desc");

        List<Object[]> obsList = query.getResultList();

        List<Board> boardList = new ArrayList<>();
        for(Object[] obs : obsList) {
            Integer v1 = (Integer) obs[0];
            String v2 = (String) obs[1];
            String v3 = (String) obs[2];
            Board board = new Board(v1, v2, v3);
            boardList.add(board);
        }

        return boardList;
    }

    public List<Board> findAllV2() {
        Query query = em.createNativeQuery("SELECT id, title, content FROM board_tb order by id desc", Board.class);
        return query.getResultList();
    }

    // DB에서 id로 조회해서 Board로 리턴하기
    public Board findById(int id) {
        Query query = em.createNativeQuery("SELECT id, title, content FROM board_tb WHERE id = ?");
        query.setParameter(1, id);

        try {
            Object[] obs = (Object[]) query.getSingleResult();

            Integer v1 = (Integer) obs[0];
            String v2 = (String) obs[1];
            String v3 = (String) obs[2];

//        System.out.println("id:" + v1);
//        System.out.println("title:" + v2);
//        System.out.println("content:" + v3);

            // Entity Object Maping
            Board board = new Board(v1, v2, v3);
            return board;
        } catch (RuntimeException e) {
            return null;
        }
    }

    public Board findByIdV2(int id) {
        Query query = em.createNativeQuery("SELECT id, title, content FROM board_tb WHERE id = ?", Board.class);
        query.setParameter(1, id);

        try {
            return (Board) query.getSingleResult();
        } catch (RuntimeException e) {
            return null;
        }
    }
}
