package tech.wvs.desafioemprestimos.service;

import org.springframework.stereotype.Service;
import tech.wvs.desafioemprestimos.controller.dto.CustomerLoanRequest;
import tech.wvs.desafioemprestimos.controller.dto.CustomerLoanResponse;
import tech.wvs.desafioemprestimos.controller.dto.LoanResponse;
import tech.wvs.desafioemprestimos.domain.Loan;
import tech.wvs.desafioemprestimos.domain.enums.LoanType;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public CustomerLoanResponse checkLoanAvailability(CustomerLoanRequest dto) {
        var customer = dto.toDomain();
        var loan = new Loan(customer);

        List<LoanResponse> loans = new ArrayList<>();

        if (loan.isPersonalLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));
        }

        if (loan.isConsignmentLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsignmentLoanInterestRate()));
        }

        if (loan.isGuaranteedLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInterestRate()));
        }

        return new CustomerLoanResponse(dto.name(), loans);
    }
}
