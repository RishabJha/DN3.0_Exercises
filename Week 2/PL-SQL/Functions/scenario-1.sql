create or replace function calculateage (
	p_dob in date
) return number is
	v_age number;
begin
	select floor(months_between(
		sysdate,
		p_dob
	) / 12)
	  into v_age
	  from dual;

	return v_age;
end;
/