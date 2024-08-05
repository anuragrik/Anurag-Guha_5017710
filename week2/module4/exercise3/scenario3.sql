CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    SELECT balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account;
    
    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance for transfer');
    END IF;

    UPDATE Accounts
    SET balance = balance - p_amount
    WHERE AccountID = p_from_account;

    UPDATE Accounts
    SET balance = balance + p_amount
    WHERE AccountID = p_to_account;
    
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK;
END;
/
