package OOP1ClasssesConstructorInheritance;

public class ConstructorExamBankAccount {
  // Create a new class for a bank account
  // Create fields for the account number, balance, customer name, email and phone number.
  //
  // Create getters and setters for each field
  // Create two additional methods
  // 1. To allow the customer to deposit funds (this should increment the balance field).
  // 2. To allow the customer to withdraw funds. This should deduct from the balance field,
  // but not allow the withdrawal to complete if their are insufficient funds.
  // You will want to create various code in the Main class (the one created by IntelliJ) to
  // confirm your code is working.
  // Add some System.out.println's in the two methods above as well.

  private int accountNumber;
  private double balance;
  private String customerName;
  private String email;
  private String phone;

  public ConstructorExamBankAccount(int accountNumber, double balance, String customerName, String email, String phone) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.customerName = customerName;
    this.email = email;
    this.phone = phone;
  }
  public ConstructorExamBankAccount() {
    // if want to add default values you can do that like that
    this(12345, 0.0, "default Name", "default@email.com", "+431233445678");
  }

  public void deposit(double depositAmount){
    this.balance += depositAmount;
  }

  public void withdrawal(double withdrawAmount) {
    if (this.balance - withdrawAmount < 0) {
      System.out.println("Only " + this.balance + " available.");
    } else {
      balance -= withdrawAmount;
      System.out.println("Withdrawal of " + withdrawAmount + " processed. Remaining Balance is " + this.balance);
    }
  }

  public int getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(int accountNumber) {
    this.accountNumber = accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
