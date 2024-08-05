DECLARE
    CURSOR c_transactions IS
        SELECT DISTINCT AccountID
        FROM Transactions
        WHERE TransactionDate BETWEEN TRUNC(SYSDATE, 'MM') AND SYSDATE;
        
    v_account_id Accounts.AccountID%TYPE;
BEGIN
    FOR rec IN c_transactions LOOP
        v_account_id := rec.AccountID;
        DBMS_OUTPUT.PUT_LINE('Monthly Statement for Account ID: ' || v_account_id);
        
        FOR trans IN (SELECT * FROM Transactions WHERE AccountID = v_account_id AND TransactionDate BETWEEN TRUNC(SYSDATE, 'MM') AND SYSDATE)
        LOOP
            DBMS_OUTPUT.PUT_LINE('Date: ' || trans.TransactionDate || ', Amount: ' || trans.Amount || ', Type: ' || trans.TransactionType);
        END LOOP;
    END LOOP;
END;
/
