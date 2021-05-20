package ro.ibm.bootcamp2021.ATMCore;

public class ATMCore {
    private Double ATMAvailableAmount;
    private CurrencyType ATMAmountCurrency;
    private String unlockAccountCode;

    public ATMCore(Double ATMAvailableAmount, String ATMAmountCurrency, String unlockAccountCode) {
        this.ATMAvailableAmount = ATMAvailableAmount;
        this.ATMAmountCurrency = CurrencyType.getCurrencyWithCode(ATMAmountCurrency);
        this.unlockAccountCode = unlockAccountCode;
    }

    @Override
    public String toString() {
        return "ATMCore{" +
                "ATMAvailableAmount=" + ATMAvailableAmount +
                ", ATMAmountCurrency=" + ATMAmountCurrency +
                ", unlockAccountCode='" + unlockAccountCode + '\'' +
                '}';
    }

    public Double getATMAvailableAmount() {
        return ATMAvailableAmount;
    }

    public void setATMAvailableAmount(Double ATMAvailableAmount) {
        this.ATMAvailableAmount = ATMAvailableAmount;
    }

    public CurrencyType getATMAmountCurrency() {
        return ATMAmountCurrency;
    }

    public void setATMAmountCurrency(CurrencyType ATMAmountCurrency) {
        this.ATMAmountCurrency = ATMAmountCurrency;
    }

    public String getUnlockAccountCode() {
        return unlockAccountCode;
    }

    public void setUnlockAccountCode(String unlockAccountCode) {
        this.unlockAccountCode = unlockAccountCode;
    }
}
