package ro.ibm.bootcamp2021.ATMCore;

public interface ATMAccountOperations {
    void depositMoney(Double amount, CurrencyType currencyType) throws UnsupportedOperationException;
    void withdrawMoney(Double amount, CurrencyType currencyType) throws UnsupportedOperationException;
}
