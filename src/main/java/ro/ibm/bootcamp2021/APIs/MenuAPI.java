package ro.ibm.bootcamp2021.APIs;

import ro.ibm.bootcamp2021.ATMCore.InputRequest;
import ro.ibm.bootcamp2021.ATMCore.MenuOptions;
import ro.ibm.bootcamp2021.ATMCore.Operations.AbstractRequestHandler;
import ro.ibm.bootcamp2021.ATMCore.Operations.Common.AmountProcess;
import ro.ibm.bootcamp2021.ATMCore.Operations.Common.EndSession;
import ro.ibm.bootcamp2021.ATMCore.Operations.Interogation.GetCurrentSold;
import ro.ibm.bootcamp2021.ATMCore.Operations.OperationChainProcessor;
import ro.ibm.bootcamp2021.Validators.MenuOptionValidator;

import java.util.Scanner;

public class MenuAPI {

    private static Scanner scanner = new Scanner(System.in);

    public static void displayValidOperations(){
        for (MenuOptions option: MenuOptions.values()) {
            System.out.println("For " + option + " enter: " + option.getOperationCode());
        }
    }

    public static MenuOptions receiveMenuChoice() throws UnsupportedOperationException{
        String menuChoice = scanner.next();
        if(!MenuOptionValidator.validateMenuOption(menuChoice)) {
            throw new UnsupportedOperationException("Invalid menu option");
        }
            return MenuOptions.getOptionWithCode(Integer.parseInt(menuChoice));

    }

    public static void processMenuChoice(MenuOptions option) throws UnsupportedOperationException{
        //Potential command refactoring
        InputRequest inputRequest = new InputRequest(option);
        AbstractRequestHandler requestHandler = null;
        switch(option){
            case INTEROGARE_SOLD:
                requestHandler = new GetCurrentSold();
                OperationChainProcessor.setSoldInterrogationProcess(requestHandler);
                break;
            case DEPUNERE:
                requestHandler = new AmountProcess();
                OperationChainProcessor.setDepositAmountProcess(requestHandler);
                break;
            case RETRAGERE:
                requestHandler = new AmountProcess();
                OperationChainProcessor.setRetrieveAmountProcess(requestHandler);
                break;
            case EXCHANGE:
                requestHandler = new AmountProcess();
                OperationChainProcessor.setExchangeAmountProcess(requestHandler);
                break;
            case END_SESSION:
                requestHandler = new EndSession();
                break;
            default:
                throw new UnsupportedOperationException("Unknown menu option");
        }
        requestHandler.handleRequest(inputRequest, AuthenticationAPI.getAccount());

    }

}
