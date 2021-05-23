package ro.ibm.bootcamp2021.Admin;

import java.util.Scanner;

public interface AdminOperations {
    static final Scanner scanner = new Scanner(System.in);

    static String inputAdminCode(){
        System.out.println("Enter admin code, if you're an user press enter.");
        String adminCode = scanner.nextLine();
        return adminCode;
    }
}
