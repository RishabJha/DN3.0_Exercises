declare
	cursor c_monthly_transactions is
	select c.customerid,
	       c.name,
	       t.transactionid,
	       t.transactiondate,
	       t.amount,
	       t.transactiontype
	  from customers c
	  join accounts a
	on c.customerid = a.customerid
	  join transactions t
	on a.accountid = t.accountid
	 where extract(month from t.transactiondate) = extract(month from sysdate)
	   and extract(year from t.transactiondate) = extract(year from sysdate);

	v_customerid      customers.customerid%type;
	v_name            customers.name%type;
	v_transactionid   transactions.transactionid%type;
	v_transactiondate transactions.transactiondate%type;
	v_amount          transactions.amount%type;
	v_transactiontype transactions.transactiontype%type;
begin
	open c_monthly_transactions;
	loop
		fetch c_monthly_transactions into
			v_customerid,
			v_name,
			v_transactionid,
			v_transactiondate,
			v_amount,
			v_transactiontype;
		exit when c_monthly_transactions%notfound;
		dbms_output.put_line('Customer ID: ' || v_customerid);
		dbms_output.put_line('Name: ' || v_name);
		dbms_output.put_line('Transaction ID: ' || v_transactionid);
		dbms_output.put_line('Date: ' || v_transactiondate);
		dbms_output.put_line('Amount: ' || v_amount);
		dbms_output.put_line('Type: ' || v_transactiontype);
		dbms_output.put_line('--------------------');
	end loop;
	close c_monthly_transactions;
end;
/