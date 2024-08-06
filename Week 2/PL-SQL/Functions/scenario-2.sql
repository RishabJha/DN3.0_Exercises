create or replace function calculatemonthlyinstallment (
	p_loanamount         in number,
	p_annualinterestrate in number,
	p_loandurationyears  in number
) return number is
	v_monthlyinterestrate number;
	v_numberofpayments    number;
	v_emi                 number;
begin
	v_monthlyinterestrate := p_annualinterestrate / 12 / 100;
	v_numberofpayments    := p_loandurationyears * 12;
	if v_monthlyinterestrate = 0 then
		v_emi := p_loanamount / v_numberofpayments;
	else
		v_emi := ( p_loanamount * v_monthlyinterestrate * power(
		                                                       1 + v_monthlyinterestrate,
		                                                       v_numberofpayments
		                                                  ) ) / ( power(
		                                                               1 + v_monthlyinterestrate,
		                                                               v_numberofpayments
		                                                          ) - 1 );
	end if;

	return v_emi;
end;
/