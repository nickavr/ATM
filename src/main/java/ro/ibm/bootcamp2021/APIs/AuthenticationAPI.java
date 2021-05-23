package ro.ibm.bootcamp2021.APIs;

import ro.ibm.bootcamp2021.AccountCore.Account;
import ro.ibm.bootcamp2021.AccountCore.AccountSecurityActions;
import ro.ibm.bootcamp2021.Admin.AdminOperations;
import ro.ibm.bootcamp2021.Admin.AdminRequest;
import ro.ibm.bootcamp2021.Admin.OperationsChain.AdminAbstractRequestHandler;
import ro.ibm.bootcamp2021.Admin.OperationsChain.ChainProcessor;
import ro.ibm.bootcamp2021.Admin.OperationsChain.UnlockUser;
import ro.ibm.bootcamp2021.Exceptions.NullAccountException;
import ro.ibm.bootcamp2021.Exceptions.UnknownCVVCodeException;
import ro.ibm.bootcamp2021.Exceptions.UnknownPINException;

import java.util.Scanner;

public class AuthenticationAPI {

    private static Account account = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void beginSession() throws NullAccountException, UnknownCVVCodeException, UnknownPINException {
            String adminCode = AdminOperations.inputAdminCode();
            if(adminCode != null) {
                AdminRequest adminRequest = new AdminRequest(adminCode);
                AdminAbstractRequestHandler requestHandler = new UnlockUser();
                ChainProcessor.setAdminProcess(requestHandler);
                requestHandler.handleRequest(adminRequest);
            }
            Integer CVV = inputCVV();
            Integer PIN = inputPIN();
            account = DBOperationsAPI.searchAccount(CVV, PIN);
            System.out.println("Welcome, " + account.getFirstName() + ' ' + account.getLastName());
    }

    public static Account getAccount() {
        if(account != null){
            return account;
        }
        throw new UnsupportedOperationException();
    }

    private static Integer inputCVV() throws UnknownCVVCodeException {
        System.out.println("Input your CVV: ");
        String CVV = scanner.next();
        AccountSecurityActions.checkCVVCode(CVV);
        return Integer.parseInt(CVV);
    }

    private static Integer inputPIN() throws UnknownPINException {
        System.out.println("Input PIN: ");
        String PIN = scanner.next();
        AccountSecurityActions.checkPIN(PIN);
        return Integer.parseInt(PIN);
    }


}
