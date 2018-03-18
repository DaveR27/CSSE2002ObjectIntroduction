public interface Mob {

    /*
    @param mob: The target
     */
    void fight(Mob mob);

    boolean wantsToFight(Mob mob);

    boolean isAlive();

    void setAlive(boolean b);

    int getDamage();

    void takeDamage(int d);
}
