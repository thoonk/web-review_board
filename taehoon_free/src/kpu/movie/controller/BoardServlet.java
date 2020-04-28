package kpu.movie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kpu.movie.persistence.BoardDAO;
import kpu.movie.domain.BoardVO;
/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html; charset=UTF-8");
		
		BoardDAO dao=new BoardDAO();
		BoardVO vo=new BoardVO();
		String cmd=request.getParameter("key");
		String msg="";
		
		if(cmd.equals("list")) {
			ArrayList<BoardVO> boardList = dao.getBoardList();	
			request.setAttribute("boardList", boardList);
			RequestDispatcher view= request.getRequestDispatcher("board/boardList.jsp");
			view.forward(request, response);
		}
		else if(cmd.equals("showView")) {
			int num=Integer.parseInt(request.getParameter("num"));
			
			vo=dao.read(num);
			if(vo==null) System.out.println("상세보기 실패");
			else msg="상세보기 성공";
			dao.setHitUpdate(num);
			
			request.setAttribute("msg", msg); 
			request.setAttribute("boardDetail", vo);
			RequestDispatcher view=request.getRequestDispatcher("board/boardView.jsp");
			view.forward(request, response);		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out =response.getWriter();
		BoardDAO dao=new BoardDAO();
		BoardVO vo=new BoardVO();
	
		String cmd=request.getParameter("key");
		String msg="";
		
		if(cmd.equals("startWrite")) {
			response.sendRedirect("board/boardWrite.jsp");
		}
		
		else if(cmd.equals("write")) {
		
			vo.setbSub(request.getParameter("bSub"));
			vo.setbWriter(request.getParameter("bWriter"));
			vo.setbPwd(request.getParameter("bPwd"));
			vo.setbContent(request.getParameter("bContent"));
			
			if(dao.insert(vo)) msg="글쓰기가 완료되었습니다!";
			else msg="글쓰기가 실패하였습니다..";
			
			request.setAttribute("msg", msg); 
			request.setAttribute("boardWrite", vo);
			
			ArrayList<BoardVO> boardList = dao.getBoardList();	
			request.setAttribute("boardList", boardList);
			RequestDispatcher view=request.getRequestDispatcher("board/boardList.jsp");
			view.forward(request, response);
  		}
		
		else if(cmd.equals("auth_modify")) {
			int num=Integer.parseInt(request.getParameter("num"));
			vo=dao.read(num);
			
			request.setAttribute("auth_modify", vo);
			RequestDispatcher view=request.getRequestDispatcher("board/authModify.jsp");
			view.forward(request, response);
		}
		else if(cmd.equals("auth_delete")) {
			int num=Integer.parseInt(request.getParameter("num"));
			vo=dao.read(num);
			
			request.setAttribute("delete", vo);
			RequestDispatcher view=request.getRequestDispatcher("board/authDelete.jsp");
			view.forward(request, response);
		}
		
		else if(cmd.equals("authToModify")) {
			int num=Integer.parseInt(request.getParameter("num"));
			boolean userCheck=false;
			
			userCheck=dao.isWriter(num, request.getParameter("pwd"));
			
			vo=dao.read(num);
			request.setAttribute("modify", vo);
			
			if(userCheck==false) {
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('비밀번호가 틀렸습니다.');");
				out.println("location.href='/board/authDelete.jsp'");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
			else if(userCheck==true) {
				RequestDispatcher view=request.getRequestDispatcher("board/boardModify.jsp");
				view.forward(request, response);
			}
		}
		
		else if(cmd.equals("modify")) {
			int num=Integer.parseInt(request.getParameter("num"));
						
			vo.setbNum(num);
			vo.setbSub(request.getParameter("sub"));
			vo.setbContent(request.getParameter("content"));
			
			if(dao.modify(vo)) msg="수정이 완료되었습니다.";
			else msg="수정이 실패하였습니다.";
			
			request.setAttribute("msg", msg); 			
			ArrayList<BoardVO> boardList = dao.getBoardList();	
			request.setAttribute("boardList", boardList);
			RequestDispatcher view=request.getRequestDispatcher("board/boardList.jsp");
			view.forward(request, response);
		}
		
		else if(cmd.equals("delete")) {
			int num=Integer.parseInt(request.getParameter("num"));
			boolean userCheck=false;
			userCheck=dao.isWriter(num, request.getParameter("pwd"));
			
			if(userCheck==false) {
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('비밀번호가 틀렸습니다.');");
				out.println("location.href='/board/authDelete.jsp'");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
			else if(userCheck==true) {
				if(dao.delete(num))	msg="삭제가 완료되었습니다.";
				else msg="삭제가 실패하였습니다.";
				
				ArrayList<BoardVO> boardList = dao.getBoardList();	
				
				request.setAttribute("msg", msg); 
				request.setAttribute("boardList", boardList);
				RequestDispatcher view=request.getRequestDispatcher("board/boardList.jsp");
				view.forward(request, response);	
			}
		}	
	}
}
