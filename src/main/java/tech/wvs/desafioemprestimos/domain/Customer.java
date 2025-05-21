package tech.wvs.desafioemprestimos.domain;

public class Customer {

    private Integer age;
    private String name;
    private String cpf;
    private Double income;
    private String location;

    public Customer(Integer age, String name, String cpf, Double income, String location) {
        this.age = age;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.location = location;
    }

    public boolean isIncomeEqualOrLowerThan(double value) {
        return this.income <= value;
    }

    public boolean isIncomeBetween(double min, double max) {
        return this.income >= min && this.income <= max;
    }

    public boolean isAgeLowerThan(int value) {
        return this.age < value;
    }

    public boolean isFromLocation(String location) {
        return this.location.equalsIgnoreCase(location);
    }

    public boolean isIncomeEqualOrBiggerThan(double value) {
        return this.income >= value;
    }
}
