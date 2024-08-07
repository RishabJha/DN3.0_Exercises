declare
	cursor c_loans is
	select l.customerid,
	       c.name,
	       l.loanid,
	       l.enddate
	  from loans l
	  join customers c
	on l.customerid = c.customerid
	 where l.enddate between sysdate and sysdate + 30;
begin
	for r_loan in c_loans loop
		dbms_output.put_line('Reminder: Customer '
		                     || r_loan.name
		                     || ' has a loan (ID: '
		                     || r_loan.loanid
		                     || ') due on '
		                     || to_char(
		                               r_loan.enddate,
		                               'YYYY-MM-DD'
		                        ));
	end loop;
end;
/