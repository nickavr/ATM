package ro.ibm.bootcamp2021.Admin.OperationsChain;

import ro.ibm.bootcamp2021.Admin.AdminRequest;

public class UnlockUser extends AdminAbstractRequestHandler{
    @Override
    public void handleRequest(AdminRequest request) {
        if(this.getNextProcess() != null){
            this.getNextProcess().handleRequest(request);
        }
    }
}
