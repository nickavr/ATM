package ro.ibm.bootcamp2021.ATMCore.Operations.Deposit;

import ro.ibm.bootcamp2021.ATMCore.InputRequest;
import ro.ibm.bootcamp2021.ATMCore.Operations.AbstractRequestHandler;
import ro.ibm.bootcamp2021.AccountCore.Account;

public class DepositIntoAccount extends AbstractRequestHandler {
    @Override
    public void handleRequest(InputRequest request, Account currentAccount) {
        if(request != null && currentAccount != null){
            currentAccount.setDeposit(request.getAmount() + currentAccount.getDeposit());
            currentAccount.displayDeposit();
        }
        if(this.getNextProcess() != null){
            this.getNextProcess().handleRequest(request, currentAccount);
        }

    }
}
