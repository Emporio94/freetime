import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonTest {

    Person person = new Person(Role.TEAM_LEAD, "Derek", "Somerville");
    @Test
    void testGetName() {
        assertEquals("Derek Somerville", person.getName());
    }

    @Test
    void testGetRole() {
        assertEquals(Role.TEAM_LEAD, person.getRole());
    }

    @Test
    void testSetPrintOn() {
        person.setPrintOn(false);
        assertFalse(Person.printOn);
    }
}
