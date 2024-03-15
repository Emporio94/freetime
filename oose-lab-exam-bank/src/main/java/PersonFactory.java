public class PersonFactory {

    public static Person createPerson(String[] csvRow) {
        // Parse the basic information from the CSV row
        Role role = Role.valueOf(csvRow[0].toUpperCase());
        String firstName = csvRow[1];
        String lastName = csvRow[2];

        Person person = new Person(role, firstName, lastName);
        
        return person;
    }
}
