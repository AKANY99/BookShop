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
	
	// 타입과 상태가 전체일 때 상품 조회
	public ArrayList<ProductDTO> getProductList(String start_date, String end_date, String search_input, int pdPageNum, int listLimit) {
		System.out.println(search_input);
		ArrayList<ProductDTO> list = null;
		ProductDTO product = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int startRow = (pdPageNum - 1) * listLimit;
		
			try {
				String sql = "SELECT * FROM product WHERE pd_date>=? AND pd_date<=? AND pd_subject LIKE ? ORDER BY pd_num DESC LIMIT ?,?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, start_date);
				pstmt.setString(2, end_date);
				pstmt.setString(3, "%" + search_input + "%");
				pstmt.setInt(4, startRow);
				pstmt.setInt(5, listLimit);
				rs = pstmt.executeQuery();
				list = new ArrayList<ProductDTO>();
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
					list.add(product);
				}
			} catch (SQLException e) {
				System.out.println("getProductList(S,S,S,I,I) - SQL구문 오류 - " + e.getMessage());
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
		return list;
	}
	
	// 타입과 상태가 전체일 때 상품갯수 조회 기능
	public int getListCount(String start_date, String end_date, String search_input) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT COUNT(*) FROM product WHERE pd_date>=? AND pd_date<=? AND pd_subject LIKE ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, start_date);
			pstmt.setString(2, end_date);
			pstmt.setString(3, "%" + search_input + "%");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("getListCount(S,S,S) - SQL 구문 오류 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	
	// 타입별 상품현황란 건수 표시
	public int selectListCount(String Condition) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT COUNT(*) FROM product WHERE pd_quan=0";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("selectListCount(S) - SQL구문 오류 - " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return count;
	}
	
	// 검색조건에 맞는 상품들 조회
	public ArrayList<ProductDTO> getProductList(String start_date, String end_date, String pd_type, String pd_quan, String search_input, int pdPageNum, int listLimit) {
//		System.out.println(start_date + "/" + end_date + "/" + pd_type + "/" + pd_quan + "/" + search_input);
		ArrayList<ProductDTO> list = null;
		ProductDTO product = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int startRow = (pdPageNum - 1) * listLimit;
			try {
				String sql = "";
				if(pd_type.equals("all")) {
					if(pd_quan.equals("true")) {
						// 타입이 전체이고 상태가 재고있음일 때
						pd_quan = "0";
						sql = "SELECT * FROM product WHERE pd_date>=? AND pd_date<=? AND NOT pd_type=? AND pd_quan>? AND pd_subject LIKE ? ORDER BY pd_num DESC LIMIT ?,?";
					} else {
						// 타입이 전체이고 상태가 품절일 때
						pd_quan = "0";
						sql = "SELECT * FROM product WHERE pd_date>=? AND pd_date<=? AND NOT pd_type=? AND pd_quan=? AND pd_subject LIKE ? ORDER BY pd_num DESC LIMIT ?,?";
					}
				} else if(!pd_type.equals("all")) {
					if(pd_quan.equals("true")) {
						// 타입이 전체가 아니고 상태가 재고있음일 때
						pd_quan = "0";
						sql = "SELECT * FROM product WHERE pd_date>=? AND pd_date<=? AND pd_type=? AND pd_quan>? AND pd_subject LIKE ? ORDER BY pd_num DESC LIMIT ?,?";
					} else if(pd_quan.equals("false")) {
						// 타입이 전체가 아니고 상태가 품절일 때
						pd_quan = "0";
						sql = "SELECT * FROM product WHERE pd_date>=? AND pd_date<=? AND pd_type=? AND pd_quan=? AND pd_subject LIKE ? ORDER BY pd_num DESC LIMIT ?,?";
					} else {
						// 타입이 전체가 아니고 상태가 전체일 때
						pd_quan = "0";
						sql = "SELECT * FROM product WHERE pd_date>=? AND pd_date<=? AND pd_type=? AND pd_quan>=? AND pd_subject LIKE ? ORDER BY pd_num DESC LIMIT ?,?";
					}
				}
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, start_date);
				pstmt.setString(2, end_date);
				pstmt.setString(3, pd_type);
				pstmt.setString(4, pd_quan);
				pstmt.setString(5, "%" + search_input + "%");
				pstmt.setInt(6, startRow);
				pstmt.setInt(7, listLimit);
				rs = pstmt.executeQuery();
				list = new ArrayList<ProductDTO>();
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
					list.add(product);
				}
			} catch (SQLException e) {
				System.out.println("getProductList(S,S,S,S,S,I,I) - SQL구문 오류 - " + e.getMessage());
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
		
		return list;
	}
	
	// 헤더의 검색 기능 수행
	// searchType(통합검색,제목검색,작가검색)에 따라 그에 맞는 검색어 키워드로 검색
	// 정렬(sort)의 기본값은 pd_num(최신순 last)이고 검색결과에서 사용자가 선택한 정렬방식에 따라 정렬
	public ArrayList<ProductDTO> getSearchProductList(String searchType, String search, String sort) {
		ArrayList<ProductDTO> SearchProductList = new ArrayList<ProductDTO>();
		ProductDTO product = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			if(searchType.equals("subject")) {
				if(sort.equals("last")) {
					String sql = "SELECT * FROM product WHERE pd_subject LIKE ? ORDER BY pd_num DESC";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "%" + search + "%");
					rs = pstmt.executeQuery();
				}
				else if(sort.equals("price")) {
					String sql = "SELECT * FROM product WHERE pd_subject LIKE ? ORDER BY pd_price ASC, pd_num DESC";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "%" + search + "%");
					rs = pstmt.executeQuery();
				}
				else {
					String sql = "SELECT * FROM product WHERE pd_subject LIKE ? ORDER BY pd_count DESC, pd_num DESC";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "%" + search + "%");
					rs = pstmt.executeQuery();
				}
			}
			else if(searchType.equals("writer")) {
				if(sort.equals("last")) {
					String sql = "SELECT * FROM product WHERE pd_name LIKE ? ORDER BY pd_num DESC";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "%" + search + "%");
					rs = pstmt.executeQuery();
				}
				else if(sort.equals("price")) {
					String sql = "SELECT * FROM product WHERE pd_name LIKE ? ORDER BY pd_price ASC, pd_num DESC";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "%" + search + "%");
					rs = pstmt.executeQuery();
				}
				else {
					String sql = "SELECT * FROM product WHERE pd_name LIKE ? ORDER BY pd_count DESC, pd_num DESC";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "%" + search + "%");
					rs = pstmt.executeQuery();
				}
			}
			else {
				if(sort.equals("last")) {
					String sql = "SELECT * FROM product WHERE pd_subject LIKE ? OR pd_name LIKE ? ORDER BY pd_num DESC";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "%" + search + "%");
					pstmt.setString(2, "%" + search + "%");
					rs = pstmt.executeQuery();
				}
				else if(sort.equals("price")) {
					String sql = "SELECT * FROM product WHERE pd_subject LIKE ? OR pd_name LIKE ? ORDER BY pd_price ASC, pd_num DESC";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "%" + search + "%");
					pstmt.setString(2, "%" + search + "%");
					rs = pstmt.executeQuery();
				}
				else {
					String sql = "SELECT * FROM product WHERE pd_subject LIKE ? OR pd_name LIKE ? ORDER BY pd_count DESC, pd_num DESC";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "%" + search + "%");
					pstmt.setString(2, "%" + search + "%");
					rs = pstmt.executeQuery();
				}
			}
				
			while(rs.next()) {
				product = new ProductDTO();
				product.setPd_num(rs.getInt("pd_num"));
				product.setPd_name(rs.getString("pd_name"));
				product.setPd_price(rs.getInt("pd_price"));
				product.setPd_quan(rs.getInt("pd_quan"));
				product.setPd_file(rs.getString("pd_file"));
				product.setPd_subject(rs.getString("pd_subject"));
				product.setPd_content(rs.getString("pd_content"));
				product.setPd_type(rs.getString("pd_type"));
				product.setPd_count(rs.getInt("pd_count"));
				SearchProductList.add(product);
			}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("getSearchProductList() - SQL 구문 오류 : " + e.getMessage());
			} finally {
				close(pstmt);
				close(rs);
			}
		return SearchProductList;
	}
		
		// 사용자의 상품 조회 & 사용자가 지정한 방식으로 정렬
		// 선택한 카테고리가 전체목록이면 파라미터로 받아온 타입이 'all' 이고 전체 상품 목록 출력
		// 선택한 카테고리가 '국내도서'나 '해외도서' 일경우 각 타입에 맞는 상품 출력 
		// sort 최신순이 기본값  
		// 사용자가 선택한 정렬방식에 따라 최신순(last), 가격순(price), 판매량순(rate) 로 정렬
		// 같은 값을 가진 상품끼리는 pd_num(PRIMARY KEY) 으로 정렬
		public ArrayList<ProductDTO> getUserProductList(String type, String sort) {
			ArrayList<ProductDTO> ProductList = new ArrayList<ProductDTO>();
			ProductDTO product = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
					
			try {
				if(type.equals("all")) {
					if(sort.equals("last")) {
						String sql = "SELECT * FROM product ORDER BY pd_num DESC";
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery();
					} 
					else if(sort.equals("price")) {
						String sql = "SELECT * FROM product ORDER BY pd_price ASC, pd_num DESC";
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery();
					}
					else {
						String sql = "SELECT * FROM product ORDER BY pd_count DESC, pd_num DESC";
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery();
					}
				}
				else {
					if(sort.equals("last")) {
						String sql = "SELECT * FROM product WHERE pd_type=? ORDER BY pd_num DESC";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, type);
						rs = pstmt.executeQuery();
					} 
					else if(sort.equals("price")) {
						String sql = "SELECT * FROM product WHERE pd_type=? ORDER BY pd_price ASC, pd_num DESC";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, type);
						rs = pstmt.executeQuery();
					}
					else {
						String sql = "SELECT * FROM product WHERE pd_type=? ORDER BY pd_count DESC, pd_num DESC";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, type);
						rs = pstmt.executeQuery();
					}
				}
					
				while(rs.next()) {
					product = new ProductDTO();
					product.setPd_num(rs.getInt("pd_num"));
					product.setPd_name(rs.getString("pd_name"));
					product.setPd_price(rs.getInt("pd_price"));
					product.setPd_quan(rs.getInt("pd_quan"));
					product.setPd_file(rs.getString("pd_file"));
					product.setPd_subject(rs.getString("pd_subject"));
					product.setPd_content(rs.getString("pd_content"));
					product.setPd_type(rs.getString("pd_type"));
					product.setPd_count(rs.getInt("pd_count"));
					ProductList.add(product);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("getUserProductList() - SQL 구문 오류 : " + e.getMessage());
			}finally {
				close(pstmt);
				close(rs);
			}
			return ProductList;
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
		
	// 검색조건에 맞는 상품갯수 조회
	public int getListCount(String start_date, String end_date, String pd_type, String pd_quan, String search_input) {
//		System.out.println(start_date + "/" + end_date + "/" + pd_type + "/" + pd_quan + "/" + search_input);
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			try {
				String sql = "";
				if(pd_type.equals("all")) {
					if(pd_quan.equals("true")) {
						pd_quan = "0";
						sql = "SELECT COUNT(*) FROM product WHERE pd_date>=? AND pd_date<=? AND NOT pd_type=? AND pd_quan>? AND pd_subject LIKE ?";
					} else {
						pd_quan = "0";
						sql = "SELECT COUNT(*) FROM product WHERE pd_date>=? AND pd_date<=? AND NOT pd_type=? AND pd_quan=? AND pd_subject LIKE ?";
					}
				} else if(!pd_type.equals("all")) {
					if(pd_quan.equals("true")) {
						pd_quan = "0";
						sql = "SELECT COUNT(*) FROM product WHERE pd_date>=? AND pd_date<=? AND pd_type=? AND pd_quan>? AND pd_subject LIKE ?";
					} else {
						pd_quan = "0";
						sql = "SELECT COUNT(*) FROM product WHERE pd_date>=? AND pd_date<=? AND pd_type=? AND pd_quan=? AND pd_subject LIKE ?";
					}
				}
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, start_date);
				pstmt.setString(2, end_date);
				pstmt.setString(3, pd_type);
				pstmt.setString(4, pd_quan);
				pstmt.setString(5, "%" + search_input + "%");
				rs = pstmt.executeQuery();
				if(rs.next()) {
					listCount = rs.getInt(1);
				}
			} catch (SQLException e) {
				System.out.println("getListCount(S,S,S,S,S) - SQL구문 오류 - " + e.getMessage());
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
		return listCount;
	}
	
	// 상품등록
	public int insertProduct(ProductDTO product) {
		int insertCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int pd_num = 1;
		try {
			String sql = "";
			// 1. 상품에 지정할 새 상품번호 저장하기
			sql = "SELECT MAX(pd_num) FROM product";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pd_num = rs.getInt(1) + 1;
			}
			close(pstmt); // 상품번호를 저장했을때 쓰인 pstmt 자원반환
			// 2. 상품등록
			sql = "INSERT INTO product VALUES (?,?,?,?,?,?,?,?,0,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pd_num);
			pstmt.setString(2, product.getPd_type());
			pstmt.setString(3, product.getPd_name());
			pstmt.setInt(4, product.getPd_price());
			pstmt.setInt(5, product.getPd_quan());
			pstmt.setString(6, product.getPd_file());
			pstmt.setString(7, product.getPd_subject());
			pstmt.setString(8, product.getPd_content());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertProduct(DTO) - SQL구문 오류 - " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return insertCount;
	}
	
	
}
















