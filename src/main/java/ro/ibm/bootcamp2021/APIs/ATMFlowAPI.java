package ro.ibm.bootcamp2021.APIs;

public class ATMFlowAPI {
    public static void startATM(){
        System.out.println("Welcome!");
        //AuthentificationAPI.beginSession();
        MenuAPI.displayValidOperations();
        MenuAPI.processMenuChoice(MenuAPI.receiveMenuChoice());
    }
}
