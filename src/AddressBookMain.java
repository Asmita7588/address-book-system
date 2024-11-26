
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

        System.out.println("Welcome To Address Book");
        AddressBook addressBook = new AddressBook();
        addressBook.showContacts();
    }
}