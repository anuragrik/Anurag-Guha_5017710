CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
BEGIN
    IF :NEW.TransactionType = 'Withdrawal' THEN
        IF :NEW.Amount > (SELECT Balance FROM Accounts WHERE AccountID = :NEW.AccountID) THEN
            RAISE_APPLICATION_ERROR(-20003, 'Withdrawal exceeds account balance');
        END IF;
    ELSIF :NEW.TransactionType = 'Deposit' THEN
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20004, 'Deposit amount must be positive');
        END IF;
    END IF;
END;
/
