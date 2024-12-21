
import java.io.*;
import java.util.List;

    public class FileOperations {

         final String fileName = "AddressBook.txt";

        // Method to write contacts to file
        public void writeToFile(List<ContactPerson> contacts) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (ContactPerson contact : contacts) {
                    writer.write(contact.toString());
                    writer.newLine();
                }
                System.out.println("Contacts have been written to the file successfully.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file: " + e.getMessage());
            }
        }

        // Method to read contacts from file
        public  void readFromFile() {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                System.out.println("Contacts in the file:");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading from the file: " + e.getMessage());
            }
        }
    }

