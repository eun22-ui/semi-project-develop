package com.kh.board.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Reply;
import com.kh.common.JDBCTemplate;
import com.kh.common.PageInfo;

public class QnADao {
	
	private Properties prop = new Properties();
	
		public QnADao() {
			
			String filePath = QnADao.class.getResource("/resources/mappers/board-mapper.xml").getPath();
			
			try {
				prop.loadFromXML(new FileInputStream(filePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		
		
		
	// 게시글 조회
	public int QlistCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = prop.getProperty("QlistCount");
		
		try {
			stmt = conn.createStatement();
			rset= stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return listCount;
	}
	
		
		
	// 조회수 증가
	public int increaseCount(Connection conn, int bno) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}


	
	// Q 리스트 조회 
	public ArrayList<Board> selectQList(Connection conn, PageInfo pi) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> b = new ArrayList<>();
		String sql = prop.getProperty("selectQList");
		
		// 시작번호 : (currentPage-1)*게시글 보여줄 수+1
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;

		// 끝번호 : 현재페이지 수 * 게시글 보여줄 수
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				b.add(new Board(
								 rset.getInt("BOARD_NO"),
								 rset.getInt("BOARD_TYPE_NO"),
								 rset.getString("USER_ID"),
								 rset.getString("BOARD_TITLE"),
								 rset.getString("BOARD_CONTENT"),
								 rset.getDate("CREATE_DATE"),
								 rset.getInt("COUNT")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return b;
	}




	
	// R 리스트 조회
	public ArrayList<Reply> selectRList(Connection conn, PageInfo pi) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Reply> r = new ArrayList<>();
		String sql = prop.getProperty("selectRList");
		
		// 시작번호 : (currentPage-1)*게시글 보여줄 수+1
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;

		// 끝번호 : 현재페이지 수 * 게시글 보여줄 수
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
		while(rset.next()) {
			
			r.add(new Reply(
							rset.getInt("BOARD_NO"),
							rset.getString("USER_ID"),
							rset.getString("REPLY_CONTENT"),
							rset.getDate("CREATE_DATE")
							));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return r;
	}




	// 게시글 작성
	public int insertQnA(Connection conn, String title, String content, int userId) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertQnA");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userId);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}




	// 질문글 수정
	public int updateQnA(Connection conn, int boardNo, String title, String content) {
	
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateQnA");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}




	// 질문글 삭제
	public int deleteQnA(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteQnA");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}



	// 답변작성시 글 내용 가져오기
	public Board selectQ(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board q = new Board();
		String sql = prop.getProperty("selectQ");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				q.setBoardNo(rset.getInt("BOARD_NO"));
				q.setBoardTitle(rset.getString("BOARD_TITLE"));
				q.setBoardContent(rset.getString("BOARD_CONTENT"));
				q.setDate(rset.getDate("CREATE_DATE"));
				q.setCount(rset.getInt("COUNT"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return q;
	}



}