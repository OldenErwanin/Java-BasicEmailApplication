package emailapp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 8;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created: " + this.firstName + " " + this.lastName);

        // Call a method asking for the department, return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        // Call a method that returns a random password
        this.password = generatePassword(defaultPasswordLength);
        System.out.println("Your password: " + this.password);

        // Combine created elements to generate the email
        this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department + "." + this.companySuffix;
        System.out.println("Your email: " + this.email);
    }

    // Ask for the department
    private String setDepartment() {
        System.out.print("Choose a department:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter: ");
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        in.close();
        if (option == 1) { return "Sales"; }
        else if (option == 2) { return "dev"; }
        else if (option == 3) { return "acct"; }
        else { return ""; }
    }

    // Generate a random password
    private String generatePassword(int length) {
        String rPasswordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@$?#&%";
        char[] rPassword = new char[length];
        for (int i = 0; i < length; i++) {
            int randomChar = (int) (Math.random() * rPasswordSet.length());
            rPassword[i] = rPasswordSet.charAt(randomChar);
        }
        return new String(rPassword);
    }

    // Change the password
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }
}
