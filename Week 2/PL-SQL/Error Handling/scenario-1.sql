create or replace procedure safetransferfunds (
    p_from_accountid in number,
    p_to_accountid   in number,
    p_amount         in number
) as
begin
    begin
        declare
            v_balance number;
        begin
            select balance
              into v_balance
              from accounts
             where accountid = p_from_accountid
            for update;

            if v_balance < p_amount then
                raise_application_error(
                                       -20001,
                                       'Insufficient funds'
                );
            end if;
        end;

        update accounts
           set
            balance = balance - p_amount
         where accountid = p_from_accountid;

        update accounts
           set
            balance = balance + p_amount
         where accountid = p_to_accountid;

        commit;
    exception
        when others then
            rollback;
    end;
end;
/


begin
    safetransferfunds(
                     p_from_accountid => 1,
                     p_to_accountid => 2,
                     p_amount => 500
    );
end;
/