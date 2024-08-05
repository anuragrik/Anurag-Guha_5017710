DECLARE
    CURSOR customer_cursor IS
        SELECT customer_id, age, loan_interest_rate
        FROM customers;
        
    v_customer_id customers.customer_id%TYPE;
    v_age customers.age%TYPE;
    v_loan_interest_rate customers.loan_interest_rate%TYPE;
BEGIN
    FOR rec IN customer_cursor LOOP
        v_customer_id := rec.customer_id;
        v_age := rec.age;
        v_loan_interest_rate := rec.loan_interest_rate;
        
        IF v_age > 60 THEN
            UPDATE customers
            SET loan_interest_rate = v_loan_interest_rate - 0.01
            WHERE customer_id = v_customer_id;
        END IF;
    END LOOP;
    
    COMMIT;
END;
/