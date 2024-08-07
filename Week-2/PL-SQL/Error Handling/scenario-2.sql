create or replace procedure updatesalary (
	p_employeeid in number,
	p_percentage in number
) is
	v_currentsalary number;
begin
	savepoint before_update;
	begin
		select salary
		  into v_currentsalary
		  from employees
		 where employeeid = p_employeeid;
	exception
		when no_data_found then
			raise_application_error(
			                       -20001,
			                       'Employee ID does not exist.'
			);
	end;

	update employees
	   set
		salary = salary + ( salary * p_percentage / 100 )
	 where employeeid = p_employeeid;

	commit;
exception
	when others then
		rollback to before_update;
		raise;
end;
/

begin
	updatesalary(
	            p_employeeid => 1,
	            p_percentage => 10
	);
end;
/