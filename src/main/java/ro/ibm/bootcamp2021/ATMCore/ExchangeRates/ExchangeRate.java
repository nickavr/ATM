package ro.ibm.bootcamp2021.ATMCore.ExchangeRates;

import ro.ibm.bootcamp2021.ATMCore.CurrencyType;

public class ExchangeRate {

    private Double conversionRate;
    private CurrencyType amountCurrency;
    private CurrencyType accountCurrency;

    ExchangeRate(Double conversionRate, String amountCurrency, String accountCurrency) {
        this.conversionRate = conversionRate;
        this.amountCurrency = CurrencyType.getCurrencyWithCode(amountCurrency);
        this.accountCurrency = CurrencyType.getCurrencyWithCode(accountCurrency);
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "conversionRate=" + conversionRate +
                ", amountCurrency=" + amountCurrency +
                ", accountCurrency=" + accountCurrency +
                '}';
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public CurrencyType getAmountCurrency() {
        return amountCurrency;
    }

    public CurrencyType getAccountCurrency() {
        return accountCurrency;
    }


    public Double convertAmount(Double amount){
        return amount * getConversionRate();
    }
}
