public class Critter extends Thing implements Lootable, Mob {

    private int health;
    private double value;
    private int maxHealth;

    /**
     * Constructor to make a critter object, these objects will be used as
     *characters to fight Explorer objects.
     *
     * @param shortDesc Inherited from Thing.
     * @param longDesc Inherited from Thing.
     * @param value Sets how much the critter is worth when its defeated
     *              by an explorer.
     * @param health Sets the starting health/max health of the critter, if the
     *               critter is set with a negative number the health of the
     *               critter is set to 0.
     */
    Critter(String shortDesc, String longDesc, double value, int health){
        super(shortDesc,longDesc);

        if (health < 0){
            this.health = 0;
        }
        else{
            this.health = health;
        }

        this.value = value;
        this.maxHealth = this.health;
    }

    /**
     * Checks to see if mob is alive if it is returns the long description if
     * isAlive() return false the description is returned with "(fainted)" at
     * the end of the description.
     *
     * @return An edited version of the longDesc.
     */
    @Override
    public String getDescription(){
        if(isAlive() == false){
            return this.longDesc + "(fainted)";
        }
        else {
            return this.longDesc;
        }
    }

    /**
     * Takes health off the Critters current health.
     *
     * @param d The amount of damage to take off the critters health.
     */
    public void takeDamage(int d){
        this.health -= d;
    }

    /**
     * Returns the amount of damage the Critter does.
     *
     * @return Critters damage.
     */
    public int getDamage(){
        return 2;
    }

    /**
     * This method checks to see if there is an Explorer object and if the
     * critter isAlive() is true.
     *
     * @param looter The Thing tested to see if it is an Explorer and if the
     *               Critter is still alive.
     * @return boolean true if Explorer and health<=0, otherwise false
     */
    public boolean canLoot(Thing looter){
        return looter instanceof Explorer && isAlive() == false;
    }

    /**
     * This method takes in any object that implements mob and will cause
     * it to fight this critter.
     *
     * @param mob A Mob object to fight against
     */
    public void fight(Mob mob){
        while (mob.isAlive() && this.isAlive()){
            mob.takeDamage(this.getDamage());
            if (mob.isAlive()) {
                this.takeDamage(mob.getDamage());
            }
        }
    }

    /**
     * Checks to see if the mob is an instanceof Explorer if so it returns
     * true meaning it wants to fight.
     *
     * @param mob Object that implements Mob.
     * @return True if Explorer, False otherwise.
     */
    public boolean wantsToFight(Mob mob){
        return mob instanceof Explorer;
    }

    /**
     * Gets the set value of the critter.
     *
     * @return The amount that the critter is worth
     */
    public double getValue(){
        return this.value;
    }

    /**
     * Checks to see if the critters health is above 0.
     *
     * @return True is current health>0, false otherwise.
     */
    public boolean isAlive(){
        return this.health > 0;
    }

    /**
     * Checks to see if b==true the Critters health is set back to its max
     * health, if b==false and the Critter isAlive==true the Critter's health
     * is set to 0.
     *
     * @param b If b is true it will set the critters health to its starting
     *          health.
     * @require If b==false isAlive() must  == true.
     */
    public void setAlive(boolean b){
        if(b == true){
            this.health = this.maxHealth;
        }
        if(b == false && isAlive()){
            this.health = 0;
        }
    }

    /**
     * Gets the value of the the critters current health
     *
     * @return Current health of Critter
     */
    public int getHealth(){
        return this.health;
    }

}
