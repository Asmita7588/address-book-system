import java.util.*;
import java.util.stream.Collectors;

public class NewAddressBook extends AddressBook {

    static Map<String, NewAddressBook> addressBookDictionary = new HashMap<>();
    static Map<String, List<ContactPerson>> cityToPersonMap = new HashMap<>();
    static Map<String, List<ContactPerson>> stateToPersonMap = new HashMap<>();

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

          boolean  isAdded = mulcontact.add(newContact);
        if (isAdded) {

            System.out.println("Person added successfully to the Address Book '" + addressBookName + "'.");
        } else {
            System.out.println("Duplicate entry! A person with the same name already exists in the Address Book.");
        }

    }


    public void searchPersonsByCityOrState() {
        System.out.println("Enter 1 to search by City or 2 to search by State:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the name of the City/State:");
        String location = scanner.nextLine();

        List<ContactPerson> result = mulcontact.stream()
                .filter(contact -> (choice == 1 && contact.getCity().equalsIgnoreCase(location)) ||
                        (choice == 2 && contact.getState().equalsIgnoreCase(location)))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No contacts found for the given location.");
        } else {
            System.out.println("Contacts found:");
            result.forEach(System.out::println);
        }
    }


    public void viewPersonsByCityOrState() {

        System.out.println("Enter 1 to view by City or 2 to view by State:");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        if (choice != 1 && choice != 2) {
            System.out.println("Invalid choice! Please choose either 1 or 2.");
            return;
        }

        System.out.println(choice == 1 ? "Enter the city:" : "Enter the state:");
        String location = scanner.nextLine();

        //for city
        List<ContactPerson> resultForCity = mulcontact.stream()
                .filter(contact -> (contact.getCity().equalsIgnoreCase(location)))
                .collect(Collectors.toList());
        cityToPersonMap.put("List of person in city", resultForCity);

        //for state
        List<ContactPerson> resultForState = mulcontact.stream()
                .filter(contact -> ( contact.getState().equalsIgnoreCase(location)))
                .collect(Collectors.toList());
        stateToPersonMap.put("List of person in state", resultForState);

        Map<String, List<ContactPerson>> mapToUse = (choice == 1) ? cityToPersonMap : stateToPersonMap;
       // List<ContactPerson> persons = mapToUse.getOrDefault(location, Collections.emptyList());

        if ( mapToUse == cityToPersonMap && resultForCity.isEmpty() || mapToUse == stateToPersonMap && resultForState.isEmpty()) {
            System.out.println("No persons found " + (choice == 1 ? "city" : "state") + ".");
        } else {
            System.out.println("Persons found in " + location + ":");
            resultForCity.forEach(System.out::println );
        }
    }


    public void countByCityOrState() {
        System.out.println("Enter 1 to count by City or 2 to count by State:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice != 1 && choice != 2) {
            System.out.println("Invalid choice! Please choose either 1 or 2.");
            return;
        }

        System.out.println(choice == 1 ? "Enter the city:" : "Enter the state:");
        String location = scanner.nextLine();



        List<ContactPerson> resultForCity = mulcontact.stream()
                .filter(contact -> (contact.getCity().equalsIgnoreCase(location)))
                .collect(Collectors.toList());
        cityToPersonMap.put("List of person in city", resultForCity);

        //for state
        List<ContactPerson> resultForState = mulcontact.stream()
                .filter(contact -> (contact.getState().equalsIgnoreCase(location)))
                .collect(Collectors.toList());
        stateToPersonMap.put("List of person in state", resultForState);

         List<ContactPerson> mapToUse = (choice == 1) ? resultForCity : resultForState;

        if (mapToUse == resultForCity) {
            long countCity = resultForCity.stream().count();
            System.out.println("Number of persons in " + location + ": " + countCity);
        } else {
            long countState = resultForState.stream().count();
            System.out.println("Number of persons in " + location + ": " + countState);
        }
    }

    public void sortContactsByName() {
        if (mulcontact.isEmpty()) {
            System.out.println("No contacts available to sort!");
            return;
        }

        System.out.println("Sorting contacts alphabetically by name...");

        // Sorting using streams
        mulcontact.stream()
                .sorted(Comparator.comparing(contact -> contact.getFirstName().toLowerCase()))
                .forEach(System.out::println);
    }

    //Method to sort by City
    public void sortByCity() {
        List<ContactPerson> sortedByCity = mulcontact.stream()
                .sorted(Comparator.comparing(ContactPerson::getCity))
                .toList();
        System.out.println("Sorted by City:");
        sortedByCity.forEach(System.out::println);
    }

    //Method to sort by State
    public void sortByState() {
        List<ContactPerson> sortedByState = mulcontact.stream()
                .sorted(Comparator.comparing(ContactPerson::getState))
                .toList();
        System.out.println("Sorted by State:");
        sortedByState.forEach(System.out::println);
    }

    //Method to sort by zip
    public void sortByZip() {
        List<ContactPerson> sortedByZip = mulcontact.stream()
                .sorted(Comparator.comparing(ContactPerson::getZip))
                .toList();
        System.out.println("Sorted by Zip:");
        sortedByZip.forEach(System.out::println);
    }

    //Display all contacts
    public void displayContacts() {
        if (mulcontact.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            mulcontact.forEach(System.out::println);
        }
    }

}

