import java.io.File;
import java.io.IOException;
import java.util.*;


public class AddressBookMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To Address Book");
        AddressBook addressBook = new AddressBook();
        NewAddressBook newAddressBook = new NewAddressBook();
        FileOperations fileOperations = new FileOperations();
        List<ContactPerson> mulContact = new ArrayList<>();
        ContactPerson contact1 = new ContactPerson("Asmita", "gir", "ngp", "nagpur", "mh", "62701", "555-1234", "johndoe@example.com");
        ContactPerson contact2 =new ContactPerson("simaran", "lanje", "pune", "pune", "up", "62701", "555-5678", "janesmith@example.com");
        mulContact.add(contact1);
        mulContact.add(contact2);
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
            System.out.println("10. sort contact by persons city , state, Zip");
            System.out.println("11. Ability to write and from Address book Contacts.");
            System.out.println("12. Ability to read and from Address book Contacts.");
            System.out.println("13. Exit");


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
                    boolean repeatOperation = true;
                    while (repeatOperation) {
                        System.out.println("Enter Choice \n1.sort by city \n 2.sort by state \n 3.sort by Zip \n4.Exit");
                        int choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                newAddressBook.sortByCity();
                                break;
                            case 2:
                                newAddressBook.sortByState();
                                break;
                            case 3:
                                newAddressBook.sortByZip();
                                break;
                            case 4:
                                repeatOperation = false;
                            default:
                                System.out.println("Invalid choice");
                        }
                    }
                case 11:
                    fileOperations.writeToFile(mulContact);
                    break;
                case 12:
                    fileOperations.readFromFile();
                    break;
                case 13:
                    repeat = false;
                   break;
                default:
                    System.out.println("Invalid Option! ");

            }


        }
            final String fileName = "AddressBook.txt";
            File file = new File(fileName);

            try {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file");
                e.printStackTrace();

            }


        }
    }
