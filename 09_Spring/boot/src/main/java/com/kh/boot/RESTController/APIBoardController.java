package com.kh.boot.RESTController;


import com.kh.boot.domain.vo.Reply;
import com.kh.boot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class APIBoardController {

    private final BoardService boardService;

    @PostMapping("reply")
    public String insertReply(Reply r){

        return boardService.insertReply(r) > 0 ? "success" : "fail";
    }

    @GetMapping("/replyList")
    public ArrayList<Reply> selectReplyList(Reply r){

        int boardNo = r.getRefBno();
        ArrayList<Reply> list = boardService.selectReplyList(boardNo);

        System.out.println(list);

        return list;
    }

}
