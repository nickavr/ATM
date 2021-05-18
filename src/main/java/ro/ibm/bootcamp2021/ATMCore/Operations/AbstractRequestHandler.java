package ro.ibm.bootcamp2021.ATMCore.Operations;

import ro.ibm.bootcamp2021.ATMCore.MenuOptions;
import ro.ibm.bootcamp2021.AccountCore.Account;

public abstract class AbstractRequestHandler {
    public AbstractRequestHandler nextProcess = null;
    public abstract void handleRequest(Account account, Double amount, MenuOptions option);
}
