public class Trader{
    
    private AssetType assetType;
    private String[] trades;
    protected int balance = 0;
    private int tradeCounter = 0;   
    private Person person; 

    public Trader(Person person, AssetType assetType, int balance, String[] trades){
        this.person = person;
        this.assetType = assetType;
        this.trades = trades;
        this.balance = balance;
    }

    public String getName(){
        return person.getName();
    }

    public AssetType getAssetType(){
        return assetType;
    }

    public Role getRole(){
        return person.getRole();
    }

    public void trade(){
        balance += Integer.parseInt(trades[tradeCounter]);
        tradeCounter ++;
    }

}