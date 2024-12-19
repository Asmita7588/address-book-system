import java.util.HashMap;
import java.util.Map;

public class NewAddressBook extends AddressBook{

    Map<String, NewAddressBook> addressBookDictonory = new HashMap<>();
    public NewAddressBook(){

    }

    public void addressBook(){

        System.out.println("Enter unique name for Address Book: ");
        String addressBookName = scanner.nextLine();

        if(addressBookDictonory.containsKey(addressBookName)){
            System.out.println("This Address Book Already Exits.");
        }
        else {
           NewAddressBook newAddressBook = new NewAddressBook();
           addressBookDictonory.put(addressBookName, newAddressBook);
           System.out.println( addressBookName+ " is Added Successfully");
        }
    }

    public void DisplayAddessBooks(){
        if(addressBookDictonory.isEmpty()){
            System.out.println("No address book found");
        }
        else {
            System.out.println("List of Address book.");
            for (String names :addressBookDictonory.keySet()){
                System.out.println("- "+names);
            }
        }
    }

}
