create or replace function hassufficientbalance (
	p_accountid in number,
	p_amount    in number
) return boolean is
	v_balance number;
begin
	select balance
	  into v_balance
	  from accounts
	 where accountid = p_accountid;

	return v_balance >= p_amount;
exception
	when no_data_found then
		return false;
end;
/