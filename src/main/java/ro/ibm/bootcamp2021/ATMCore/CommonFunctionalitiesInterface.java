package ro.ibm.bootcamp2021.ATMCore;

import ro.ibm.bootcamp2021.APIs.DBOperationsAPI;

public abstract class CommonFunctionalitiesInterface {
    public static void setATMNewDeposit(CurrencyType requestCurrencyType, Double amount, MenuOptions option){
        ATMCore atmCore = DBOperationsAPI.getAtmCore();
        ATMDeposit atmDeposit = atmCore.findDepositByCurrency(requestCurrencyType);
        if(option == MenuOptions.EXCHANGE || option == MenuOptions.RETRAGERE){
            atmDeposit.setATMAvailableAmount(atmDeposit.getATMAvailableAmount() - amount);
        }
        else{
            atmDeposit.setATMAvailableAmount(atmDeposit.getATMAvailableAmount() + amount);
        }

    }
}
