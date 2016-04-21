package com.itwill.guest;

import java.sql.Date;

public class Guest {
/*
  Name                                      Null?    Type
 -------------------------------------- -------- --------------
 GUEST_NO                               NOT NULL NUMBER(10)
 GUEST_NAME                             NOT NULL VARCHAR2(10)
 GUEST_DATE                             NOT NULL DATE
 GUEST_EMAIL                                     VARCHAR2(50)
 GUEST_HOMEPAGE                                  VARCHAR2(50)
 GUEST_TITLE                            NOT NULL VARCHAR2(100)
 GUEST_CONTENT                          NOT NULL VARCHAR2(4000) 
 */
	
	public int guest_no;
	public String guest_name;
	public Date guest_date;
	public String guest_email;
	public String guest_homepage;
	public String guest_title;
	public String guest_content;
 
	public Guest(int guest_no, String guest_name, Date guest_date, String guest_email, String guest_homepage,
			String guest_title, String guest_content) {
		this.guest_no = guest_no;
		this.guest_name = guest_name;
		this.guest_date = guest_date;
		this.guest_email = guest_email;
		this.guest_homepage = guest_homepage;
		this.guest_title = guest_title;
		this.guest_content = guest_content;
	}
 
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return guest_no+"\t"+guest_name+"\t"+guest_date+"\t"+guest_email+"\t"+guest_homepage+"\t"+guest_title+"\t"+guest_content;
	}
	
}

















