package ro.ibm.bootcamp2021.ATMCore.Operations.Common;

import ro.ibm.bootcamp2021.APIs.MenuAPI;
import ro.ibm.bootcamp2021.ATMCore.InputRequest;
import ro.ibm.bootcamp2021.ATMCore.Operations.AbstractRequestHandler;
import ro.ibm.bootcamp2021.AccountCore.Account;

public class MenuDisplay extends AbstractRequestHandler {
    @Override
    public void handleRequest(InputRequest request, Account currentAccount) {
        MenuAPI.displayValidOperations();
        MenuAPI.processMenuChoice(MenuAPI.receiveMenuChoice());
    }
}
