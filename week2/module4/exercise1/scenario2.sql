DECLARE
    CURSOR customer_cursor IS
        SELECT customer_id, balance
        FROM customers;
        
    v_customer_id customers.customer_id%TYPE;
    v_balance customers.balance%TYPE;
BEGIN
    FOR rec IN customer_cursor LOOP
        v_customer_id := rec.customer_id;
        v_balance := rec.balance;
        
        IF v_balance > 10000 THEN
            UPDATE customers
            SET is_vip = TRUE
            WHERE customer_id = v_customer_id;
        END IF;
    END LOOP;
    
    COMMIT;
END;
/