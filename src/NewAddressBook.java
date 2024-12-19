import java.util.HashMap;
import java.util.Map;

public class NewAddressBook extends AddressBook {

    static Map<String, NewAddressBook> addressBookDictionary = new HashMap<>();

    public NewAddressBook() {

    }

    public void addressBook() {

        System.out.println("Enter unique name for Address Book: ");
        String addressBookName = scanner.nextLine();

        if (addressBookDictionary.containsKey(addressBookName)) {
            System.out.println("This Address Book Already Exits.");
        } else {
            NewAddressBook newAddressBook = new NewAddressBook();
            addressBookDictionary.put(addressBookName, newAddressBook);
            System.out.println(addressBookName + " is Added Successfully");
        }
    }

    public void DisplayAddressBooks() {
        if (addressBookDictionary.isEmpty()) {
            System.out.println("No address book found");
        } else {
            System.out.println("List of Address book.");
            for (String names : addressBookDictionary.keySet()) {
                System.out.println("- " + names);
            }
        }
    }

    public void addPersonToAddressBook() {
        System.out.println("Enter the name of the Address Book:");
        String addressBookName = scanner.nextLine();


        AddressBook addressBook = addressBookDictionary.get(addressBookName);
        if (addressBook == null) {
            System.out.println("No Address Book found with the name '" + addressBookName + "'.");
            return;
        }

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

          boolean  isAdded = addressBook.addContactToAddressBook(newContact);
        if (isAdded) {
            System.out.println("Person added successfully to the Address Book '" + addressBookName + "'.");
        } else {
            System.out.println("Duplicate entry! A person with the same name already exists in the Address Book.");
        }

    }
}