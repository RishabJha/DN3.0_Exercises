declare
	cursor c_loans is
	select loanid,
	       interestrate
	  from loans;

	v_loanid          loans.loanid%type;
	v_oldinterestrate loans.interestrate%type;
	v_newinterestrate loans.interestrate%type;
	new_policy_rate   number := 0.05;
begin
	open c_loans;
	loop
		fetch c_loans into
			v_loanid,
			v_oldinterestrate;
		exit when c_loans%notfound;
		v_newinterestrate := new_policy_rate;
		update loans
		   set interestrate = v_newinterestrate,
		       enddate = add_months(
				      enddate,
				      12
			      )
		 where loanid = v_loanid;
	end loop;
	close c_loans;
	commit;
end;
/