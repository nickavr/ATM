package ro.ibm.bootcamp2021.ATMCore.Operations;

import ro.ibm.bootcamp2021.ATMCore.InputRequest;
import ro.ibm.bootcamp2021.ATMCore.MenuOptions;
import ro.ibm.bootcamp2021.AccountCore.Account;

public abstract class AbstractRequestHandler {
    private AbstractRequestHandler nextProcess = null;
    public abstract void handleRequest(InputRequest request, Account currentAccount);

    public void setNextProcess(AbstractRequestHandler nextProcess) {
        this.nextProcess = nextProcess;
    }

    public AbstractRequestHandler getNextProcess() {
        return nextProcess;
    }
}
