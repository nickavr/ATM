package ro.ibm.bootcamp2021.Admin.OperationsChain;

import ro.ibm.bootcamp2021.APIs.DBOperationsAPI;
import ro.ibm.bootcamp2021.Admin.AdminRequest;

import java.util.ArrayList;

public class TraceATMActions extends AdminAbstractRequestHandler{
    @Override
    public void handleRequest(AdminRequest request) {
        if(request != null){
            if(request.getAdminCode().equals(DBOperationsAPI.getAtmCore().getTraceATMActions())){
                ArrayList<String> transactions = DBOperationsAPI.getAllTransactions();
                for(String transaction : transactions){
                    System.out.println(transaction);
                }
                return;
            }
        }

        if(this.getNextProcess() != null){
            this.getNextProcess().handleRequest(request);
        }

    }
}
