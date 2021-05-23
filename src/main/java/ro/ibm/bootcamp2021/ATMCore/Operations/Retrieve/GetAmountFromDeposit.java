package ro.ibm.bootcamp2021.ATMCore.Operations.Retrieve;

import ro.ibm.bootcamp2021.APIs.DBOperationsAPI;
import ro.ibm.bootcamp2021.ATMCore.InputRequest;
import ro.ibm.bootcamp2021.ATMCore.Operations.AbstractRequestHandler;
import ro.ibm.bootcamp2021.ATMCore.Operations.Common.MenuDisplay;
import ro.ibm.bootcamp2021.AccountCore.Account;

import java.io.IOException;

public class GetAmountFromDeposit extends AbstractRequestHandler {
    @Override
    public void handleRequest(InputRequest request, Account currentAccount) {
        if(request.getCurrencyType() == currentAccount.getAccountCurrency()){
            try {
                DBOperationsAPI.addNewTransactionToFile(request.getOption().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            currentAccount.setDeposit(currentAccount.getDeposit() - request.getAmount());
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
