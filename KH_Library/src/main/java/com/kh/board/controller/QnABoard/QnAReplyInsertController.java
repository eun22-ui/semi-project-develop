package com.kh.board.controller.QnABoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.FreeboardService;
import com.kh.board.model.service.QnAService;
import com.kh.board.model.service.ReplyService;
import com.kh.board.model.vo.Board;

/**
 * Servlet implementation class QnAReplyInsertController
 */
@WebServlet("/insert.rp")
public class QnAReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAReplyInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		Board q = new QnAService().selectQ(boardNo);
		
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("q", q);
		request.getRequestDispatcher("/views/board/QnABoard/qnaReplyEnrollForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		String content = request.getParameter("content");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		int result = new ReplyService().insertReply(content,boardNo);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "문의글 답변 작성이 완료되었습니다");
			response.sendRedirect(request.getContextPath()+"/qnaBoard?nno=1");
			
		}else {
			request.setAttribute("errorMsg", "문의글 답변 작성에 실패하였습니다");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
	
	
	
	}

}
