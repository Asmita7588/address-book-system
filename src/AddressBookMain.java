import java.util.Scanner;

class ContactPerson {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public ContactPerson(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "ContactPerson {" +
                "firstName=" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

  class AddressBook {
     private ContactPerson[] contacts = new ContactPerson[100];
     private int contactCount = 0;

     public void addContact(ContactPerson contact) {
         if (contactCount < contacts.length) {
             contacts[contactCount] = contact;
             contactCount++;
         } else {
             System.out.println("Address Book is full!");
         }
     }

     public void showContacts() {
         for (int i = 0; i < contactCount; i++) {
             System.out.println(contacts[i]);
         }
     }
 }



public class AddressBookMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To Address Book");

        AddressBook addressBook = new AddressBook();

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

        addressBook.showContacts();
    }
}