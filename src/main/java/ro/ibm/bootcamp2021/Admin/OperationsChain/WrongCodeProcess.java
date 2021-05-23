package ro.ibm.bootcamp2021.Admin.OperationsChain;

import ro.ibm.bootcamp2021.Admin.AdminRequest;

public class WrongCodeProcess extends AdminAbstractRequestHandler{
    @Override
    public void handleRequest(AdminRequest request) {
        System.out.println("Wrong code, entering user menu.");
    }
}
