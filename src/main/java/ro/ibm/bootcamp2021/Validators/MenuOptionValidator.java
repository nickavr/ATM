package ro.ibm.bootcamp2021.Validators;

import ro.ibm.bootcamp2021.ATMCore.MenuOptions;
import ro.ibm.bootcamp2021.Exceptions.UnknownPINException;

public interface MenuOptionValidator {
    static boolean validateMenuOption(String option){
        if(!option.chars().allMatch( Character::isDigit )){
            throw new UnsupportedOperationException("Unknown option");
        }

        for(MenuOptions menuOption : MenuOptions.values()){
            if(Integer.parseInt(option) == menuOption.getOperationCode()){
                return true;
            }
        }
        return false;
    }
}
