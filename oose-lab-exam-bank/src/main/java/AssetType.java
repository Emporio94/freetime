public enum AssetType{
    EQUITY,
    RATE,
    COMMODITIES,
    ALGORITHMIC;

    public static AssetType getFromName(String name){
        AssetType assetType = null;
        try {
            assetType = AssetType.valueOf(name);
        } catch (IllegalArgumentException e) {

        }
        return assetType;
    }
}
