import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TraderTest {

    Person person = new Person(Role.TEAM_LEAD, "Derek", "Somerville");
    String[] trades = {"50","100","150"};
    Trader trader = new Trader(person, AssetType.RATE, 250, trades);
    
    @Test
    void testGetAssetType() {
        assertEquals(AssetType.RATE, trader.getAssetType());
    }

    @Test
    void testGetName() {
        assertEquals("Derek Somerville", trader.getName());
    }

    @Test
    void testGetRole() {
        assertEquals(Role.TEAM_LEAD, trader.getRole());
    }

    @Test
    void testBalance(){
        assertEquals(250, trader.balance);
    }

    @Test
    void testTrade() {
        trader.trade();
        assertEquals(300, trader.balance);
    }
}
