create or replace package employeemanagement as
	procedure hirenewemployee (
		p_employeeid in number,
		p_name       in varchar2,
		p_position   in varchar2,
		p_salary     in number,
		p_department in varchar2,
		p_hiredate   in date
	);

	procedure updateemployeedetails (
		p_employeeid in number,
		p_name       in varchar2,
		p_position   in varchar2,
		p_salary     in number,
		p_department in varchar2
	);

	function calculateannualsalary (
		p_employeeid in number
	) return number;
end employeemanagement;
/

create or replace package body employeemanagement as

	procedure hirenewemployee (
		p_employeeid in number,
		p_name       in varchar2,
		p_position   in varchar2,
		p_salary     in number,
		p_department in varchar2,
		p_hiredate   in date
	) is
	begin
		insert into employees (
			employeeid,
			name,
			position,
			salary,
			department,
			hiredate
		) values ( p_employeeid,
		           p_name,
		           p_position,
		           p_salary,
		           p_department,
		           p_hiredate );
		commit;
	end hirenewemployee;

	procedure updateemployeedetails (
		p_employeeid in number,
		p_name       in varchar2,
		p_position   in varchar2,
		p_salary     in number,
		p_department in varchar2
	) is
	begin
		update employees
		   set name = p_name,
		       position = p_position,
		       salary = p_salary,
		       department = p_department
		 where employeeid = p_employeeid;
		commit;
	end updateemployeedetails;

	function calculateannualsalary (
		p_employeeid in number
	) return number is
		v_salary number;
	begin
		select salary
		  into v_salary
		  from employees
		 where employeeid = p_employeeid;
		return v_salary * 12;
	exception
		when no_data_found then
			return null;
	end calculateannualsalary;

end employeemanagement;
/