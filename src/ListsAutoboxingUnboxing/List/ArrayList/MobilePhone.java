package ListsAutoboxingUnboxing.List.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
  private String mNumber;
  private static ArrayList<Contact> myContacts;
  private static MobilePhone phone = new MobilePhone("00 11 22 33");


  public MobilePhone(String mNumber) {
    this.mNumber = mNumber;
    this.myContacts = new ArrayList<>();
  }

  public static boolean addNewContact(Contact contact) {
    if (findContact(contact) >= 0){
      System.out.println("Contact is already there");
      return false;
    }
    myContacts.add(contact);
    return true;

  }

  public boolean updateContact(Contact newContact, Contact oldContact){
    int oldPosition = findContact(oldContact);
    if (oldPosition < 0){
      System.out.println(oldContact.getName() + " was not found");
      return false;
    } else if(findContact(newContact.getName()) != -1) {
      System.out.println("Contact with name " + newContact.getName() + " already exists. Update isn't successful");
      return false;
    }

    myContacts.set(oldPosition, newContact);
    System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
    return true;
  }

  private static int findContact(Contact contact) {
    return myContacts.indexOf(contact);
  }

  public boolean removeContact (Contact contact) {
    int oldPosition = findContact(contact);
    if (oldPosition < 0){
      System.out.println(contact.getName() + " was not found");
      return false;
    }

    myContacts.remove(oldPosition);
    System.out.println(contact.getName() + " was deleted");
    return true;
  }

  public static String queryContact(Contact contact) {
    if (findContact(contact) >= 0 ) return  contact.getName();

    return null;
  }

  public static Contact queryContact(String name) {
    int position = findContact(name);
    if (position >= 0 ) return  myContacts.get(position);

    return null;
  }

  private static int findContact(String contactName){
    for (Contact contact: myContacts) {
      if (contact.getName().equals(contactName)){
        return myContacts.indexOf(contact);
      }
    }
    return -1;
  }
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    boolean quit = false;
    startPhone();
    printActions();
    while (!quit) {
      System.out.println("\nEnter action : ");
      int action =  scanner.nextInt();
      scanner.nextLine();

      switch (action) {
        case 0:
          System.out.println("\nShutting down...");
          quit =true;
          break;

        case 1:
          phone.printContacts();
          break;

        case 2:
          addNewContact();
          break;

        case 3:
          updateContact();
          break;

        case 4:
          removeContact();
          break;

        case 5:
          queryContact();
          break;

        case 6:
          printActions();
          break;
      }
    }
  }

  private static void updateContact(){
    System.out.println("Enter existing Contact name:");
    String name = scanner.nextLine();
    Contact existContact = queryContact(name);

    if (existContact == null) {
      System.out.println("Contact not found");
      return;
    }

    System.out.println("Enter new name: ");
    String newName = scanner.nextLine();
    System.out.println("Enter new contact phone number");
    String newNumber = scanner.nextLine();

    Contact newContact = Contact.createContact(newName, newNumber);

    if (phone.updateContact(newContact, existContact)) System.out.println(" Successfull");
    else System.out.println("Error updating Contact");


  }

  private static void removeContact() {
    System.out.println("Enter existing Contact name:");
    String name = scanner.nextLine();
    Contact existContact = queryContact(name);

    if (existContact == null) {
      System.out.println("Contact not found");
      return;
    }

    if (phone.removeContact(existContact)) System.out.println(" Successfull");
    else System.out.println("Error deleting Contact");
  }

  private static void queryContact() {
    System.out.println("Enter existing Contact name:");
    String name = scanner.nextLine();
    Contact existContact = queryContact(name);

    if (existContact == null) {
      System.out.println("Contact not found");
      return;
    }
    System.out.println("Name: " + existContact.getName() + " phone is " + existContact.getPhoneNumber());

  }

  private static void addNewContact(){
    System.out.println("Enter new Contact name:");
    String name = scanner.nextLine();
    System.out.println("Enter phone number: ");
    String phone = scanner.nextLine();

    Contact newContact = Contact.createContact(name, phone);

    if (addNewContact(newContact)) System.out.println("Added new Contact");
    else System.out.println("Contact is already created");
  }

  private void printContacts(){
    System.out.println("CONTACTS");
    int i = 1;
    for (Contact contact : myContacts) {
      System.out.println(i + "." + contact.getName()+ " -> " + contact.getPhoneNumber());
    }

  }

  private static void startPhone() {
    System.out.println("Starting Phone....");
  }

  public static void printActions() {
    System.out.println("\nAvailable actions: \npress");
    System.out.println( "0 - to shutdown\n" +
                        "1 - to print contacts\n" +
                        "2 - to add a new contact\n" +
                        "3 - to update a contact\n" +
                        "4 - to remove a contact\n" +
                        "5 - to query if a contact is exists\n" +
                        "6 - to print a list of available actions"
            );
    System.out.println("Choose your action");


  }

}
