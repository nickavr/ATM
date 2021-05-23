package ro.ibm.bootcamp2021.Admin.OperationsChain;

import ro.ibm.bootcamp2021.APIs.AuthenticationAPI;
import ro.ibm.bootcamp2021.APIs.DBOperationsAPI;
import ro.ibm.bootcamp2021.ATMCore.CurrencyType;
import ro.ibm.bootcamp2021.ATMCore.InputRequest;
import ro.ibm.bootcamp2021.ATMCore.Operations.Common.MenuDisplay;
import ro.ibm.bootcamp2021.Admin.AdminRequest;
import ro.ibm.bootcamp2021.Validators.AmountInputValidator;

import java.util.Scanner;

public class ProcessAdminAmount extends AdminAbstractRequestHandler{
    private static Scanner scanner = new Scanner(System.in);
    @Override
    public void handleRequest(AdminRequest request) {
        if(request != null){

            String adminCode = request.getAdminCode();
            String addAmountCode = DBOperationsAPI.getAtmCore().getAddMoneyToATMCode();
            String withdrawAmountCode = DBOperationsAPI.getAtmCore().getWithdrawMoneyFromATMCode();

            if(adminCode.equals(addAmountCode) || adminCode.equals(withdrawAmountCode)){

                System.out.println("Enter amount: ");
                String inputAmountString = scanner.next();

                if(AmountInputValidator.amountInputValidator(inputAmountString)){
                    transformInputToRequest(inputAmountString, request);
                }
                else{
                    System.out.println("Incorrect format!");
                    return;
                }
            }else{
                this.setNextProcess(new WrongCodeProcess());
                this.getNextProcess().handleRequest(request);
                return;
            }

        }
        if(this.getNextProcess() != null){
            this.getNextProcess().handleRequest(request);
        }
    }

    private void transformInputToRequest(String input, AdminRequest request){
        Double inputAmount = Double.parseDouble(input.replaceAll("[^0-9]", ""));
        CurrencyType amountCurrency
                = CurrencyType.getCurrencyWithSign(input.replaceAll("\\d", ""));
        request.setAmount(inputAmount);
        request.setCurrencyType(amountCurrency);
    }
}
