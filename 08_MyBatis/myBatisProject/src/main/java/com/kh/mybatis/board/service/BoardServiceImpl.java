package com.kh.mybatis.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.PageInfo;
import com.kh.mybatis.common.Template;

public class BoardServiceImpl implements BoardService{

	private BoardDao bDao = new BoardDao();
	@Override
	public int selectListCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = bDao.selectListCount(sqlSession);
		
		sqlSession.close();
		return listCount;
	}
	
	@Override
	public ArrayList<Board> selectList(PageInfo pi){
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = bDao.selectList(sqlSession, pi);
		return list;
	}
	
	@Override
	public int selectSeachCount(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = bDao.selectSeachCount(sqlSession, map);
		
		sqlSession.close();
		
		return listCount;
	}
	
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = bDao.selectSearchList(sqlSession, map, pi);
		System.out.println("Dao : " + pi);
		
		return list;
				
	}
	

}
