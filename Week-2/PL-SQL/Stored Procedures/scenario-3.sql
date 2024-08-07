create sequence transactions_seq start with 1 increment by 1 nocache nocycle;

create or replace procedure transferfunds (
	p_fromaccountid in number,
	p_toaccountid   in number,
	p_amount        in number
) is
	v_frombalance number;
begin
	select balance
	  into v_frombalance
	  from accounts
	 where accountid = p_fromaccountid;

	if v_frombalance < p_amount then
		raise_application_error(
		                       -20001,
		                       'Insufficient funds in the source account.'
		);
	end if;
	savepoint before_transfer;
	update accounts
	   set balance = balance - p_amount,
	       lastmodified = sysdate
	 where accountid = p_fromaccountid;

	update accounts
	   set balance = balance + p_amount,
	       lastmodified = sysdate
	 where accountid = p_toaccountid;

	insert into transactions (
		transactionid,
		accountid,
		transactiondate,
		amount,
		transactiontype
	) values ( transactions_seq.nextval,
	           p_fromaccountid,
	           sysdate,
	           p_amount,
	           'Debit' );

	insert into transactions (
		transactionid,
		accountid,
		transactiondate,
		amount,
		transactiontype
	) values ( transactions_seq.nextval,
	           p_toaccountid,
	           sysdate,
	           p_amount,
	           'Credit' );

	commit;
exception
	when others then
		rollback to before_transfer;
		raise;
end;
/