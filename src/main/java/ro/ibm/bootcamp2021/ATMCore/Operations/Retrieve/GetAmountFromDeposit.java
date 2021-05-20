package ro.ibm.bootcamp2021.ATMCore.Operations.Retrieve;

import ro.ibm.bootcamp2021.APIs.DBOperationsAPI;
import ro.ibm.bootcamp2021.ATMCore.ATMCore;
import ro.ibm.bootcamp2021.ATMCore.InputRequest;
import ro.ibm.bootcamp2021.ATMCore.Operations.AbstractRequestHandler;
import ro.ibm.bootcamp2021.ATMCore.Operations.Common.MenuDisplay;
import ro.ibm.bootcamp2021.AccountCore.Account;

public class GetAmountFromDeposit extends AbstractRequestHandler {
    @Override
    public void handleRequest(InputRequest request, Account currentAccount) {
        if(request.getCurrencyType() == currentAccount.getAccountCurrency()){
            currentAccount.setDeposit(currentAccount.getDeposit() - request.getAmount());
            ATMCore atmCore = DBOperationsAPI.getAtmCore();
            atmCore.setATMAvailableAmount(atmCore.getATMAvailableAmount() - request.getAmount());
            currentAccount.displayDeposit();
            if(this.getNextProcess() != null){
                this.getNextProcess().handleRequest(request, currentAccount);
            }
        }
        else{
            System.out.println("Just " + currentAccount.getAccountCurrency() + " permitted");
            new MenuDisplay().handleRequest(request, currentAccount);
        }
    }
}
