package tech.wvs.desafioemprestimos.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class LoanNotAvailableException extends LoanGlobalException {

    private final String detail;

    public LoanNotAvailableException(String detail) {
        super(detail);
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pd.setTitle("Loan not available for this customer");
        pd.setDetail(detail);

        return pd;
    }
}
