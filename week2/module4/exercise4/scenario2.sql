CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount IN NUMBER,
    p_interest_rate IN NUMBER,
    p_duration_years IN NUMBER
) RETURN NUMBER IS
    v_monthly_rate NUMBER;
    v_num_payments NUMBER;
    v_monthly_payment NUMBER;
BEGIN
    v_monthly_rate := p_interest_rate / 100 / 12;
    v_num_payments := p_duration_years * 12;
    v_monthly_payment := (p_loan_amount * v_monthly_rate) / (1 - POWER(1 + v_monthly_rate, -v_num_payments));
    RETURN v_monthly_payment;
END;
/
