package betterwithmods.api.crafting.bulk;

public class CraftingManagerCauldron extends CraftingManagerBulk {
    private static final CraftingManagerCauldron instance = new CraftingManagerCauldron();

    public CraftingManagerCauldron() {
        super("cauldron");
    }

    public static CraftingManagerCauldron getInstance() {
        return instance;
    }
}
