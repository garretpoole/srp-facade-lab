package srpfacadelab;

public class RpgPlayerFacade {
    RpgPlayer player;
    public InventoryManager im = new InventoryManager(player);
    public DamageCalculator dc = new DamageCalculator(player);
    public RpgPlayerFacade() {}

    public void takeDamage(int Damage) {
        dc.takeDamage(Damage, im);
    }

    public int calculateInventoryWeight() {
        return im.calculateInventoryWeight();
    }

    public boolean checkIfItemExistsInInventory(Item item) {
        return im.checkIfItemExistsInInventory(item);
    }
    
    public void useItem(Item item) {
        im.useItem(item);
    }

    public boolean pickUpItem(Item item) {
        return im.pickUpItem(item);
    }
}