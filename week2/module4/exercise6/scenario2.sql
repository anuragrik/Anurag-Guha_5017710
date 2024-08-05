DECLARE
    CURSOR c_accounts IS
        SELECT AccountID, Balance
        FROM Accounts;
        
    v_account_id Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
BEGIN
    FOR rec IN c_accounts LOOP
        v_account_id := rec.AccountID;
        v_balance := rec.Balance;

        UPDATE Accounts
        SET Balance = v_balance - 50
        WHERE AccountID = v_account_id;
    END LOOP;

    COMMIT;
END;
/
