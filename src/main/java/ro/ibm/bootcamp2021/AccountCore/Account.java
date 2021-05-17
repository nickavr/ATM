package ro.ibm.bootcamp2021.AccountCore;

import ro.ibm.bootcamp2021.Exceptions.UnknownCVVCodeException;
import ro.ibm.bootcamp2021.Exceptions.UnknownPINException;

public class Account implements AccountActions{
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

    @Override
    public void checkCVVCode(Integer code) throws UnknownCVVCodeException {

    }

    @Override
    public void checkPIN(Integer pin) throws UnknownPINException {

    }
}
