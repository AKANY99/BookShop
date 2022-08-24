package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import vo.*;

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
	
	// 타입별 상품현황란 건수 표시
	public int selectListCount(String Condition) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(*) FROM product WHERE pd_condition=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Condition);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("selectListCount() - SQL구문 오류 - " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return count;
	}
	
	public ArrayList<ProductDTO> getProductList(String start_date, String end_date, String pd_subject, String pd_condition, String search_input, int pdPageNum, int listLimit) {
		ArrayList<ProductDTO> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int startRow = (pdPageNum - 1) * listLimit;
		
			try {
				String sql = "";
				
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, start_date);
				pstmt.setString(2, end_date);
				pstmt.setString(3, pd_subject);
				pstmt.setString(4, pd_condition);
				pstmt.setString(5, search_input);
				pstmt.setInt(6, startRow);
				pstmt.setInt(7, listLimit);
				rs = pstmt.executeQuery();
			} catch (SQLException e) {
				System.out.println("getProductList() - SQL구문 오류 - " + e.getMessage());
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
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
			} finally {
				close(rs);
				close(pstmt);
			}
			return product;
		}
		
		// 장바구니(cart 테이블) 에 상품을 담는 cartOn()  
		public int cartOn(int pd_num, String sId, int quantity) {
			
			int CartOnCount = 0;
			int user_num = 0;
			boolean existProduct = false;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "SELECT user_num FROM user WHERE user_email=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sId);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					user_num =  rs.getInt(1);
//					System.out.println(user_num);
				}
				
				close(pstmt);
				close(rs);
				
				// 장바구니에 이미 존재하는 물품인지 확인하기 위한 구문
				sql = "SELECT cart_pd_num FROM cart WHERE cart_user_num=? AND cart_pd_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, user_num);
				pstmt.setInt(2, pd_num);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					existProduct = true;
				}
				
				close(pstmt);
				close(rs);
				
				if(!existProduct) {
					// 장바구니에 같은 물품이 없는 경우( INSERT )
					sql = "INSERT INTO cart(cart_user_num, cart_pd_num, cart_pd_quan) VALUES (?,?,?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, user_num);
					pstmt.setInt(2, pd_num);
					pstmt.setInt(3, quantity);
				}
				else {
					// 장바구니에 같은 물품이 있는 경우( UPDATE로 수량 증가 )
					sql = "UPDATE cart SET cart_pd_quan=cart_pd_quan+? WHERE cart_user_num=? AND cart_pd_num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, quantity);
					pstmt.setInt(2, user_num);
					pstmt.setInt(3, pd_num);
				}
					
				CartOnCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 발생! - cartOn()");
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return CartOnCount;
		}
		
		// 내 장바구니 목록 리스트를 가져오는 MyCart
		public ArrayList<ProductDTO> MyCart(String sId) {
			System.out.println("dao 진입");
			ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
			int user_num = 0;
			
			ProductDTO product = null;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
					
			try {
				String sql = "SELECT user_num FROM user WHERE user_email=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sId);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					user_num =  rs.getInt(1);
					System.out.println(user_num);
				}
				
				close(pstmt);
				close(rs);
				
				sql = "SELECT pd_num, pd_name, pd_price, pd_file, pd_subject, cart_pd_quan FROM product,cart "
						+ "WHERE product.pd_num=cart.cart_pd_num AND cart_user_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, user_num);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					product = new ProductDTO();
					product.setPd_num(rs.getInt("pd_num"));
					product.setPd_name(rs.getString("pd_name"));
					product.setPd_price(rs.getInt("pd_price"));
					product.setPd_file(rs.getString("pd_file"));
					product.setPd_subject(rs.getString("pd_subject"));
					product.setCart_pd_quan(rs.getInt("cart_pd_quan"));
					list.add(product);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("MyCart() - SQL 구문 오류 : " + e.getMessage());
			}finally {
				close(pstmt);
				close(rs);
			}
			
			return list;
		}
		
		// 찜목록에 상품을 추가하는 InterestOn()
		public int InterestOn (int pd_num, String sId) {
			int InterestOnCount = 0;
			int user_num = 0;
			boolean existProduct = false;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "SELECT user_num FROM user WHERE user_email=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sId);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					user_num =  rs.getInt(1);
//					System.out.println(user_num);
				}
				
				close(pstmt);
				close(rs);
				
				// 찜목록에 이미 존재하는 물품인지 확인하기 위한 구문
				sql = "SELECT inter_pd_num FROM interest WHERE inter_user_num=? AND inter_pd_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, user_num);
				pstmt.setInt(2, pd_num);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					existProduct = true;
				}
				
				close(pstmt);
				close(rs);
				
				if(!existProduct) {
					// 찜목록(interest)에 같은 물품이 없는 경우 물품을 찜목록에 추가( INSERT )
					sql = "INSERT INTO interest(inter_user_num, inter_pd_num) VALUES (?,?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, user_num);
					pstmt.setInt(2, pd_num);
					
					//찜목록에 추가했을 경우면 InterestOnCount 증가
					InterestOnCount = pstmt.executeUpdate();
				}

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 발생! - cartOn()");
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return InterestOnCount;
		}
		
		// 사용자가 찜한 찜목록을 리스트로 출력하는 MyInterest()
		public ArrayList<ProductDTO> MyInterest(String sId) {
			ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
			int user_num = 0;
			
			ProductDTO product = null;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
					
			try {
				String sql = "SELECT user_num FROM user WHERE user_email=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sId);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					user_num =  rs.getInt(1);
//					System.out.println(user_num);
				}
				
				close(pstmt);
				close(rs);
				
				sql = "SELECT pd_num,pd_name,pd_price,pd_file,pd_subject FROM product,interest"
						+ " WHERE product.pd_num=interest.inter_pd_num AND inter_user_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, user_num);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					product = new ProductDTO();
					product.setPd_num(rs.getInt("pd_num"));
					product.setPd_name(rs.getString("pd_name"));
					product.setPd_price(rs.getInt("pd_price"));
					product.setPd_file(rs.getString("pd_file"));
					product.setPd_subject(rs.getString("pd_subject"));
					list.add(product);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("MyInterest() - SQL 구문 오류 : " + e.getMessage());
			}finally {
				close(pstmt);
				close(rs);
			}
			
			return list;
		}
		
		// 찜 목록에서 삭제하기를 누른 상품을 삭제하는 deleteInterest()
		public int deleteInterest(int pd_num, String sId) {
			int isDeleteSuccess = 0;
			int user_num = 0;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "SELECT user_num FROM user WHERE user_email=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sId);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					user_num =  rs.getInt(1);
//					System.out.println(user_num);
				}
				
				close(pstmt);
				close(rs);
				
				sql = "DELETE FROM interest WHERE inter_pd_num=? AND inter_user_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, pd_num);
				pstmt.setInt(2, user_num);
				isDeleteSuccess = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("deleteInterest() - SQL 구문 오류 : " + e.getMessage());
			} finally {
				close(pstmt);
			}

			return isDeleteSuccess;
		}
		
		
		// 장바구니 목록에서 삭제하기를 누른 상품을 삭제하는 deleteCart()
		public int deleteCart(int pd_num, String sId) {
			int isDeleteSuccess = 0;
			int user_num = 0;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "SELECT user_num FROM user WHERE user_email=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sId);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					user_num =  rs.getInt(1);
//					System.out.println(user_num);
				}
				
				close(pstmt);
				close(rs);
				
				sql = "DELETE FROM cart WHERE cart_pd_num=? AND cart_user_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, pd_num);
				pstmt.setInt(2, user_num);
				isDeleteSuccess = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("deleteCart() - SQL 구문 오류 : " + e.getMessage());
			} finally {
				close(pstmt);
			}

			return isDeleteSuccess;
		}
		
		
		// 장바구니에서 수량 변경 시 변경된 수량을 cart 에 저장하는 CartQuanChange()
		public int CartQuanChange(String sId, int pd_num, int quan) {
			int changeCount = 0;
			int user_num = 0;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "SELECT user_num FROM user WHERE user_email=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sId);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					user_num =  rs.getInt(1);
//					System.out.println(user_num);
				}
				
				close(pstmt);
				close(rs);
				
				sql = "UPDATE cart SET cart_pd_quan=? WHERE cart_pd_num=? AND cart_user_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, quan);
				pstmt.setInt(2, pd_num);
				pstmt.setInt(3, user_num);
				changeCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("CartQuanChange() - SQL 구문 오류 : " + e.getMessage());
			} finally {
				close(pstmt);
			}

			return changeCount;
		}
		
		// 유저의 적립금 추출
		
		public int getUserPoints(String sId) {
			System.out.println("dao 진입");
			int userPoint =0;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			
			try {
				String sql = "select user_points from user where user_email=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sId);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					userPoint =  rs.getInt(1);

				}
			} catch (SQLException e) {
				System.out.println("sql 오류"+e.getMessage());
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			
			System.out.println(userPoint);
			return userPoint;
			
		}
	
}
