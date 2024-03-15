import java.util.HashMap;
import java.util.List;

public class Bank {

    LoadCSV loadCSV = new LoadCSV();
    HashMap<AssetType, TraderAssetDesk> desks = new HashMap<>();

    public Bank() {
        setUpTraderAssetDesk();
        setUpPeople();
    }

    // Initiates trades across all TraderAssetDesks
    public void allTrades() {
        for (TraderAssetDesk desk : desks.values()) {
            desk.trade(); // Assuming trade method is correctly implemented in TraderAssetDesk
        }
    }

    // Set up TraderAssetDesks for each AssetType
    private void setUpTraderAssetDesk() {
        for (AssetType assetType : AssetType.values()) {
            desks.put(assetType, new TraderAssetDesk(assetType));
        }
    }

    // Adds people to their respective TraderAssetDesks based on CSV data
    protected void setUpPeople() {
        List<String[]> csvPeople = loadCSV.getCSVRows("src/main/resource/people.csv");
        for (String[] row : csvPeople) {
            Person person = PersonFactory.createPerson(row);
            
            // Set the balance using the newly added setter method in the Person class
            double balance = Double.parseDouble(row[4]); // Assuming balance is at index 4
            person.setBalance(balance);
    
            // Now add the person to their respective TraderAssetDesk
            TraderAssetDesk desk = getTraderAssetDesk(AssetType.valueOf(row[3]));
            if (desk != null) {
                desk.addTrader(person);
            }
        }
    }
    
    

    // Retrieves the TraderAssetDesk for a given AssetType
    public TraderAssetDesk getTraderAssetDesk(AssetType assetType) {
        return desks.get(assetType);
    }
    
    // Main method to set up and run trades
    public static void main(String[] args) {
        Bank bank = new Bank();
        //bank.allTrades();

        // Demonstrate the structure and trades
        //TraderAssetDesk algorithmicDesk = bank.getTraderAssetDesk(AssetType.ALGORITHMIC);
        //algorithmicDesk.printAllTraderDetails(); // This now includes team leads and their groups
    }
}
