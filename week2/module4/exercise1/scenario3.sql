DECLARE
    CURSOR loan_cursor IS
        SELECT customer_id, loan_due_date
        FROM loans
        WHERE loan_due_date BETWEEN SYSDATE AND SYSDATE + 30;
        
    v_customer_id loans.customer_id%TYPE;
    v_loan_due_date loans.loan_due_date%TYPE;
BEGIN
    FOR rec IN loan_cursor LOOP
        v_customer_id := rec.customer_id;
        v_loan_due_date := rec.loan_due_date;
        
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan for customer ' || v_customer_id || ' is due on ' || v_loan_due_date);
    END LOOP;
END;
/
