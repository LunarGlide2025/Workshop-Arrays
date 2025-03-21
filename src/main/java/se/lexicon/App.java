package se.lexicon;


import java.util.Arrays;

public class App {
    public static void main(String[] args) {


        int size = NameRepository.getSize();
        System.out.println("\nSize of the array from start: " + size);


        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        System.out.println("Get the size after setting the names: " + NameRepository.getSize());


        System.out.println("\nAll names: " + Arrays.toString(NameRepository.findAll()));


        boolean addTest = NameRepository.add("Test Testsson");
        System.out.println("Add Test Testsson: " + addTest);

        boolean addLina = NameRepository.add("Lina Linsson");
        System.out.println("Add Lina Linsson: " + addLina);

        boolean addSimon = NameRepository.add("Simon Simonsson");
        System.out.println("Add Simon Simonsson: " + addSimon);


        boolean addKalle = NameRepository.add("Kalle Kallesson");
        System.out.println("Add Kalle Kallesson: " + addKalle + "\n");


        boolean addErikAgain = NameRepository.add("Erik Svensson");
        System.out.println("*Try to add Erik Svensson: " + addErikAgain + "*\n");


        System.out.println("All names: " + Arrays.toString(NameRepository.findAll()) + "\n");


        String[] foundByFirst = NameRepository.findByFirstName("Erik");
        System.out.println("Find the person Erik with firstname: " + Arrays.toString(foundByFirst) + "\n");


        String[] foundByLast = NameRepository.findByLastName("Javan");
        System.out.println("Find the person with lastname Javan: " + Arrays.toString(foundByLast) + "\n");


        boolean updateResult = NameRepository.update("Test Testsson", "Test Updated");
        System.out.println("Test Testsson is now called: Test Updated. Result: " + updateResult + "\n");


        boolean removeResult = NameRepository.remove("Lina Linsson");
        System.out.println("Remove the person Lina Linsson. Result: " + removeResult + "\n");


        System.out.println("Final names: " + Arrays.toString(NameRepository.findAll()) + "\n");

        // Clears all the names = DANGER ZONE
        NameRepository.clear();
        System.out.println("Size of the array after doing a clear: " + NameRepository.getSize());

    }
}
