package se.lexicon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 tests for the NameRepository class.
 */

public class NameRepositoryTest {

    @BeforeEach
    void setUp() {
        // Clear and reset before each test
        NameRepository.clear();
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Simon Simonsson", "Kalle Kallesson"});
    }

    @Test
    void testGetSize() {
        // Arrange
        int expectedSize = 4;

        // Act
        int actualSize = NameRepository.getSize();

        // Assert
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void testFindAll() {
        // Arrange
        String[] expected = {"Erik Svensson", "Mehrdad Javan", "Simon Simonsson", "Kalle Kallesson"};

        // Act
        String[] actual = NameRepository.findAll();

        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
    void testAddNewName() {
        // Arrange
        String newName = "Lina Larsson";

        // Act
        boolean result = NameRepository.add(newName);
        String[] allNames = NameRepository.findAll();

        // Assert
        assertTrue(result);
        assertTrue(Arrays.asList(allNames).contains(newName));
    }

    @Test
    void testAddNameThatAlreadyExists() {
        // Arrange
        String existingName = "Erik Svensson";

        // Act
        boolean result = NameRepository.add(existingName);
        String[] allNames = NameRepository.findAll();

        // Assert
        assertFalse(result);
        assertTrue(Arrays.asList(allNames).contains(existingName));
    }

    @Test
    void testUpdateName() {
        // Arrange
        String oldName = "Simon Simonsson";
        String newName = "Simon Updatesson";

        // Act
        boolean result = NameRepository.update(oldName, newName);

        // Assert
        assertTrue(result);
        assertEquals(newName, NameRepository.find(newName));
        assertNull(NameRepository.find(oldName));
    }

    @Test
    void findName() {
        // Arrange
        String findName = "Kalle Kallesson";

        // Act
        String result = NameRepository.find(findName);

        // Assert
        assertEquals("Kalle Kallesson", result);
    }

    @Test
    void findPersonByFirstName() {
        // Arrange
        String firstName = "Kalle";

        // Act
        String[] result = NameRepository.findByFirstName(firstName);

        // Assert
        assertEquals(1, result.length);
        assertEquals("Kalle Kallesson", result[0]);
    }

    @Test
    void findPersonByLastName() {
        // Arrange
        String lastName = "Javan";

        // Act
        String[] result = NameRepository.findByLastName(lastName);

        // Assert
        assertEquals(1, result.length);
        assertEquals("Mehrdad Javan", result[0]);
    }

    @Test
    void testRemovePerson() {
        // Arrange
        String removeName = "Kalle Kallesson";

        // Act
        boolean result = NameRepository.remove(removeName);

        // Assert
        assertTrue(result);
        assertNull(NameRepository.find(removeName));
    }

}
