package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.ProductDTO;

public class ProductDAO {
	// 싱글톤 디자인 패턴 사용하여 인스턴스 생성
	private static ProductDAO instance = new ProductDAO();
	private ProductDAO() {};
	public static ProductDAO getInstance() {
		return instance;
	}
	
	Connection con;
	public void setCon(Connection con) {
		this.con = con;
	}
	
	// 전체 게시물수 조회 기능
	public int getListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(*) FROM product";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("getListCount() - SQL 구문 오류 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	
	public int getListCount(String select ,String keyword) {
		System.out.println(select);
		System.out.println(keyword);
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			if(select.equals("subject")) {
				sql = "SELECT COUNT(*) FROM product WHERE pd_subject LIKE ?";
			} else if(select.equals("name")) {
				sql = "SELECT COUNT(*) FROM product WHERE pd_name LIKE ?";
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("getListCount() - SQL 구문 오류 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	
	// 전체 상품목록 조회 기능
	public ArrayList<ProductDTO> getProductList(int pageNum, int listLimit) {
		ArrayList<ProductDTO> ProductList = new ArrayList<ProductDTO>();
		int startRow = (pageNum-1)*listLimit;
		ProductDTO product = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM product ORDER BY pd_num DESC LIMIT ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, listLimit);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				product = new ProductDTO();
				product.setPd_num(rs.getInt("pd_num"));
				product.setPd_type(rs.getString("pd_type"));
				product.setPd_name(rs.getString("pd_name"));
				product.setPd_price(rs.getInt("pd_price"));
				product.setPd_quan(rs.getInt("pd_quan"));
				product.setPd_file(rs.getString("pd_file"));
				product.setPd_subject(rs.getString("pd_subject"));
				product.setPd_content(rs.getString("pd_content"));
				product.setPd_date(rs.getDate("pd_date"));
				ProductList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getProductList() - SQL 구문 오류 : " + e.getMessage());
		}finally {
			close(pstmt);
			close(rs);
		}
		return ProductList;
	}
	
	// 특정 상품 조회 기능
	public ArrayList<ProductDTO> getProductList(int pageNum, int listLimit, String select, String keyword) {
		ArrayList<ProductDTO> ProductList = new ArrayList<ProductDTO>();
		int startRow = (pageNum-1)*listLimit;
		ProductDTO product = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "";
//			sql = "SELECT * FROM product ORDER BY pd_num DESC LIMIT ?,?";
			if(select.equals("subject")) {
				sql = "SELECT * FROM product WHERE pd_subject LIKE ? ORDER BY pd_num DESC LIMIT ?,?";
			} else if(select.equals("name")) {
				sql = "SELECT * FROM product WHERE pd_name LIKE ? ORDER BY pd_num DESC LIMIT ?,?";
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, listLimit);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				product = new ProductDTO();
				product.setPd_num(rs.getInt("pd_num"));
				product.setPd_type(rs.getString("pd_type"));
				product.setPd_name(rs.getString("pd_name"));
				product.setPd_price(rs.getInt("pd_price"));
				product.setPd_quan(rs.getInt("pd_quan"));
				product.setPd_file(rs.getString("pd_file"));
				product.setPd_subject(rs.getString("pd_subject"));
				product.setPd_content(rs.getString("pd_content"));
				product.setPd_date(rs.getDate("pd_date"));
				ProductList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getProductList() - SQL 구문 오류 : " + e.getMessage());
		}finally {
			close(pstmt);
			close(rs);
		}
		return ProductList;
	}
	
	// 상품 등록 기능
	public int productWrite(ProductDTO product) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		int writeCount = 0;
		int pd_num = 0;
		
			String sql;
			try {
				sql = "SELECT MAX(pd_num) FROM product";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					pd_num = rs.getInt(1)+1;
				}
			} catch (SQLException e) {
				System.out.println("productWrite() - SQL 구문 오류 : " + e.getMessage());
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
			try {
				sql = "INSERT INTO product VALUES (?,?,?,?,?,?,?,?,now())";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setInt(1, pd_num);
				pstmt2.setString(2, product.getPd_type());
				pstmt2.setString(3, product.getPd_name());
				pstmt2.setInt(4, product.getPd_price());
				pstmt2.setInt(5, product.getPd_quan());
				pstmt2.setString(6, product.getPd_file());
				pstmt2.setString(7, product.getPd_subject());
				pstmt2.setString(8, product.getPd_content());
				writeCount = pstmt2.executeUpdate();
			} catch (SQLException e) {
				System.out.println("productWrite() - SQL 구문 오류 : " + e.getMessage());
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt2);
			}
		return writeCount;
	}
	
	// 상품 상세 조회 기능
	public ProductDTO getProductDetail(int pd_num) {
		ProductDTO product = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM product WHERE pd_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pd_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				product = new ProductDTO();
				product.setPd_num(rs.getInt("pd_num"));
				product.setPd_type(rs.getString("pd_type"));
				product.setPd_name(rs.getString("pd_name"));
				product.setPd_price(rs.getInt("pd_price"));
				product.setPd_quan(rs.getInt("pd_quan"));
				product.setPd_file(rs.getString("pd_file"));
				product.setPd_subject(rs.getString("pd_subject"));
				product.setPd_content(rs.getString("pd_content"));
				product.setPd_date(rs.getDate("pd_date"));
			}
		} catch (SQLException e) {
			System.out.println("getProduct() - SQL 구문 오류 : " + e.getMessage());
			e.printStackTrace();
		}
		return product;
	}
	
	// 상품 삭제 기능
	public int getProductDelete(int pd_num) {
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM product WHERE pd_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pd_num);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("deleteProduct() - SQL 구문 오류 : " + e.getMessage());
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
	
	// 상품 정보 변경 기능
	public int getProductUpdate(ProductDTO product) {
		
		int updateCount = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE product SET pd_type=?, pd_name=?, pd_price=?, pd_quan=?,"
									+ "	pd_file=?, pd_subject=?, pd_content=? WHERE pd_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getPd_type());
			pstmt.setString(2, product.getPd_name());
			pstmt.setInt(3, product.getPd_price());
			pstmt.setInt(4, product.getPd_quan());
			pstmt.setString(5, product.getPd_file());
			pstmt.setString(6, product.getPd_subject());
			pstmt.setString(7, product.getPd_content());
			pstmt.setInt(8, product.getPd_num());
			
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("updateProduct() - SQL 구문 오류 : " + e.getMessage());
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
}
