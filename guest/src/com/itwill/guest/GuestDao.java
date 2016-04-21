package com.itwill.guest;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class GuestDao extends RdbmsDao {
	/*
	 * READ ALL
	 */
	public ArrayList<Guest> selectAll() throws Exception {
		System.out.println("selectAll_1");
		ArrayList<Guest> guestList = new ArrayList<Guest>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=this.getConnection();
			pstmt=con.prepareStatement(GuestSQL.GUEST_SELECT_ALL);
			rs=pstmt.executeQuery();
			System.out.println("selectAll_2");
			while(rs.next()) {
				guestList.add(
							  new Guest(
										rs.getInt("GUEST_NO"), 
										rs.getString("GUEST_NAME"), 
										rs.getDate("GUEST_DATE"), 
										rs.getString("GUEST_EMAIL"), 
										rs.getString("GUEST_HOMEPAGE"), 
										rs.getString("GUEST_TITLE"), 
										rs.getString("GUEST_CONTENT")
									   )
							 );
			}
			System.out.println("selectAll_3");
		} finally {
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				releaseConnection(con);			
		}
		
		return guestList;
	}
	/*
	 * CREATE
	 */
	public boolean insertGuest(Guest guest) throws Exception{
		boolean isSuccess = false;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=this.getConnection();
			pstmt=con.prepareStatement(GuestSQL.GUEST_INSERT);
			pstmt.setString(1, guest.guest_name);
			pstmt.setString(2, guest.guest_email);
			pstmt.setString(3, guest.guest_homepage);
			pstmt.setString(4, guest.guest_title);
			pstmt.setString(5, guest.guest_content);
			int insertRow=pstmt.executeUpdate();

			if(insertRow==1)
				isSuccess=true;
		} catch(Exception e) {
			isSuccess=false;
		} finally {
			if(con!=null)
				releaseConnection(con);
		}
		
		return isSuccess;
	}
	/*
	 * READ ONE
	 */
	public Guest selectByNo(int no) throws Exception{
		Guest guest=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=this.getConnection();
			pstmt=con.prepareStatement(GuestSQL.GUEST_SELECT_BY_NO);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				guest=new Guest(
								rs.getInt("GUEST_NO"), 
								rs.getString("GUEST_NAME"), 
								rs.getDate("GUEST_DATE"), 
								rs.getString("GUEST_EMAIL"), 
								rs.getString("GUEST_HOMEPAGE"), 
								rs.getString("GUEST_TITLE"), 
								rs.getString("GUEST_CONTENT")
							   );
			}
			
		} finally {
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				releaseConnection(con);			
		}
		
		return guest;
	}
	/*
	 * DELETE
	 */
	public boolean deleteGuest(int no){
		boolean deleteOK=false;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=this.getConnection();
			pstmt=con.prepareStatement(GuestSQL.GUEST_DELETE);
			pstmt.setInt(1, no);
			int deleteRow=pstmt.executeUpdate();
			
			deleteOK=true;
		} catch(Exception e) {
			deleteOK=false;
		} finally {
			try {
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					releaseConnection(con);
		    }catch (Exception e) {
				e.printStackTrace();
			}	
		}
		
		return deleteOK;
	}
	/*
	 * UPDATE
	 */
	public boolean updateGuest(Guest updateGuest){
		boolean updateOK=false;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=this.getConnection();
			pstmt=con.prepareStatement(GuestSQL.GUEST_UPDATE);
			pstmt.setString(1, updateGuest.guest_name);
			pstmt.setString(2, updateGuest.guest_email);
			pstmt.setString(3, updateGuest.guest_homepage);
			pstmt.setString(4, updateGuest.guest_title);
			pstmt.setString(5, updateGuest.guest_content);
			pstmt.setInt(6, updateGuest.guest_no);
			int updateRow=pstmt.executeUpdate();
			
			if(updateRow>0)
				updateOK=true;
			else
				updateOK=false;
		} catch(Exception e) {
			updateOK=false;
		} finally {
			try {
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					releaseConnection(con);
		    }catch (Exception e) {
				e.printStackTrace();
			}	
		}
		
		return updateOK;
	}

}










