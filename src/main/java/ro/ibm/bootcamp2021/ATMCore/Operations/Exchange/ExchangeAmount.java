package ro.ibm.bootcamp2021.ATMCore.Operations.Exchange;

import ro.ibm.bootcamp2021.ATMCore.InputRequest;
import ro.ibm.bootcamp2021.ATMCore.Operations.AbstractRequestHandler;
import ro.ibm.bootcamp2021.AccountCore.Account;

public class ExchangeAmount extends AbstractRequestHandler {
    @Override
    public void handleRequest(InputRequest request, Account currentAccount) {
        if(request != null && currentAccount != null){
            currentAccount.setDeposit(currentAccount.getDeposit() - request.getAmount());
            currentAccount.displayDeposit();
            if(this.getNextProcess() != null){
                this.getNextProcess().handleRequest(request, currentAccount);
            }
        }
    }
}
