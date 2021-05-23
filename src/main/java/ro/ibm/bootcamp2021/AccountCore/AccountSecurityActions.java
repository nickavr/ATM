package ro.ibm.bootcamp2021.AccountCore;

import ro.ibm.bootcamp2021.Exceptions.UnknownCVVCodeException;
import ro.ibm.bootcamp2021.Exceptions.UnknownPINException;

public interface AccountSecurityActions {
   static void checkCVVCode(String code) throws UnknownCVVCodeException{
      if(!code.chars().allMatch( Character::isDigit )){
         throw new UnknownCVVCodeException("Unknown CVV");
      }
   }
   static void checkPIN(String pin) throws UnknownPINException{
      if(!pin.chars().allMatch( Character::isDigit )){
         throw new UnknownPINException("Unknown PIN");
      }
   }
}
