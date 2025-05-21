package tech.wvs.desafioemprestimos.controller.dto;

import tech.wvs.desafioemprestimos.domain.enums.LoanType;

public record LoanResponse(
        LoanType type,
        Double interestRate) {
}
