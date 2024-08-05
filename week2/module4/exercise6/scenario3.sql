DECLARE
    CURSOR c_loans IS
        SELECT LoanID, InterestRate
        FROM Loans;
        
    v_loan_id Loans.LoanID%TYPE;
    v_interest_rate Loans.InterestRate%TYPE;
BEGIN
    FOR rec IN c_loans LOOP
        v_loan_id := rec.LoanID;
        v_interest_rate := rec.InterestRate;

        UPDATE Loans
        SET InterestRate = v_interest_rate + 0.5
        WHERE LoanID = v_loan_id;
    END LOOP;

    COMMIT;
END;
/
