import java.util.List;
import java.util.ArrayList;

public class TraderGroup implements TradingComposite{

    protected List<Person> traders = new ArrayList<>();
    protected String name;
    private List<TradingComposite> members = new ArrayList<>();


    public TraderGroup(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public void checkBalances(TraderAssetDesk desk) {
        for (TradingComposite member : members) {
            member.checkBalances(desk); // Recursively check balances for all members
        }
    }

    public void add(Person trader){
        // Adds a trader to this groups list of traders
        this.members.add(trader);
    }

    public void printTraderDetails(){
        System.out.println("Trader Group: " + name);
        for (Person trader : traders) {
            System.out.println("Name: " + trader.firstName + " " + trader.lastName + ", Role: " + trader.getRole().toString());
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Trader Group: " + name);
        for (TradingComposite member : members) {
            member.printDetails();
        }
    }
    

    @Override
    public void add(TradingComposite member) {
        this.members.add(member);
    }

    public List<TradingComposite> getMembers() {
        return members;
    }



}
