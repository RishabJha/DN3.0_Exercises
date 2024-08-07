create or replace trigger updatecustomerlastmodified before
	update on customers
	for each row
begin
	:new.lastmodified := sysdate;
end;
/