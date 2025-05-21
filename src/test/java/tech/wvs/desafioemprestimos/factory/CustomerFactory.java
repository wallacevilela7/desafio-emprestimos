package tech.wvs.desafioemprestimos.factory;

import tech.wvs.desafioemprestimos.domain.Customer;

public class CustomerFactory {

    public static Customer build() {
        return new Customer(30,
                "Name",
                "12345678900",
                5000.0,
                "SP");
    }

    public static Customer buildWithIncome(Double income) {
        return new Customer(30,
                "Name",
                "12345678900",
                income,
                "SP");
    }

        public static Customer buildWithAge(Integer age) {
            return new Customer(age ,
                    "Name",
                    "12345678900",
                    5000.0,
                    "SP");
    }

    public static Customer buildWithLocation(String location) {
        return new Customer(30 ,
                "Name",
                "12345678900",
                5000.0,
                location);
    }
}
