package ro.ibm.bootcamp2021.ATMCore;

public class ATMDeposit {
    private Double ATMAvailableAmount;
    private CurrencyType ATMAmountCurrency;

    public ATMDeposit(Double ATMAvailableAmount, String ATMAmountCurrency) {
        this.ATMAvailableAmount = ATMAvailableAmount;
        this.ATMAmountCurrency = CurrencyType.getCurrencyWithCode(ATMAmountCurrency);
    }

    public CurrencyType getATMAmountCurrency() {
        return ATMAmountCurrency;
    }

    public void setATMAmountCurrency(CurrencyType ATMAmountCurrency) {
        this.ATMAmountCurrency = ATMAmountCurrency;
    }

    public Double getATMAvailableAmount() {
        return ATMAvailableAmount;
    }

    public void setATMAvailableAmount(Double ATMAvailableAmount) {
        this.ATMAvailableAmount = ATMAvailableAmount;
    }
}
