import java.util.ArrayList;
import java.util.List;

public class TraderAssetDesk {

    protected int wib = -30000;
    protected int wia = 30000;

    private TradingComposite rootGroup; // No longer need separate list for allTraderGroups
    private AssetType assetType;
    private TradingComposite currentTeamLeadGroup = null; // Tracks the latest team lead group
   

    public TraderAssetDesk(AssetType assetType){
        this.assetType = assetType;
        this.rootGroup = new TraderGroup(assetType.name() + "Main Group");
    }

    public void addTrader(Person trader) {
        if (trader.getRole() == Role.TEAM_LEAD) {
            // Create a new group for this team lead
            TradingComposite newGroup = new TraderGroup(trader.firstName + " " + trader.lastName + " Group");
            newGroup.add(trader); // Adding the team lead to their group
            this.rootGroup.add(newGroup); // Directly add new team lead group under rootGroup
            this.currentTeamLeadGroup = newGroup; // Update the current team lead group
        } else {
            // For regular traders, add them to the current team lead's group if exists, else to the root group
            TradingComposite targetGroup = currentTeamLeadGroup != null ? currentTeamLeadGroup : rootGroup;
            targetGroup.add(trader);
        }
    }
    
    
    

    public String getName(){
        return assetType.name();
    }

    public AssetType getAssetType(){
        return assetType;
    }




    
    public void printAllTraderDetails() {
        System.out.println("Asset Deck: " + this.getAssetType().name());
        this.rootGroup.printDetails(); // Recursively print details, starting from rootGroup
    }
    
    public void trade() {
        this.rootGroup.checkBalances(this); // Initiate balance check for the entire structure
    }

    public int getWib() {
        return this.wib;
    }

    public int getWia() {
        return this.wia;
    }

    
}
