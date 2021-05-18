package ro.ibm.bootcamp2021.Validators;

import ro.ibm.bootcamp2021.ATMCore.MenuOptions;

public interface MenuOptionValidator {
    static boolean validateMenuOption(Integer option){

        for(MenuOptions menuOption : MenuOptions.values()){
            if(option == menuOption.getOperationCode()){
                return true;
            }
        }
        return false;
    }
}
