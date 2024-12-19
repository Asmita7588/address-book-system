import java.util.Locale;
import java.util.Scanner;


public class AddressBookMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To Address Book");

        AddressBook addressBook = new AddressBook();
        while(true) {
            addressBook.addContact();
            System.out.println("Do you want to Add contact again?(y/n)");
            String option = scanner.next().toLowerCase();
            if(option.equals("n")) break;
        }
        addressBook.viewAllContacts();

        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter Address:");
        String address = scanner.nextLine();
        System.out.println("Enter City:");
        String city = scanner.nextLine();
        System.out.println("Enter State:");
        String state = scanner.nextLine();
        System.out.println("Enter Zip:");
        String zip = scanner.nextLine();
        System.out.println("Enter Phone Number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter Email:");
        String email = scanner.nextLine();

        ContactPerson newContact = new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber, email);
        addressBook.addContact();
        addressBook.showContacts();

        System.out.println("Enter the name of the contact to edit:");
        String nameToEdit = scanner.nextLine();
        addressBook.editContact(nameToEdit, scanner);
        addressBook.showContacts();

        System.out.println("Enter the name of the contact to delete: ");
        String nameToDelete = scanner.nextLine();
        addressBook.deleteContact(nameToDelete);
    }

}