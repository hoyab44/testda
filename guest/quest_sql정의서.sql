--select All
select * from guest;
--select by no
select * from guest where guest_no=2;
--insert guest
insert into guest(guest_no,guest_name,guest_date,guest_email,guest_homepage,guest_title,guest_content) values(guest_no_seq,'','','','','','');
--update guest
update guest set guest_name='',guest_email='',guest_homepage='',guest_title='',guest_content='' where guest_no=?;
--delete guest
delete from guest where guest_no=?;