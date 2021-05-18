package ro.ibm.bootcamp2021.APIs;

import ro.ibm.bootcamp2021.ATMCore.MenuOptions;
import ro.ibm.bootcamp2021.Validators.MenuOptionValidator;

import java.util.Scanner;

public class MenuAPI {

    private static Scanner scanner = new Scanner(System.in);

    public static void displayValidOperations(){
        for (MenuOptions option: MenuOptions.values()) {
            System.out.println("For " + option + " enter: " + option.getOperationCode());
        }
    }

    public static Integer receiveMenuChoice(){
        Integer menuChoice = scanner.nextInt();
        if(!MenuOptionValidator.validateMenuOption(menuChoice)){
            System.out.println("Invalid option, try again: ");
            receiveMenuChoice();
        }
        return menuChoice;
    }

    public static void processMenuChoice(Integer option){
        //TODO: (implement and) start the chain of responsability here
    }
}
