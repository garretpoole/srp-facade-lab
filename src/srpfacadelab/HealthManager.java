package srpfacadelab;

public class HealthManager {
    RpgPlayer player;

    HealthManager(RpgPlayer player) {
        this.player = player;
    }

    public void takeDamage(int damage, InventoryManager im) {
        if (damage < player.getArmour()) {
            player.gameEngine.playSpecialEffect("parry");
        }

        int damageToDeal = damage - player.getArmour();
        if(im.calculateInventoryWeight() < player.getCarryingCapacity()/2) {
            damageToDeal = damageToDeal * 3/4;
        }
        player.setHealth(player.getHealth() - damageToDeal);

        player.gameEngine.playSpecialEffect("lots_of_gore");
    }

}