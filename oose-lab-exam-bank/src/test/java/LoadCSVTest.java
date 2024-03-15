import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner; 

public class LoadCSVTest {

    LoadCSV loadCSV = new LoadCSV();

    @Test
    void testGetCSVReaderMockFirstRow(){
        Scanner mockScanner = mock(Scanner.class);
        loadCSV.setCSVReader(mockScanner, "test");
        when(mockScanner.hasNextLine()).thenReturn(true).thenReturn(true).thenReturn(false);
        when(mockScanner.nextLine()).thenReturn("Line,One").thenReturn("Line,Two");
        String[] result = {"Line" ,"One"};
        try{
            assertArrayEquals(result, loadCSV.getCSVRows("test").get(0));
        } catch (Exception e) {
        }
    }

    @Test
    void testGetCSVReaderMockSize(){
        Scanner mockScanner = mock(Scanner.class);
        loadCSV.setCSVReader(mockScanner, "test");
        when(mockScanner.hasNextLine()).thenReturn(true).thenReturn(true).thenReturn(false);
        when(mockScanner.nextLine()).thenReturn("Line,One").thenReturn("Line,Two");
        try{
            assertEquals(2, loadCSV.getCSVRows("test").size());
        } catch (Exception e) {
        }
    }

    @Test
    void testSetCSVReader() {
        Scanner scanner = new Scanner(System.in);
        loadCSV.setCSVReader(scanner, null);
        assertEquals(scanner, loadCSV.csvReader);
    }

    @Test
    void testSetCSVReaderConfig() {
        Scanner scanner = new Scanner(System.in);
        loadCSV.setCSVReader(scanner, "Test");
        assertEquals("Test", loadCSV.configPath);
    }
}
