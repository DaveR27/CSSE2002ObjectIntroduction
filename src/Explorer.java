import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * Class with the information for the player who doesn't modify the map.
 */
public class Explorer extends Thing implements Mob {

    protected int health;
    private int maxHealth;
    protected List<Thing> inventory = new Vector<Thing>();

    /**
     * Constructor that takes in another explorer and then passed in explorer
     * has its health, shortDesc and longDesc copied to the current explorer.
     * @param p Takes in another Explorer object
     */
    Explorer(Explorer p){
        super(p.shortDesc, p.longDesc);
        this.health = p.health;
    }

    /**
     * Constructor that will set the shortDesc and the longDesc, but it
     * will set the starting health of the Explorer to 10.
     *
     * @param shortDesc Short name of the the Explorer.
     * @param longDesc Gives a long description of the Explorer.
     */
    Explorer(String shortDesc, String longDesc){
        super(shortDesc, longDesc);
        this.maxHealth = 10;
        this.health = this.maxHealth;

    }

    /**
     * Constructor that will set the shortDesc, longDesc and the starting/max
     * health of the Explorer.
     *
     * @param shortDesc Short name of the the Explorer.
     * @param longDesc Gives a long description of the Explorer.
     * @param health What the max and starting health of the Explorer is.
     */
    Explorer(String shortDesc, String longDesc, int health){
        super(shortDesc, longDesc);
        this.maxHealth = health;
        this.health = this.maxHealth;
    }

    /**
     * Gets the Explorers longDesc with some extra information is the Explorer
     * isAlive() if the Explorer is not alive then the longDesc is returned
     * with "(fainted)" at the end.
     *
     * @return the longDesc of the Explorer with some extra information
     *         depending which changes whether the Explorer is a alive or not.
     */
    @Override
    public String getDescription(){
        if (this.isAlive() == true){
            return this.longDesc + " with " + this.health + "health";
        }
        else{
            return "(fainted)";
        }
    }

    /**
     * Reduces the health of the explorer, the amount of health reduction is
     * dependent on the int given in as a parameter.
     *
     * @param d Amount of health to take off the Explorers current health.
     */
    public void takeDamage(int d){
        this.health =- d;
    }

    /**
     * Returns the amount of damage an Explorer can do.
     *
     * @return 1.
     */
    public int getDamage(){
        return 1;
    }

    /**
     * Mob and the explorer fight to the death, the mob takes damage first
     * then explorer.
     *
     * @param mob An object that implements mob.
     */
    public void fight(Mob mob){
        while(this.isAlive() && mob.isAlive()){
            mob.takeDamage(this.getDamage());
            if (mob.isAlive()){
                this.takeDamage(mob.getDamage());
            }
        }
    }

    /**
     * Sees if the Explorer wants to fight another object that implements mob
     *
     * @param mob The object that implements Mob that the Explorer might want
     *            to fight.
     * @return false.
     */
    public boolean wantsToFight(Mob mob){
        return false;
    }

    /**
     * Checks to see if the explorer's current health is above 0, if so true
     * will be returned if not false will be returned.
     *
     * @return boolean value.
     */
    public boolean isAlive(){
        return this.health > 0;
    }

    /**
     * If b == true the explorer has its health set back to its max health,
     * if false is passed into the method the health of the explorer is greater
     * than 0 the current health of the explorer is set to 0.
     *
     * @param b boolean value to change the status of the Explorer.
     */
    public void setAlive(boolean b){
        if (b){
            this.health =  this.maxHealth;
        }
        if (b == false && this.health>0){
            this.health = 0;
        }
    }

    /**
     * Takes in a Thing object and then adds it to the explorers library
     *
     * @param t Thing object to add to the inventory List
     */
    public void add(Thing t){
        this.inventory.add(t);
    }

    /**
     * Gets the inventory of the Explorer with everything in it and returns it.
     *
     * @return The inventory of the Explorer.
     */
    public List<Thing> getContents(){
        return this.inventory;
    }

    /**
     * Takes in a Thing object and if it is in the inventory it is removed,
     * if it isn't in the inventory the method fails silently.
     *
     * @param t Thing object to delete from the inventory of the explorer.
     */
    public void drop(Thing t){
        try{
                this.inventory.remove(t);
        }
        catch (Exception e){

        }

    }

    /**
     * Searches the explorer's inventory to find if an Thing in it contains
     * the shortDesc that is passed into the method.
     *
     * @param s shortDesc of the Thing object.
     * @return object that is removed from the inventory or null if the Thing
     *         isn't in the Explorers inventory.
     */
    public Thing drop(String s){
        Iterator<Thing> thingIterator = inventory.iterator();
        while(thingIterator.hasNext()){
            if(thingIterator.next().shortDesc == s){
                Thing thingRemoved = thingIterator.next();
                this.inventory.remove(thingIterator.next());
                return thingRemoved;
            }
        }
        return null;
    }

    /**
     * Returns the current health of the Explorer.
     *
     * @return The current health of the Explorer.
     */
    public int getHealth(){
        return this.health;
    }

}
