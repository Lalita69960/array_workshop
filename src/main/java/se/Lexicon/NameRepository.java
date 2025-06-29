package se.Lexicon;

import java.util.Arrays;
import java.util.Scanner;

public class NameRepository {

    // Initially storing some names in the array
    private static String[] names = {"Lalitha Shahi", "Pratima"};

    // Method to add a new name to the array
    public static void addName(String newName) {
        // Resize the array to make space for the new name
        names = Arrays.copyOf(names, names.length + 1);
        names[names.length - 1] = newName; // Add the new name to the last position
    }

    // Method to search for a name in the array
    public static boolean searchName(String searchTerm) {
        for (String name : names) {
            if (name.equalsIgnoreCase(searchTerm)) {
                return true; // Return true if the name is found
            }
        }
        return false; // Return false if the name is not found
    }

    // Method to update an existing name at a given index
    public static void updateName(int index, String newName) {
        if (index >= 0 && index < names.length) {
            names[index] = newName; // Update the name at the specified index
        } else {
            System.out.println("Index out of range!");
        }
    }

    // Method to remove a name from the array
    public static void removeName(String nameToRemove) {
        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(nameToRemove)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            // Remove the name by shifting all subsequent elements
            for (int i = index; i < names.length - 1; i++) {
                names[i] = names[i + 1];
            }
            names = Arrays.copyOf(names, names.length - 1); // Resize the array
        } else {
            System.out.println("Name not found!");
        }
    }

    // Method to display all names in the array
    public static void displayNames() {
        System.out.println("Current list of names:");
        for (String name : names) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Display the initial names
        System.out.println("Initial Names:");
        displayNames();

        // Loop to keep asking the user for actions
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a new name");
            System.out.println("2. Search for a name");
            System.out.println("3. Update a name");
            System.out.println("4. Remove a name");
            System.out.println("5. Display all names");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    System.out.println("Enter the new name (First Last):");
                    String newName = scanner.nextLine();
                    addName(newName); // Add the new name to the array
                    System.out.println("Name added successfully!");
                    break;

                case 2:
                    System.out.println("Enter the name to search:");
                    String searchTerm = scanner.nextLine();
                    boolean found = searchName(searchTerm);
                    if (found) {
                        System.out.println("Name found!");
                    } else {
                        System.out.println("Name not found.");
                    }
                    break;

                case 3:
                    System.out.println("Enter the index of the name you want to update:");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // Clear the buffer
                    System.out.println("Enter the new name (First Last):");
                    String updatedName = scanner.nextLine();
                    updateName(index, updatedName); // Update the name at the given index
                    System.out.println("Name updated successfully!");
                    break;

                case 4:
                    System.out.println("Enter the name to remove:");
                    String nameToRemove = scanner.nextLine();
                    removeName(nameToRemove); // Remove the name from the array
                    System.out.println("Name removed successfully!");
                    break;

                case 5:
                    displayNames(); // Display all names
                    break;

                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return; // Exit the program

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

    }
}
