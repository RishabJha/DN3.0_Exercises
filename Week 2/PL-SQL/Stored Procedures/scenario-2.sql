create or replace procedure updateemployeebonus (
	p_department      in varchar2,
	p_bonuspercentage in number
) as
begin
	update employees
	   set
		salary = salary + ( salary * p_bonuspercentage / 100 )
	 where department = p_department;

	commit;
end;
/

begin
	updateemployeebonus(
	                   p_department => 'HR',
	                   p_bonuspercentage => 10
	);
end;
/