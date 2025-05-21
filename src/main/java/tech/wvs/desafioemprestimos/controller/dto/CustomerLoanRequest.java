package tech.wvs.desafioemprestimos.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import tech.wvs.desafioemprestimos.domain.Customer;

public record CustomerLoanRequest(@Min(value = 18) @NotNull Integer age,
                                  @CPF String cpf,
                                  @NotBlank String name,
                                  @Min(value = 1000) Double income,
                                  @NotBlank String location) {

    public Customer toDomain() {
        return new Customer(age, cpf, name, income, location);
    }
}
