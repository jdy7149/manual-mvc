package com.yong.member.model;

import java.sql.*;
import java.util.*;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public MemberDAO() {
		
	}
	
	public int register(MemberDTO dto) {
		try {
			conn = com.yong.db.YongDB.getConn();
			String sql = "INSERT INTO member (id, pwd, name, email, tel, addr) VALUES (?, ?,  ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getEmail());
			ps.setString(5, dto.getTel());
			ps.setString(6, dto.getAddr());
			
			return ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if (ps != null) ps.close();
				if (conn != null) conn.close();
			} catch(Exception e) {}
		}
	}
	
	public boolean isIdDuplicated(String id) {
		try {
			conn = com.yong.db.YongDB.getConn();
			String sql = "SELECT id FROM member WHERE id = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			return rs.next();
		} catch(Exception e) {
			e.printStackTrace();
			return true;
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (conn != null) conn.close();
			} catch(Exception e) {}
		}
	}
	
	public List<MemberDTO> memberList() {
		try {
			conn = com.yong.db.YongDB.getConn();
			String sql = "SELECT member_idx, id, name, email, tel, addr FROM member ORDER BY member_idx";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			List<MemberDTO> arr = new ArrayList<MemberDTO>();
			while (rs.next()) {
				int idx = rs.getInt("member_idx");
				String id = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				String addr = rs.getString("addr");
				
				MemberDTO dto = new MemberDTO(idx, id, null, name, email, tel, addr);
				
				arr.add(dto);
			}
			
			return arr;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (conn != null) conn.close();
			} catch(Exception e) {}
		}
	}
	
	public MemberDTO login(String id, String pwd) {
		try {
			conn = com.yong.db.YongDB.getConn();
			String sql = "SELECT member_idx, id, name, email, tel, addr FROM member WHERE id = ? AND pwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			
			rs = ps.executeQuery();
			
			MemberDTO res = null;
			
			if (rs.next()) {
				res = new MemberDTO(rs.getInt("member_idx"), rs.getString("id"), null, rs.getString("name"), rs.getString("email"), rs.getString("tel"), rs.getString("addr"));
			}
			
			return res;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (conn != null) conn.close();
			} catch(Exception e) {}
		}
	}
}
