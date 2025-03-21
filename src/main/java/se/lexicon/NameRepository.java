package se.lexicon;

import java.util.Arrays;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0];


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {

        return names.length;
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param names The array of names to set.
     */
    public static void setNames(String[] names) {

        NameRepository.names = names;
    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {

        NameRepository.names = new String[0];
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {

        String[] newCopiedArray = Arrays.copyOf(names, names.length);
        return newCopiedArray;
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(String fullName) {

        for (int index = 0; index < names.length; index++) {
            if (names[index].equalsIgnoreCase(fullName)) {
                return names[index];
            }
        }
        return null;
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(String fullName) {

        if (fullName == null || fullName.isEmpty()) {
            return false;
        }
        for (int index = 0; index < names.length; index++) {
            if (names[index].equalsIgnoreCase(fullName)) {
                return false;
            }
        }
        String[] newArray = Arrays.copyOf(names, names.length + 1);
        newArray[newArray.length - 1] = fullName;
        names = newArray;

        return true;
    }


    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(String firstName) {

        if (firstName == null || firstName.isEmpty()) {
            return new String[0];
        }

        String[] namesMatched = new String[0];

        for (int index = 0; index < names.length; index++) {
            String currentName = names[index];

            int nameDelimiter = currentName.indexOf(" ");
            if (nameDelimiter != -1) {
                String firstNameExtracted = currentName.substring(0, nameDelimiter);

                if (firstNameExtracted.equalsIgnoreCase(firstName)) {
                    namesMatched = Arrays.copyOf(namesMatched, namesMatched.length + 1);
                    namesMatched[namesMatched.length - 1] = currentName;
                }
            }
        }
        return namesMatched;
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(String lastName) {

        if (lastName == null || lastName.isEmpty()) {
            return new String[0];
        }

        String[] namesMatched = new String[0];

        for (int index = 0; index < names.length; index++) {
            String currentName = names[index];

            int nameDelimiter = currentName.indexOf(" ");
            if (nameDelimiter != -1) {
                String lastNameExtracted = currentName.substring(nameDelimiter + 1); // Extract last name

                if (lastNameExtracted.equalsIgnoreCase(lastName)) {
                    namesMatched = Arrays.copyOf(namesMatched, namesMatched.length + 1);
                    namesMatched[namesMatched.length - 1] = currentName;
                }
            }
        }
        return namesMatched;
    }


    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(String original, String updatedName) {

        if (original == null || updatedName == null || original.isEmpty() || updatedName.isEmpty()) {
            return false;
        }

        for (int index = 0; index < names.length; index++) {
            if (names[index].equalsIgnoreCase(updatedName)) {
                return false;
            }
        }

        for (int index = 0; index < names.length; index++) {
            if (names[index].equalsIgnoreCase(original)) {
                names[index] = updatedName;
                return true;
            }
        }
        return false;
    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(String fullName) {

        if (fullName == null || fullName.isEmpty()) {
            return false;
        }
        int removeIndex = -1;
        for (int index = 0; index < names.length; index++) {
            if (names[index].equalsIgnoreCase(fullName)) {
                removeIndex = index;
                break;
            }
        }
        if (removeIndex == -1) {
            return false;
        }
        for (int index = removeIndex; index < names.length - 1; index++) {
            names[index] = names[index + 1];
        }
        names = Arrays.copyOf(names, names.length - 1);
        return true;
    }

}