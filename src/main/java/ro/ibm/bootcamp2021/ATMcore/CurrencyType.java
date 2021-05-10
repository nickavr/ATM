package ro.ibm.bootcamp2021.ATMcore;

public enum CurrencyType {
    RON("RON"), EURO("€"), DOLLAR("$");

    private String currencySign;

    CurrencyType(String currency) {
        this.currencySign = currency;
    }

    public String getCurrencySign() {
        return currencySign;
    }
}
