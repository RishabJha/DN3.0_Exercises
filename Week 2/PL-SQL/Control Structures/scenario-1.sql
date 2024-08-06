declare
	cursor c_customers is
	select customerid,
	       dob
	  from customers;

	v_age number;
begin
	for r_customer in c_customers loop
		v_age := floor(months_between(
		                             sysdate,
		                             r_customer.dob
		               ) / 12);
		if v_age > 60 then
			update loans
			   set
				interestrate = interestrate - 1
			 where customerid = r_customer.customerid;
		end if;
	end loop;

	commit;
end;
/