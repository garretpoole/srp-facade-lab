package srpfacadelab;

import java.util.List;

public class InventoryManager {

    public RpgPlayer player;

    public InventoryManager(RpgPlayer player) {
        this.player = player;
    }

    public int calculateInventoryWeight() {
        int sum=0;
        for (Item i: player.inventory) {
            sum += i.getWeight();
        }
        return sum;
    }

    public boolean checkIfItemExistsInInventory(Item item) {
        for (Item i: player.inventory) {
            if (i.getId() == item.getId())
                return true;
        }
        return false;
    }

    public void useItem(Item item) {
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = player.gameEngine.getEnemiesNear(player);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }

    public boolean pickUpItem(Item item) {
        int weight = calculateInventoryWeight();
        if (weight + item.getWeight() > player.getCarryingCapacity())
            return false;

        if (item.isUnique() && checkIfItemExistsInInventory(item))
            return false;

        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            player.setHealth(player.getHealth() + item.getHeal());

            if (player.getHealth() > player.getMaxHealth())
                player.setHealth(player.getMaxHealth());

            if (item.getHeal() > 500) {
                player.gameEngine.playSpecialEffect("green_swirly");
            }

            return true;
        }
        if(item.isRare() && item.isUnique()) {
            player.gameEngine.playSpecialEffect("blue_swirly");
        }

        if (item.isRare())
            player.gameEngine.playSpecialEffect("cool_swirly_particles");

        player.inventory.add(item);

        player.calculateStats();

        return true;
    }

}