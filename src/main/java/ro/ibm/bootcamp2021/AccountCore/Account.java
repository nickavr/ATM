package ro.ibm.bootcamp2021.AccountCore;

public class Account {
    String firstName;
    String lastName;
    Integer CVV;
    Integer PIN;
    Double deposit;

    public Account(String firstName, String lastName, Integer CVV, Integer PIN, Double deposit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.CVV = CVV;
        this.PIN = PIN;
        this.deposit = deposit;
    }

    public Integer getCVV() {
        return CVV;
    }

    public Integer getPIN() {
        return PIN;
    }
}
