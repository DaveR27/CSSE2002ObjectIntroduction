public class Critter extends Thing implements Lootable, Mob {

    private int health;
    private double value;
    private int maxHealth;

    /*
    Constructor to make a critter object, these objects will be used as
    characters to fight Explorer objects.

    @param String shortDesc: Inherited from Thing.
    @param String longDesc: Inherited from Thing.
    @param double value: Sets how much the critter is worth when its defeated by an explorer.
    @param int health: Sets the starting health/max health of the critter, if the critter is
                        set with a negative number the health of the critter is set to 0.
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

    /*
    Checks to see if mob is alive if it is returns the long description if isAlive() returns
    false the description is returned with "(fainted)" at the end of the description.
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

    /*
    @param d: d is the amount of damage to take off the critters health
     */
    public void takeDamage(int d){
        this.health -= d;
    }

    /*
    @return 2: Returns the amount of damage the critter can do
     */
    public int getDamage(){
        return 2;
    }

    /*
    This method checks to see if there is an Explorer object and if the
    critter isAlive() is true.

    @param Thing looter: Takes in a Thing object
    @return Boolean
     */
    public boolean canLoot(Thing looter){
        return looter instanceof Explorer && isAlive();
    }

    /*
    This method takes in any object that implements mob and will
    cause it to fight this critter.

    @param Mob mob: Takes a mob object to fight against
     */
    public void fight(Mob mob){
        while (mob.isAlive() && this.isAlive()){
            mob.takeDamage(this.getDamage());
            if (mob.isAlive()) {
                this.takeDamage(mob.getDamage());
            }
        }
    }

    /*
    Checks to see if the mob is an instanceof Explorer if so it returns
    true meaning it wants to fight.

    @param Mob mob: Takes in an object that implements Mob.
    @return Boolean
     */
    public boolean wantsToFight(Mob mob){
        return mob instanceof Explorer;
    }

    /*
    Gets the set value of the critter.

    @return double this.value: Returns a double which is the amount that the critter is worth
     */
    public double getValue(){
        return this.value;
    }

    /*
    Checks to see if the critters health is above 0

    @return Boolean
     */
    public boolean isAlive(){
        if(this.health>0){
            return true;
        }
        else{
            return false;
        }
    }

    /*
    If b is true it will set the critters health to its starting health

    @param Boolean b
     */
    public void setAlive(boolean b){
        if(b == true){
            this.health = this.maxHealth;
        }
        if(b == false && isAlive()){
            this.health = 0;
        }
    }

    /*
    Gets the value of the the critters current health

    @return int this.health
     */
    public int getHealth(){
        return this.health;
    }

}
