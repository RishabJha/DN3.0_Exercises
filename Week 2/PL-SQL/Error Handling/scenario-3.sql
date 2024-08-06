create or replace procedure addnewcustomer (
	p_customerid in number,
	p_name       in varchar2,
	p_dob        in date,
	p_balance    in number
) is
	v_exists number;
begin
	savepoint before_insert;
	begin
		select 1
		  into v_exists
		  from customers
		 where customerid = p_customerid;
		raise_application_error(
		                       -20002,
		                       'Customer ID already exists.'
		);
	exception
		when no_data_found then
			null;
	end;

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
exception
	when others then
		rollback to before_insert;
		raise;
end;
/


begin
	addnewcustomer(
	              p_customerid => 3,
	              p_name => 'Emily Davis',
	              p_dob => to_date('1988-09-25',
	               'YYYY-MM-DD'),
	              p_balance => 2000
	);
end;
/