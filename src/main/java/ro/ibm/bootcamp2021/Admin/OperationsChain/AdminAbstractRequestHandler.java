package ro.ibm.bootcamp2021.Admin.OperationsChain;


import ro.ibm.bootcamp2021.ATMCore.InputRequest;
import ro.ibm.bootcamp2021.Admin.AdminRequest;

public abstract class AdminAbstractRequestHandler {
    private AdminAbstractRequestHandler nextProcess = null;
    public abstract void handleRequest(AdminRequest request);

    public void setNextProcess(AdminAbstractRequestHandler nextProcess) {
        this.nextProcess = nextProcess;
    }

    public AdminAbstractRequestHandler getNextProcess() {
        return nextProcess;
    }
}
