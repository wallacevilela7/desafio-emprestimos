package tech.wvs.desafioemprestimos.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.wvs.desafioemprestimos.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerTest {

    @Nested
    class isIncomeEqualOrLowerThan {
        @Test
        @DisplayName("Should return true when income is equal")
        void shouldReturnTrueWhenIncomeIsEqual() {
            var customer = CustomerFactory.buildWithIncome(5000.0);
            assertTrue(customer.isIncomeEqualOrLowerThan(5000.0));
        }

        @Test
        @DisplayName("Should return true when income is lower")
        void shouldReturnTrueWhenIncomeIsLower() {
            var customer = CustomerFactory.buildWithIncome(3000.0);
            assertTrue(customer.isIncomeEqualOrLowerThan(5000.0));
        }

        @Test
        @DisplayName("Should return false when income is higher")
        void shouldReturnFalseWhenIncomeIsHigher() {
            var customer = CustomerFactory.buildWithIncome(7000.0);
            assertFalse(customer.isIncomeEqualOrLowerThan(5000.0));
        }
    }

    @Nested
    class isIncomeEqualOrBiggerThan {
        @Test
        @DisplayName("Should return true when income is equal")
        void shouldReturnTrueWhenIncomeIsEqual() {
            var customer = CustomerFactory.buildWithIncome(5000.0);
            assertTrue(customer.isIncomeEqualOrBiggerThan(5000.0));
        }

        @Test
        @DisplayName("Should return true when income is higher")
        void shouldReturnTrueWhenIncomeIsHigher() {
            var customer = CustomerFactory.buildWithIncome(7000.0);
            assertTrue(customer.isIncomeEqualOrBiggerThan(5000.0));
        }

        @Test
        @DisplayName("Should return false when income is lower")
        void shouldReturnFalseWhenIncomeIsLower() {
            var customer = CustomerFactory.buildWithIncome(3000.0);
            assertFalse(customer.isIncomeEqualOrBiggerThan(5000.0));
        }
    }

    @Nested
    class isIncomeBetween {

        @Test
        @DisplayName("Should return true when income is between min and max")
        void shouldReturnTrueWhenIncomeIsBetweenMinAndMax() {
            var customer = CustomerFactory.buildWithIncome(5000.0);
            assertTrue(customer.isIncomeBetween(4000.0, 6000.0));
        }

        @Test
        @DisplayName("Should return true when income is equal to min")
        void shouldReturnTrueWhenIncomeIsEqualToMin() {
            var customer = CustomerFactory.buildWithIncome(4000.0);
            assertTrue(customer.isIncomeBetween(4000.0, 6000.0));
        }

        @Test
        @DisplayName("Should return true when income is equal to max")
        void shouldReturnTrueWhenIncomeIsEqualToMax() {
            var customer = CustomerFactory.buildWithIncome(6000.0);
            assertTrue(customer.isIncomeBetween(4000.0, 6000.0));
        }

        @Test
        @DisplayName("Should return false when income is not between min and max")
        void shouldReturnFalseWhenIncomeIsNotBetweenMinAndMax() {
            var customer = CustomerFactory.buildWithIncome(7000.0);
            assertFalse(customer.isIncomeBetween(4000.0, 6000.0));
        }
    }

    @Nested
    class isAgeLowerThan {
        @Test
        @DisplayName("Should return true when age is lower")
        void shouldReturnTrueWhenAgeIsLower() {
            var customer = CustomerFactory.buildWithAge(29);
            assertTrue(customer.isAgeLowerThan(30));
        }

        @Test
        @DisplayName("Should return false when age is bigger")
        void shouldReturnFalseWhenAgeIsBigger() {
            var customer = CustomerFactory.buildWithAge(31);
            assertFalse(customer.isAgeLowerThan(30));
        }

        @Test
        @DisplayName("Should return false when age is equal")
        void shouldReturnFalseWhenAgeIsEqual() {
            var customer = CustomerFactory.buildWithAge(30);
            assertFalse(customer.isAgeLowerThan(30));
        }
    }

    @Nested
    class isFromLocation {

        @Test
        @DisplayName("Should return true when location is equal")
        void shouldReturnTrueWhenLocationIsEqual() {
            var customer = CustomerFactory.buildWithLocation("SP");
            assertTrue(customer.isFromLocation("SP"));
        }

        @Test
        @DisplayName("Should return true when location is equal")
        void shouldReturnFalseWhenLocationIsNotEqual() {
            var customer = CustomerFactory.buildWithLocation("SP");
            assertFalse(customer.isFromLocation("RJ"));
        }
    }
}