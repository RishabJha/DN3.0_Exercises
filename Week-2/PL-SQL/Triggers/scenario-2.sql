create table auditlog (
	logid         number primary key,
	transactionid number,
	actiondate    date,
	action        varchar2(50),
	foreign key ( transactionid )
		references transactions ( transactionid )
);

create sequence auditlog_seq start with 1 increment by 1 nocache nocycle;

create or replace trigger logtransaction after
	insert on transactions
	for each row
begin
	insert into auditlog (
		logid,
		transactionid,
		actiondate,
		action
	) values ( auditlog_seq.nextval,
	           :new.transactionid,
	           sysdate,
	           'Transaction Inserted' );
end;
/