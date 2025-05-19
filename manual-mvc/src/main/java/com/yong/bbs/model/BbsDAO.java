package com.yong.bbs.model;

import java.sql.*;
import java.util.*;

public class BbsDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public BbsDAO() {
		
	}
	
	public int maxRef() {
		try {
			conn = com.yong.db.YongDB.getConn();
			String sql = "SELECT NVL(MAX(ref), 0) AS max_ref FROM bbs";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("max_ref") + 1;
			}
			
			return -1;
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (conn != null) conn.close();
			} catch(Exception e) {}
		}
	}
	
	public int maxRow() {
		try {
			conn = com.yong.db.YongDB.getConn();
			String sql = "SELECT COUNT(*) AS count FROM bbs";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("count") == 0 ? 1 : rs.getInt("count");
			}
			return 1;
		} catch(Exception e) {
			e.printStackTrace();
			return 1;
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (conn != null) conn.close();
			} catch(Exception e) {}
		}
	}
	
	public int post(BbsDTO dto) {
		try {
			conn = com.yong.db.YongDB.getConn();
			String sql = "INSERT INTO bbs (title, writer, content, ref, lev, sunbun) VALUES (?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getWriter());
			ps.setString(3, dto.getContent());
			ps.setInt(4, dto.getRef());
			ps.setInt(5, dto.getLev());
			ps.setInt(6, dto.getSunbun());
			
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
	
	public List<BbsDTO> bbsList(int curPage){
		try {
			int rows = 5;
			int pages = 5;
			int maxRow = maxRow();
			int maxPages = maxRow % rows == 0 ? maxRow / rows : maxRow / rows + 1;
			
			conn = com.yong.db.YongDB.getConn();
			String sql = "SELECT * "
					+ "FROM (SELECT ROW_NUMBER() OVER (ORDER BY ref DESC, sunbun ASC) AS rn, idx, title, writer, write_date, view_num, ref, lev, sunbun "
					+ "    FROM bbs "
					+ "    ORDER BY ref DESC, sunbun ASC) "
					+ "WHERE rn BETWEEN ? AND ?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, (curPage - 1) * rows + 1);
			ps.setInt(2, curPage * rows);
			
			rs = ps.executeQuery();
			
			List<BbsDTO> res = new ArrayList<BbsDTO>();
			while (rs.next()) {
				BbsDTO dto = new BbsDTO(rs.getInt("idx"), rs.getString("title"), rs.getString("writer"), rs.getDate("write_date"), null,
						rs.getInt("view_num"), rs.getInt("ref"), rs.getInt("lev"), rs.getInt("sunbun"));
				res.add(dto);
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
	
	public int[] pagination(int curPage) {
		try {
			int rows = 5;
			int pages = 5;
			int maxRow = maxRow();

			int maxPages = maxRow % rows == 0 ? maxRow / rows : maxRow / rows + 1;
			
			int begin = ((curPage - 1) / pages) * pages + 1;
			int end = begin + pages - 1;
			
			if (end > maxPages) end = maxPages;
			
			int res[] = {begin, end, maxPages};
			
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
	
	public BbsDTO viewPost(int idx) {
		try {
			conn = com.yong.db.YongDB.getConn();
			String sql = "SELECT idx, title, writer, write_date, content, view_num, ref, lev, sunbun FROM bbs WHERE idx = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, idx);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				return new BbsDTO(rs.getInt("idx"), rs.getString("title"), rs.getString("writer"), rs.getDate("write_date"), 
						rs.getString("content"), rs.getInt("view_num"), rs.getInt("ref"), rs.getInt("lev"), rs.getInt("sunbun"));
			}
			
			return null;
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
