import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Explorer extends Thing implements Mob {

    protected int health;
    private int maxHealth;
    protected List<Thing> inventory = new Vector<Thing>();

    /*
    Constructor that takes in another explorer and then passed in
    explorer has its health, shortDesc and longDesc copied to the current
    explorer.

    @param Explorer p: Takes in another Explorer object
     */
    Explorer(Explorer p){
        super(p.shortDesc, p.longDesc);
        this.health = p.health;
    }

    /*
    Constructor that will set the shortDesc and the longDesc, but it will set the
    starting health of the Explorer to 10

    @param String shortDesc: short name of the the Explorer
    @param String longDesc: Gives a long description of the Explorer
     */
    Explorer(String shortDesc, String longDesc){
        super(shortDesc, longDesc);
        this.maxHealth = 10;
        this.health = this.maxHealth;

    }

    /*
    Constructor that will set the shortDesc, longDesc and the starting/max health of the
    Explorer.

    @param String shortDesc: The name of the Explorer
    @param String longDesc: The long description of the Explorer
     */
    Explorer(String shortDesc, String longDesc, int health){
        super(shortDesc, longDesc);
        this.maxHealth = health;
        this.health = this.maxHealth;
    }

    /*
    Gets the Explorers longDesc with some extra information is the Explorer isAlive()
    if the Explorer is not alive then the longDesc is returned with "(fainted)" at the end

    @return String: Returns the longDesc of the Explorer with some extra information
                    depending which changes whether the Explorer is a alive or not.
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

    /*
    Reduces the health of the explorer, the amount of health reduction
    is dependent on the int given in as a parameter.

    @param int d: The amount to take of the health of the explorer
     */
    public void takeDamage(int d){
        this.health =- d;
    }

    /*
    Returns 1 as the amount of damage an explorer can do.

    @return int: Returns 1 for the amount of damage an explorer does.
     */
    public int getDamage(){
        return 1;
    }

    /*
    Mob and the explorer fight to the death, the mob takes damage first then explorer

    @param Mob mob: An object that implements mob
     */
    public void fight(Mob mob){
        while(this.isAlive() && mob.isAlive()){
            mob.takeDamage(this.getDamage());
            if (mob.isAlive()){
                this.takeDamage(mob.getDamage());
            }
        }
    }

    /*
    Sees if the explorer wants to fight another object that implements mob

    @return Boolean false
     */
    public boolean wantsToFight(Mob mob){
        return false;
    }

    /*
    Checks to see if the explorer's current health is above 0,
    if so true will be returned if not false will be returned

    @return Boolean
     */
    public boolean isAlive(){
        if (this.health > 0){
            return true;
        }
        else{
            return false;
        }
    }

    /*
    If b == true the explorer has its health set back to its max health, if false is
    passed into the method the health of the explorer is greater than 0 the current
    health of the explorer is set to 0.

    @param boolean b
     */
    public void setAlive(boolean b){
        if (b){
            this.health =  this.maxHealth;
        }
        if (b == false && this.health>0){
            this.health = 0;
        }
    }

    /*
    Takes in a Thing object and then adds it to the explorers library

    @param Thing t: Thing object to add to the inventory List
     */
    public void add(Thing t){
        this.inventory.add(t);
    }

    /*
    Returns the inventory of the explorer

    @return List this.inventory
     */
    public List<Thing> getContents(){
        return this.inventory;
    }

    /*
    Takes in a Thing object and if it is in the inventory it is removed, if it
    isn't in the inventory the method fails silently

    @param Thing t: Thing object to delete from the inventory of the explorer
     */
    public void drop(Thing t){
        try{
                this.inventory.remove(t);
        }
        catch (Exception e){

        }

    }

    /*
    Searches the explorer's inventory to find if an Thing in it contains
    the shortDesc that is passed into the method.

    @param String s: shortDesc of the Thing object.
    @return null: if the Thing isn't found in the explorers inventory.
    @return Thing: object that is removed from the inventory.
     */
    public Thing drop(String s){
        Iterator<Thing> thingIterator = inventory.iterator();
        while(thingIterator.hasNext()){
            if(thingIterator.next().shortDesc == s){
                Thing thingRemoved = thingIterator.next();
                this.inventory.remove(thingIterator.next());
                return thingRemoved;
            }
            else{
            return null;
            }
        }
    }

    /*
    Returns the current health of the explorer.

    @return int this.health
     */
    public int getHealth(){
        return this.health;
    }

}
