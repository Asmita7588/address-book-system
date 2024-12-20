import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;


public class AddressBookMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To Address Book");

        AddressBook addressBook = new AddressBook();
        NewAddressBook newAddressBook = new NewAddressBook();
        System.out.println("_______________________________________________________________");
        boolean repeat = true;
        while (repeat) {
            System.out.println("Enter Option which you want to perform: \n");
            System.out.println("1. Add New contact");
            System.out.println("2. Display Contacts");
            System.out.println("3.Add new AddressBook");
            System.out.println("4. Display AddressBook");
            System.out.println("5. Add person to Address Book");
            System.out.println("6. search Persons By City Or State");
            System.out.println("7. view person by city or state");
            System.out.println("8. count person by city or state");
            System.out.println("9. sort contact by persons name");

            System.out.println("10. Exit");


            int option = scanner.nextInt();

            switch (option) {

                case 1:
                    addressBook.addContact();
                    break;
                case 2:
                    addressBook.viewAllContacts();
                    break;
                case 3:
                    newAddressBook.addressBook();
                    break;
                case 4:
                    newAddressBook.DisplayAddressBooks();
                    System.out.println();
                    break;
                case 5:
                    newAddressBook.addressBook();
                    newAddressBook.addPersonToAddressBook();
                    break;
                case 6:
                    newAddressBook.addressBook();
                    newAddressBook.addPersonToAddressBook();
                    newAddressBook.searchPersonsByCityOrState();
                    break;
                case 7:
                    newAddressBook.addressBook();
                    newAddressBook.addPersonToAddressBook();
                   newAddressBook.viewPersonsByCityOrState();
                    break;
                case 8:
                    newAddressBook.addressBook();
                    newAddressBook.addPersonToAddressBook();
                    newAddressBook.viewPersonsByCityOrState();
                    newAddressBook.countByCityOrState();
                    break;
                case 9:
                    newAddressBook.addressBook();
                    newAddressBook.addPersonToAddressBook();
                    newAddressBook.sortContactsByName();
                    break;
                case 10:
                    repeat = false;
                   break;

                default:
                    System.out.println("Invalid Option! ");

            }


        }

    }
}