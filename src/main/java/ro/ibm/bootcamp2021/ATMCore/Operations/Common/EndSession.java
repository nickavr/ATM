package ro.ibm.bootcamp2021.ATMCore.Operations.Common;

import ro.ibm.bootcamp2021.APIs.DBOperationsAPI;
import ro.ibm.bootcamp2021.ATMCore.InputRequest;
import ro.ibm.bootcamp2021.ATMCore.Operations.AbstractRequestHandler;
import ro.ibm.bootcamp2021.AccountCore.Account;

import java.io.IOException;

public class EndSession extends AbstractRequestHandler {
    @Override
    public void handleRequest(InputRequest request, Account currentAccount) {
        //TODO: rewrite clients file, add transaction to file
        System.out.println("Thank you, " + currentAccount.getFirstName());
        try {
            DBOperationsAPI.rewriteAccountsFileData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
