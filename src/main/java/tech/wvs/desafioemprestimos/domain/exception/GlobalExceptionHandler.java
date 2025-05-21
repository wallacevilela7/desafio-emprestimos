package tech.wvs.desafioemprestimos.domain.exception;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoanGlobalException.class)
    public ProblemDetail handleLoanGlobalException(LoanGlobalException e) {
        return e.toProblemDetail();
    }
}
