import java.util.ArrayList;
import java.util.List;

public class Person implements TradingComposite {

    protected String firstName;
    protected String lastName;
    protected Role role;
    protected static boolean printOn = true;
    protected List<Trader> warningPeople = new ArrayList<Trader>();
    protected List<TraderAssetDesk> warningDesks = new ArrayList<TraderAssetDesk>();
    private double balance; 

    public Person(Role role, String firstName, String lastName){
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setPrintOn(boolean status){
        printOn = status;
    }

    public Role getRole(){
        return role;
    }

    public String getName(){
        return firstName + " " + lastName;
    }

    protected void print(String message){
        System.out.println(message);
    }

    @Override
    public void printDetails() {
        System.out.println("Name: " + this.firstName + " " + this.lastName + ", Role: " + this.role.toString());
    }

    @Override
    public void add(TradingComposite member) {
        throw new UnsupportedOperationException("Cannot add to a person.");
    }

    @Override
    public void checkBalances(TraderAssetDesk desk) {
        if (this.balance < desk.wia) {
            System.out.println(this.firstName + " " + this.lastName + " is below the warning limit.");
        } else if (this.balance > desk.wia) {
            System.out.println(this.firstName + " " + this.lastName + " is above the warning limit.");
        }
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
}
