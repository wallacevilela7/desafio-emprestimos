package tech.wvs.desafioemprestimos.domain.exception;

import org.springframework.http.ProblemDetail;

public abstract class LoanGlobalException extends RuntimeException {
    public LoanGlobalException(String message) {
        super(message);
    }


    public ProblemDetail toProblemDetail() {
        var pd = ProblemDetail.forStatus(500);

        pd.setTitle("Application internal server error");
        pd.setDetail("Contact support");

        return pd;
    }
}
