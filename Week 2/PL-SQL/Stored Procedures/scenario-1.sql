create or replace procedure processmonthlyinterest as
	v_interestrate number := 0.01; -- 1% interest rate
begin
	update accounts
	   set balance =
		case
		    when accounttype = 'Savings' then
		        balance * ( 1 + v_interestrate )
		    else
		        balance
		end,
	       lastmodified = sysdate
	 where accounttype = 'Savings';

	commit;
end;
/

begin
	processmonthlyinterest;
end;
/