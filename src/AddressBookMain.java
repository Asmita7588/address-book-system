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

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
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
        addressBook.addContact(newContact);
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