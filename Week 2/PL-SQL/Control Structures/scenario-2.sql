alter table customers add (
    isvip char(1) default 'N'
);

declare
    cursor cust_cur is
    select customerid,
           balance
      from customers;

begin
    for cust in cust_cur loop
        if cust.balance > 10000 then
            update customers
               set
                isvip = 'Y'
             where customerid = cust.customerid;
        end if;
    end loop;

    commit;
end;
/