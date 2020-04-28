package kpu.movie.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kpu.movie.domain.BoardVO;

public class BoardDAO {

	Connection conn = null;
	PreparedStatement pstmt = null; 
	ResultSet rs;
	
	void connect() {
		try {		
			Context initContext=new InitialContext();
	   		Context envContext=(Context)initContext.lookup("java:/comp/env");
	   		DataSource ds=(DataSource)envContext.lookup("jdbc/mysql");
			
	   		conn=ds.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	void disconnect() {
		if(pstmt!=null) {
			try {
				pstmt.close();

			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!= null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<BoardVO> getBoardList()
	{
		connect();
		String list_sql="select * from board";		
		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			pstmt=conn.prepareStatement(list_sql);
			rs=pstmt.executeQuery();
	
			while(rs.next()) {
				BoardVO vo=new BoardVO();
				vo.setbNum(rs.getInt("bNum"));
				vo.setbWriter(rs.getString("bWriter"));
				vo.setbPwd(rs.getString("bPwd"));
				vo.setbSub(rs.getString("bSub"));
				vo.setbContent(rs.getString("bContent"));
				vo.setbHit(rs.getInt("bHit"));
				vo.setbDate(rs.getDate("bDate"));
				boardList.add(vo);
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return boardList;
	}
	
	public BoardVO read(int num){
		connect();
		BoardVO vo = new BoardVO();
		String sql="select * from board where bNum=?"; 
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				vo.setbNum(rs.getInt("bNum"));
				vo.setbWriter(rs.getString("bWriter"));
				vo.setbPwd(rs.getString("bPwd"));
				vo.setbSub(rs.getString("bSub"));
				vo.setbContent(rs.getString("bContent"));
				vo.setbHit(rs.getInt("bHit"));
				vo.setbDate(rs.getDate("bDate"));
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return vo;
	}
	public boolean insert(BoardVO board) {
		connect();
		
		int num=0;
		String insert_sql="";
		int result=0;
		
		try {
			pstmt=conn.prepareStatement("select max(bNum) from board");
			rs=pstmt.executeQuery();
			if(rs.next())
				num=rs.getInt(1)+1;
			else
				num=1;
			
			insert_sql="insert into board values(?,?,?,?,?,?,?)";
			
			pstmt=conn.prepareStatement(insert_sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, board.getbWriter());
			pstmt.setString(3, board.getbPwd());
			pstmt.setString(4, board.getbSub());
			pstmt.setString(5, board.getbContent());
			pstmt.setInt(6, board.getbHit());
			pstmt.setDate(7, java.sql.Date.valueOf(java.time.LocalDate.now()));
		
			result=pstmt.executeUpdate();
			if(result==0) return false;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}		
		return true;
	}
	
	public boolean modify(BoardVO vo){
		connect();
		int result=0;
		String sql="update board set bSub=?, bContent=? where bNum=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getbSub());
			pstmt.setString(2, vo.getbContent());
			pstmt.setInt(3, vo.getbNum());
			result=pstmt.executeUpdate();
			if(result==0) return false;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return true;
	}
	
	public boolean delete(int num) {
		connect();
		String sql="delete from board where bNum=?";
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			result=pstmt.executeUpdate();
			if(result==0)
				return false;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect(); 
		}
		return true;
	}
	
	public void setHitUpdate(int num){
		connect();
		String esql="update board set bHit=bHit+1 where bNum=?";
		try {
			pstmt=conn.prepareStatement(esql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	public boolean isWriter(int num, String pwd) {
		connect();
		String sql="select * from board where bNum=?";
		String bPwd="";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bPwd=rs.getString("bPwd");
			}
			if(pwd.equals(bPwd)) {
				return true;
			}
			else return false;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return false;
	}
}
