package ro.ibm.bootcamp2021.ATMCore.Operations.Exchange;

import ro.ibm.bootcamp2021.APIs.DBOperationsAPI;
import ro.ibm.bootcamp2021.ATMCore.ATMCore;
import ro.ibm.bootcamp2021.ATMCore.CommonFunctionalitiesInterface;
import ro.ibm.bootcamp2021.ATMCore.InputRequest;
import ro.ibm.bootcamp2021.ATMCore.Operations.AbstractRequestHandler;
import ro.ibm.bootcamp2021.AccountCore.Account;

import java.io.IOException;

public class ExchangeAmount extends AbstractRequestHandler {
    @Override
    public void handleRequest(InputRequest request, Account currentAccount) {
        if(request != null && currentAccount != null){
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
    }
}
