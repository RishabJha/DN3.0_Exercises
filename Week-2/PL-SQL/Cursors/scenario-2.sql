declare
	cursor c_accounts is
	select accountid,
	       balance
	  from accounts;

	v_accountid accounts.accountid%type;
	v_balance   accounts.balance%type;
	annual_fee  number := 50;
begin
	open c_accounts;
	loop
		fetch c_accounts into
			v_accountid,
			v_balance;
		exit when c_accounts%notfound;
		update accounts
		   set balance = balance - annual_fee,
		       lastmodified = sysdate
		 where accountid = v_accountid;
	end loop;
	close c_accounts;
	commit;
end;
/