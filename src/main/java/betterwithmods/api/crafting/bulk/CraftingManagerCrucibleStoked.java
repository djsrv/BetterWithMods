package betterwithmods.api.crafting.bulk;

public class CraftingManagerCrucibleStoked extends CraftingManagerBulk {
    private static final CraftingManagerCrucibleStoked instance = new CraftingManagerCrucibleStoked();

    public CraftingManagerCrucibleStoked() {
        super("crucibleStoked");
    }

    public static CraftingManagerCrucibleStoked getInstance() {
        return instance;
    }
}
