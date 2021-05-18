package ro.ibm.bootcamp2021.APIs;

import ro.ibm.bootcamp2021.AccountCore.Account;
import ro.ibm.bootcamp2021.AccountCore.AccountSecurityActions;
import ro.ibm.bootcamp2021.Exceptions.UnknownCVVCodeException;
import ro.ibm.bootcamp2021.Exceptions.UnknownPINException;

public class AuthentificationAPI {

    private static Account account = null;

    public static void beginSession(Integer CVV, Integer PIN){
        try{
            AccountSecurityActions.checkCVVCode(CVV);
            AccountSecurityActions.checkPIN(PIN);
            account = DBOperationsAPI.searchAccount(CVV, PIN);
        } catch (UnknownCVVCodeException | UnknownPINException e) {
            e.printStackTrace();
        }
    }

    public static Account getAccount() {
        return account;
    }
}
