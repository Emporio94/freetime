public interface TradingComposite {
    void add(TradingComposite member);
    void printDetails();
    void checkBalances(TraderAssetDesk desk);
}
