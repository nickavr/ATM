package ro.ibm.bootcamp2021.APIs;

public class ATMFlowAPI {
    public static void startATM(){
        AuthentificationAPI.beginSession();
        MenuAPI.displayValidOperations();
        MenuAPI.processMenuChoice(MenuAPI.receiveMenuChoice());
    }
}
