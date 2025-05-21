package tech.wvs.desafioemprestimos.controller.dto;

import java.util.List;

public record CustomerLoanResponse(String customer,
                                   List<LoanResponse> loans) {
}
