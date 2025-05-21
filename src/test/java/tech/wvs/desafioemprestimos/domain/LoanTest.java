package tech.wvs.desafioemprestimos.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.wvs.desafioemprestimos.domain.exception.LoanNotAvailableException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class LoanTest {

    @Mock
    private Customer customer;

    @InjectMocks
    private Loan loan;


    @Nested
    class isPersonalLoanAvailable {

        @Test
        @DisplayName("Should be available when income is equal or less than 3k")
        void shouldBeAvailableWhenIncomeIsEqualOrLessThan3k() {

            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);
            assertTrue(loan.isPersonalLoanAvailable());
        }

        @Test
        @DisplayName("Should be available when income is between 3k and 5k, age is less than 30 and location is SP")
        void shouldBeAvailableWhenIncomeIsBetween3kAnd5kAndAgeIsLessThan30AndLocationIsSP() {

            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);
            doReturn(true).when(customer).isIncomeBetween(3000.0, 5000.0);
            doReturn(true).when(customer).isAgeLowerThan(30);
            doReturn(true).when(customer).isFromLocation("SP");

            assertTrue(loan.isPersonalLoanAvailable());
        }

    }

    @Nested
    class isGuaranteedLoanAvailable {
        @Test
        @DisplayName("Should be available when income is equal or less than 3k")
        void shouldBeAvailableWhenIncomeIsEqualOrLessThan3k() {

            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);
            assertTrue(loan.isPersonalLoanAvailable());
        }

        @Test
        @DisplayName("Should be available when income is between 3k and 5k, age is less than 30 and location is SP")
        void shouldBeAvailableWhenIncomeIsBetween3kAnd5kAndAgeIsLessThan30AndLocationIsSP() {

            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);
            doReturn(true).when(customer).isIncomeBetween(3000.0, 5000.0);
            doReturn(true).when(customer).isAgeLowerThan(30);
            doReturn(true).when(customer).isFromLocation("SP");

            assertTrue(loan.isPersonalLoanAvailable());
        }
    }

    @Nested
    class isConsignmentLoanAvailable {
        @Test
        @DisplayName("Should be available when income is equal or greater than 5k")
        void shouldBeAvailableWhenIncomeIsEqualOrGreaterThan5k() {

            doReturn(true).when(customer).isIncomeEqualOrBiggerThan(5000.0);
            assertTrue(loan.isConsignmentLoanAvailable());
        }

        @Test
        @DisplayName("Should not be available when income is less than 5k")
        void shouldNotBeAvailableWhenIncomeIsLessThan5k() {

            doReturn(false).when(customer).isIncomeEqualOrBiggerThan(5000.0);
            assertFalse(loan.isConsignmentLoanAvailable());
        }
    }

    @Nested
    class getPersonalLoanInterestRate {
        @Test
        @DisplayName("Should return 4.0 when loan is available")
        void shouldReturn4WhenLoanIsAvailable() {

             doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);

             assertEquals(4.0, loan.getPersonalLoanInterestRate());
        }

        @Test
        @DisplayName("Should throw LoanNotAvailableException when loan is not available")
        void shouldThrowLoanNotAvailableExceptionWhenLoanIsNotAvailable() {

            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);

            assertThrows(LoanNotAvailableException.class,
                    () -> loan.getPersonalLoanInterestRate());
        }

    }

    @Nested
    class getConsignmentLoanInterestRate {
        @Test
        @DisplayName("Should return 2.0 when loan is available")
        void shouldReturn2WhenLoanIsAvailable() {

            doReturn(true).when(customer).isIncomeEqualOrBiggerThan(5000.0);

            assertEquals(2.0, loan.getConsignmentLoanInterestRate());
        }

        @Test
        @DisplayName("Should throw LoanNotAvailableException when loan is not available")
        void shouldThrowLoanNotAvailableExceptionWhenLoanIsNotAvailable() {

            doReturn(false).when(customer).isIncomeEqualOrBiggerThan(5000.0);

            assertThrows(LoanNotAvailableException.class,
                    () -> loan.getConsignmentLoanInterestRate());
        }
    }

    @Nested
    class getGuaranteedLoanInterestRate {

        @Test
        @DisplayName("Should return 3.0 when loan is available")
        void shouldReturn3WhenLoanIsAvailable() {

            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);

            assertEquals(3.0, loan.getGuaranteedLoanInterestRate());
        }

        @Test
        @DisplayName("Should throw LoanNotAvailableException when loan is not available")
        void shouldThrowLoanNotAvailableExceptionWhenLoanIsNotAvailable() {

            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);

            assertThrows(LoanNotAvailableException.class,
                    () -> loan.getGuaranteedLoanInterestRate());
        }
    }
}