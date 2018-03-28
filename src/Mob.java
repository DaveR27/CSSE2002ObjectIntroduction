/**
 * Makes the interface that all Mobs within the game need.
 */
public interface Mob {

    /**
     * Method for a mob to fight another mob to the death
     *
     * @param mob the mob that the this mob will fight.
     */
    void fight(Mob mob);

    /**
     * Checks to see if that target mob wants to fight
     *
     * @param mob mob that could potentially fight this mob
     * @return True is the mobs are going to fight, false otherwise.
     */
    boolean wantsToFight(Mob mob);

    /**
     * Checks to see if the mob is alive by seeing if its health is above 0.
     *
     * @return True is the mob is alive, otherwise false.
     */
    boolean isAlive();

    /**
     * Will set the mob back to full health if b==true, if b==false && health>0
     * the mobs health is set to 0.
     *
     * @param b True for alive, false otherwise.
     */
    void setAlive(boolean b);

    /**
     * Gets the amount of damage the mob can do.
     *
     * @return damage that can be done.
     */
    int getDamage();

    /**
     * Reduces the mob's current health.
     *
     * @param d The amount of health that will be taken off the mobs current
     *          health.
     */
    void takeDamage(int d);
}
