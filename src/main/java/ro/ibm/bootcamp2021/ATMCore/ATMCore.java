package ro.ibm.bootcamp2021.ATMCore;

public class ATMCore {
    private ATMDeposit[] deposits;
    private String unlockAccountCode;
    private String addMoneyToATMCode;
    private String withdrawMoneyFromATMCode;
    private String traceATMActions;

    public ATMCore(ATMDeposit[] deposits, String unlockAccountCode, String addMoneyToATMCode,
                   String withdrawMoneyFromATMCode, String traceATMActions) {
        this.deposits = deposits;
        this.unlockAccountCode = unlockAccountCode;
        this.addMoneyToATMCode = addMoneyToATMCode;
        this.withdrawMoneyFromATMCode = withdrawMoneyFromATMCode;
        this.traceATMActions = traceATMActions;
    }

    public String getTraceATMActions() {
        return traceATMActions;
    }

    public void setTraceATMActions(String traceATMActions) {
        this.traceATMActions = traceATMActions;
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

    public String getWithdrawMoneyFromATMCode() {
        return withdrawMoneyFromATMCode;
    }

    public void setWithdrawMoneyFromATMCode(String withdrawMoneyFromATMCode) {
        this.withdrawMoneyFromATMCode = withdrawMoneyFromATMCode;
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
