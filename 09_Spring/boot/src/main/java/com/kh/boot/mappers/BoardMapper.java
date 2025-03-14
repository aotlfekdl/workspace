package com.kh.boot.mappers;

import com.kh.boot.domain.vo.Attachment;
import com.kh.boot.domain.vo.Board;
import com.kh.boot.domain.vo.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;

@Mapper
public interface BoardMapper {
    int selectBoardCount();
    //게시글 목록 조회
    ArrayList<Board> selectBoardList(RowBounds rowBounds);

    //게시글 추가
    int insertBoard(Board board);

    //조회수 증가
    int increaseCount(@Param("bno") int boardNo);
    //
    Board selectBoard(@Param("bno") int boardNo);

    int insertReply(Reply reply);

    ArrayList<Reply> selectReplyList(@Param("boardNo") int boardNo);

    ArrayList<Board> getBoardTopn(RowBounds rowBounds,@Param("other") String other);

    int updateBoard(Board board);

    int insertAttachment1(Board board);

    Board selectBoardNo();

    ArrayList<Attachment> selectAttachment(@Param("bno") int boardNo);

}