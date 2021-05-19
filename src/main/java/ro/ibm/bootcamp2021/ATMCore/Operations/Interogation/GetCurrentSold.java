package ro.ibm.bootcamp2021.ATMCore.Operations.Interogation;

import ro.ibm.bootcamp2021.ATMCore.InputRequest;
import ro.ibm.bootcamp2021.ATMCore.Operations.AbstractRequestHandler;
import ro.ibm.bootcamp2021.AccountCore.Account;

public class GetCurrentSold extends AbstractRequestHandler {
    @Override
    public void handleRequest(InputRequest request, Account currentAccount) {

        System.out.println("Your balance is: " + currentAccount.getDeposit() + currentAccount.getAccountCurrency());

        if(this.getNextProcess() != null){
            this.getNextProcess().handleRequest(request, currentAccount);
        }
    }
}
