public enum Role {
    TEAM_LEAD,
    TRADER;

    public static Role getFromName(String name){
        Role role = null;
        try {
            role = Role.valueOf(name);
        } catch (IllegalArgumentException e) {

        }
        return role;
    }
}
