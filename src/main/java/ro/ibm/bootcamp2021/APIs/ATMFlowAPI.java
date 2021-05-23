package ro.ibm.bootcamp2021.APIs;

import ro.ibm.bootcamp2021.Exceptions.NullAccountException;
import ro.ibm.bootcamp2021.Exceptions.UnknownCVVCodeException;
import ro.ibm.bootcamp2021.Exceptions.UnknownPINException;

public class ATMFlowAPI {
    public static void startATM(){
        try {
            AuthenticationAPI.beginSession();
            MenuAPI.displayValidOperations();
            MenuAPI.processMenuChoice(MenuAPI.receiveMenuChoice());
        } catch (UnsupportedOperationException | NullAccountException | UnknownCVVCodeException | UnknownPINException e) {
            System.err.println(e.getMessage());
        }

    }
}
