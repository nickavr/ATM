package ro.ibm.bootcamp2021.ATMCore;

public class ATMCore {
    private ATMDeposit[] deposits;
    private String unlockAccountCode;
    private String addMoneyToATMCode;

    public ATMCore(ATMDeposit[] deposits, String unlockAccountCode, String addMoneyToATMCode) {
        this.deposits = deposits;
        this.unlockAccountCode = unlockAccountCode;
        this.addMoneyToATMCode = addMoneyToATMCode;
    }

    public ATMDeposit[] getDeposits() {
        return deposits;
    }

    public ATMDeposit findDepositByCurrency(CurrencyType currencyType){
        for(int i = 0; i < deposits.length; i++){
            if(deposits[i].getATMAmountCurrency() == currencyType){
                return deposits[i];
            }
        }
        throw new UnsupportedOperationException();
    }

    public String getUnlockAccountCode() {
        return unlockAccountCode;
    }

    public void setUnlockAccountCode(String unlockAccountCode) {
        this.unlockAccountCode = unlockAccountCode;
    }

    public String getAddMoneyToATMCode() {
        return addMoneyToATMCode;
    }

    public void setAddMoneyToATMCode(String addMoneyToATMCode) {
        this.addMoneyToATMCode = addMoneyToATMCode;
    }
}
