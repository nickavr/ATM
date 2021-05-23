package ro.ibm.bootcamp2021.ATMCore.Operations.Common;

import ro.ibm.bootcamp2021.ATMCore.CurrencyType;
import ro.ibm.bootcamp2021.ATMCore.InputRequest;
import ro.ibm.bootcamp2021.ATMCore.Operations.AbstractRequestHandler;
import ro.ibm.bootcamp2021.AccountCore.Account;
import ro.ibm.bootcamp2021.Validators.AmountInputValidator;

import java.util.Scanner;

public class AmountProcess extends AbstractRequestHandler {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public void handleRequest(InputRequest request, Account currentAccount) {
        System.out.println("Enter amount: ");
        String inputAmountString = scanner.next();
        if(AmountInputValidator.amountInputValidator(inputAmountString)){
            transformInputToRequest(inputAmountString, request);
            System.out.println(request.toString());
            if(this.getNextProcess() != null){
                this.getNextProcess().handleRequest(request, currentAccount);
            }
        }else{
            System.out.println("Incorrect format!");
            new MenuDisplay().handleRequest(request, currentAccount);
        }
    }

    private void transformInputToRequest(String input, InputRequest request){
        Double inputAmount = Double.parseDouble(input.replaceAll("[^0-9]", ""));
        CurrencyType amountCurrency
                = CurrencyType.getCurrencyWithSign(input.replaceAll("\\d", ""));
        request.setAmount(inputAmount);
        request.setCurrencyType(amountCurrency);
    }
}
