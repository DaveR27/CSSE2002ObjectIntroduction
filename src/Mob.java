public interface Mob {

    /*
    Method for a mob to fight another mob to the death

    @param Mob mob: The mob that will fight this current mob.
     */
    void fight(Mob mob);

    /*
    Checks to see if that target mob wants to fight

    @param Mob mob: mob that is going to fight this current mob.
    @return Boolean: True is the mobs are going to fight, false otherwise.
     */
    boolean wantsToFight(Mob mob);


    /*
    Checks to see if the mob is alive by seeing if its health is above 0.

    @return Boolean: True is the mob is alive, otherwise false.
     */
    boolean isAlive();

    /*
    Will set the mob back to full health if b==true, if b==false && health>0 the mobs
    health is set to 0.

    @param Boolean b
     */
    void setAlive(boolean b);

    /*
    Gets the amount of damage the mob can go.

    @returns int
     */
    int getDamage();

    /*
    Reduces the mob's current health.

    @param int d: The amount of health that will be taken off the mobs current health.
     */
    void takeDamage(int d);
}
