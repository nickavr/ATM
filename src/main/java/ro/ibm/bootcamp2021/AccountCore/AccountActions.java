package ro.ibm.bootcamp2021.AccountCore;

import ro.ibm.bootcamp2021.Exceptions.UnknownCVVCodeException;
import ro.ibm.bootcamp2021.Exceptions.UnknownPINException;

public interface AccountActions {
    void checkCVVCode(Integer code) throws UnknownCVVCodeException;
    void checkPIN(Integer pin) throws UnknownPINException;
}
