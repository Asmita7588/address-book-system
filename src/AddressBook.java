import java.util.*;

class AddressBook {


    private final HashSet<Object> addContacts;

    public AddressBook() {
        this.addContacts = new HashSet<>();
    }
    List<ContactPerson> Mulcontact = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    private ContactPerson[] contacts = new ContactPerson[100];
    private int contactCount = 0;

    public boolean addContactToAddressBook(ContactPerson contact) {

        if (addContacts.stream().anyMatch(existingContact -> existingContact.equals(contact))) {
            return false;
        }
        addContacts.add(contact);
        return true;
    }
    public void addContact() {
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
        Mulcontact.add(newContact);
        System.out.println("Contact added successfully!");
    }



    public void editContact(String name, Scanner scanner) {
        for (int i = 0; i < contactCount; i++) {
            if (contacts[i].getFirstName().equalsIgnoreCase(name)) {
                System.out.println("Enter new address:");
                contacts[i].setAddress(scanner.nextLine());
                System.out.println("Enter new city:");
                contacts[i].setCity(scanner.nextLine());
                System.out.println("Enter new state:");
                contacts[i].setState(scanner.nextLine());
                System.out.println("Enter new zip:");
                contacts[i].setZip(scanner.nextLine());
                System.out.println("Enter new phone number:");
                contacts[i].setPhoneNumber(scanner.nextLine());
                System.out.println("Enter new email:");
                contacts[i].setEmail(scanner.nextLine());
                return;
            }
        }
        System.out.println("Contact not found!");
    }

    public void deleteContact(String name) {
        for (int i = 0; i < contactCount; i++) {
            if (contacts[i].getFirstName().equalsIgnoreCase(name)) {
                for (int j = i; j < contactCount - 1; j++) {
                    contacts[j] = contacts[j + 1]; // Shift contacts left
                }
                contacts[contactCount - 1] = null; // Clear the last contact
                contactCount--;
                System.out.println("Contact deleted successfully!");
                return;
            }
        }
        System.out.println("Contact not found!");
    }


    public void showContacts() {
        for (int i = 0; i < contactCount; i++) {
            System.out.println(contacts[i]);
        }
    }

    public void viewAllContacts() {
        if (Mulcontact.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("Contacts in this Address Book:");
            for (ContactPerson contact : Mulcontact) {
                System.out.println(contact);
            }
        }
    }
}