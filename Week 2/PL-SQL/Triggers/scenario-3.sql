create or replace trigger checktransactionrules before
	insert on transactions
	for each row
declare
	v_balance number;
begin
	if :new.transactiontype = 'Withdrawal' then
		select balance
		  into v_balance
		  from accounts
		 where accountid = :new.accountid;

		if v_balance < :new.amount then
			raise_application_error(
			                       -20002,
			                       'Insufficient funds for withdrawal.'
			);
		end if;
	elsif :new.transactiontype = 'Deposit' then
		if :new.amount <= 0 then
			raise_application_error(
			                       -20003,
			                       'Deposit amount must be positive.'
			);
		end if;
	end if;
end;
/