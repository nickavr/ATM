package ro.ibm.bootcamp2021.AccountCore;

import ro.ibm.bootcamp2021.ATMCore.CurrencyType;

public class Account {
    String firstName;
    String lastName;
    Integer CVV;
    Integer PIN;
    Double deposit;
    CurrencyType currency;
    boolean isActive;

    public Account(String firstName, String lastName,
                   Integer CVV, Integer PIN, Double deposit, String currency, boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.CVV = CVV;
        this.PIN = PIN;
        this.deposit = deposit;
        this.currency = CurrencyType.getCurrencyWithCode(currency);
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Account{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", CVV=" + CVV +
                ", PIN=" + PIN +
                ", deposit=" + deposit +
                ", accountCurrency=" + currency +
                '}';
    }

    public CurrencyType getAccountCurrency() {
        return currency;
    }

    public Integer getCVV() {
        return CVV;
    }

    public Integer getPIN() {
        return PIN;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public void displayDeposit(){
        System.out.println("Your deposit: " + this.getDeposit() + this.getAccountCurrency());
    }
}
