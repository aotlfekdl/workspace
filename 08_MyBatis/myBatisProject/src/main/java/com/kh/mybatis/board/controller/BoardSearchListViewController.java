package com.kh.mybatis.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.service.BoardService;
import com.kh.mybatis.board.service.BoardServiceImpl;
import com.kh.mybatis.common.PageInfo;

/**
 * Servlet implementation class BoardSearchListViewController
 */
@WebServlet("/searchList.bo")
public class BoardSearchListViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchListViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("condition"); //writer | title | content
		String keyword = request.getParameter("keyword"); //사용자가 입력한 키워드 값
		System.out.println(condition);
		System.out.println(keyword);
		
		int currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("condition", condition);
		
		
		BoardService bService = new BoardServiceImpl();
		
		int listCount = bService.selectSeachCount(map);
		PageInfo pi = new PageInfo(listCount, currentPage, 10, 5);

		int pi1 = 0;
		int pi2 = 0;

		if(pi.getCurrentPage() !=1) {
			pi2 = pi.getBoardLimit()*2;
			pi1 = pi.getBoardLimit()*2-4;
			pi.setMinPage(pi1);
			pi.setMorPage(pi2);
		}
		System.out.println("map : " + map);
		System.out.println("pi1 : " + pi1);

		System.out.println("pi2 : " + pi2);
		
		ArrayList<Board> list = bService.selectSearchList(map, pi);
		
		
		request.setAttribute("list", list);
		
		request.setAttribute("pi", pi);
		
		request.getRequestDispatcher("views/board/boardListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
