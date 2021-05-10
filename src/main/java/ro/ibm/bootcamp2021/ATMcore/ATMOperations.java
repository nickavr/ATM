package ro.ibm.bootcamp2021.ATMcore;



public interface ATMOperations {
    void depositMoney(Double amount, CurrencyType currencyType) throws UnsupportedOperationException;
    void withdrawMoney(Double amount, CurrencyType currencyType) throws UnsupportedOperationException;
}
