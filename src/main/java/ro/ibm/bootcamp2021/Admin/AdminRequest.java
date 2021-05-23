package ro.ibm.bootcamp2021.Admin;

import ro.ibm.bootcamp2021.ATMCore.CurrencyType;
import ro.ibm.bootcamp2021.ATMCore.GeneralRequest;

public class AdminRequest extends GeneralRequest {
    String adminCode;

    public AdminRequest(String adminCode) {
        super(0.0, null);
        this.adminCode = adminCode;
    }

    public AdminRequest(Double amount, CurrencyType currencyType, String adminCode) {
        super(amount, currencyType);
        this.adminCode = adminCode;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }
}
