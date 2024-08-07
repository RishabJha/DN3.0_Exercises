create or replace package customermanagement as
	procedure addnewcustomer (
		p_customerid in number,
		p_name       in varchar2,
		p_dob        in date,
		p_balance    in number
	);

	procedure updatecustomerdetails (
		p_customerid in number,
		p_name       in varchar2,
		p_dob        in date,
		p_balance    in number
	);

	function getcustomerbalance (
		p_customerid in number
	) return number;
end customermanagement;
/


create or replace package body customermanagement as

	procedure addnewcustomer (
		p_customerid in number,
		p_name       in varchar2,
		p_dob        in date,
		p_balance    in number
	) is
	begin
		insert into customers (
			customerid,
			name,
			dob,
			balance,
			lastmodified
		) values ( p_customerid,
		           p_name,
		           p_dob,
		           p_balance,
		           sysdate );
		commit;
	end addnewcustomer;

	procedure updatecustomerdetails (
		p_customerid in number,
		p_name       in varchar2,
		p_dob        in date,
		p_balance    in number
	) is
	begin
		update customers
		   set name = p_name,
		       dob = p_dob,
		       balance = p_balance,
		       lastmodified = sysdate
		 where customerid = p_customerid;
		commit;
	end updatecustomerdetails;

	function getcustomerbalance (
		p_customerid in number
	) return number is
		v_balance number;
	begin
		select balance
		  into v_balance
		  from customers
		 where customerid = p_customerid;
		return v_balance;
	exception
		when no_data_found then
			return null;
	end getcustomerbalance;

end customermanagement;
/