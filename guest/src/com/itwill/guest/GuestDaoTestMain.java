package com.itwill.guest;

import java.util.ArrayList;

public class GuestDaoTestMain {

	public static void main(String[] args) throws Exception {
		
		GuestDao gd=new GuestDao();
		
		//------------------select ALL--------------------------//
		System.out.println("------------select ALL-----------------");
		ArrayList<Guest> guestList=gd.selectAll();
		for (Guest guest : guestList) {
			System.out.println(guest);
		}
		
		//------------------select By NO--------------------------//
		System.out.println("------------select By NO-----------------");
		System.out.println(gd.selectByNo(3));
		
		//------------------Insert--------------------------//
		System.out.println("------------Insert-----------------");
		Guest insertGuest=new Guest(0, "guest_name", null, "guest_email", "guest_hompage", "guest_titel", "guest_content");
		boolean insertSuccess=gd.insertGuest(insertGuest);
		System.out.println("insertSuccess:"+insertSuccess);
		
		//------------------Update--------------------------//
		System.out.println("------------Update-----------------");
		Guest updateGuest=new Guest(24, "guest_name", null, "guest_email", "guest_hompage", "guest_titel", "guest_content");
		boolean updateSuccess=gd.updateGuest(updateGuest);
		System.out.println("updateSuccess:"+updateSuccess);
		
		//------------------Delete--------------------------//
		System.out.println("------------Delete-----------------");
		boolean deleteSuccess=gd.deleteGuest(25);
		System.out.println("deleteSuccess:"+deleteSuccess);
		
	}

}
