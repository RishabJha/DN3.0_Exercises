create or replace package accountoperations as
	procedure opennewaccount (
		p_accountid   in number,
		p_customerid  in number,
		p_accounttype in varchar2,
		p_balance     in number
	);

	procedure closeaccount (
		p_accountid in number
	);

	function gettotalbalance (
		p_customerid in number
	) return number;
end accountoperations;
/


create or replace package accountoperations as
	procedure opennewaccount (
		p_accountid   in number,
		p_customerid  in number,
		p_accounttype in varchar2,
		p_balance     in number
	);

	procedure closeaccount (
		p_accountid in number
	);

	function gettotalbalance (
		p_customerid in number
	) return number;
end accountoperations;
/