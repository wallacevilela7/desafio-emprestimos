package tech.wvs.desafioemprestimos.domain;

import tech.wvs.desafioemprestimos.domain.exception.LoanNotAvailableException;

public class Loan {

    private Customer customer;

    public Loan(Customer customer) {
        this.customer = customer;
    }

    public boolean isPersonalLoanAvailable() {
        return isBasicLoanAvailable();
    }

    public boolean isConsignmentLoanAvailable() {
        return customer.isIncomeEqualOrBiggerThan(5000.0);
    }

    public boolean isGuaranteedLoanAvailable() {
        return isBasicLoanAvailable();
    }

    public Double getPersonalLoanInterestRate() {
        if (isPersonalLoanAvailable()) {
            return 4.0;
        }
        throw new LoanNotAvailableException("Personal loan not available. Check the conditions");
    }

    public Double getConsignmentLoanInterestRate() {
        if (isConsignmentLoanAvailable()) {
            return 2.0;
        }
        throw new LoanNotAvailableException("Consignment loan not available. Check the conditions");
    }

    public Double getGuaranteedLoanInterestRate() {
        if (isGuaranteedLoanAvailable()) {
            return 3.0;
        }
        throw new LoanNotAvailableException("Guaranteed loan not available. Check the conditions");
    }

    private boolean isBasicLoanAvailable() {
        if (customer.isIncomeEqualOrLowerThan(3000.0))
            return true;

        return customer.isIncomeBetween(3000.0, 5000.0)
                && customer.isAgeLowerThan(30)
                && customer.isFromLocation("SP");
    }
}
