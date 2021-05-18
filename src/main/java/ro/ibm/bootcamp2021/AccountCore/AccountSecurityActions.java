package ro.ibm.bootcamp2021.AccountCore;

import ro.ibm.bootcamp2021.Exceptions.UnknownCVVCodeException;
import ro.ibm.bootcamp2021.Exceptions.UnknownPINException;

public interface AccountSecurityActions {
   static void checkCVVCode(Integer code) throws UnknownCVVCodeException{
      //TODO: validate code
   }
   static void checkPIN(Integer pin) throws UnknownPINException{
      //TODO: validate pin
   }
}
