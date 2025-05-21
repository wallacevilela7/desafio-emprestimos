package tech.wvs.desafioemprestimos.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wvs.desafioemprestimos.controller.dto.CustomerLoanRequest;
import tech.wvs.desafioemprestimos.controller.dto.CustomerLoanResponse;
import tech.wvs.desafioemprestimos.service.LoanService;

@RestController
public class LoanController {

    private final LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    @PostMapping(path = "/customer-loans")
    public ResponseEntity<CustomerLoanResponse> customerLoans(@RequestBody @Valid CustomerLoanRequest dto) {

        var loanResponse = service.checkLoanAvailability(dto);

        return ResponseEntity.ok(loanResponse);
    }
}
