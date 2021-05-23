package ro.ibm.bootcamp2021.Admin.OperationsChain;

import ro.ibm.bootcamp2021.APIs.DBOperationsAPI;
import ro.ibm.bootcamp2021.ATMCore.CommonFunctionalitiesInterface;
import ro.ibm.bootcamp2021.ATMCore.MenuOptions;
import ro.ibm.bootcamp2021.Admin.AdminRequest;

import java.io.IOException;

public class WithdrawAmountFromATM extends AdminAbstractRequestHandler{
    @Override
    public void handleRequest(AdminRequest request) {
        if(request.getAdminCode().equals(DBOperationsAPI.getAtmCore().getWithdrawMoneyFromATMCode())){
            CommonFunctionalitiesInterface.setATMNewDeposit(request.getCurrencyType(),
                    request.getAmount(), MenuOptions.EXCHANGE);
            try {
                DBOperationsAPI.rewriteATMValues();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(this.getNextProcess() != null){
            this.getNextProcess().handleRequest(request);
        }
    }
}
