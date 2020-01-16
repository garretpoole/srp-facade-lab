package srpfacadelab;

public class PlayerFacade {
    RpgPlayer player;
    public InventoryManager im = new InventoryManager(player);
    public HealthManager hm = new HealthManager(player);
    public RpgPlayerFacade() {}

    public void takeDamage(int Damage) {
        hm.takeDamage(Damage, im);
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