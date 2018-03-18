import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Explorer extends Thing implements Mob {

    protected int health;
    private int maxHealth;
    protected List<Thing> inventory = new Vector<Thing>();
    private boolean healthStatus = true;

    Explorer(Explorer p){
        this.health = p.health;
        this.longDesc = p.longDesc;
        this.shortDesc = p.shortDesc;
    }

    Explorer(String shortDesc, String longDesc){
        super(shortDesc, longDesc);
        this.maxHealth = 10;
        this.health = this.maxHealth;

    }

    Explorer(String shortDesc, String longDesc, int health){
        super(shortDesc, longDesc);
        this.maxHealth = health;
        this.health = this.maxHealth;
    }

    @Override
    public String getDescription(){
        if (this.isAlive() == true){
            return this.longDesc + " with " + this.health + "health";
        }
        else{
            return "(fainted)";
        }
    }

    public void takeDamage(int d){
        this.health =- d;
    }

    //How much damage could the mob hit for?
    public int getDamage(){
        return 1;
    }

    public void fight(Mob mob){
        while(isAlive()){
            mob.takeDamage(getDamage());
        }
    }

    public boolean wantsToFight(Mob mob){
        return false;
    }

    public boolean isAlive(){
        if (this.health > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void setAlive(boolean b){
        this.healthStatus = b;
        if (this.health > 0 && this.healthStatus == false){
            this.health = 0;
        }
        if (this.healthStatus == true){
            this.health = this.maxHealth;
        }
    }

    public void add(Thing t){
        this.inventory.add(t);
    }

    public List<Thing> getContents(){
        return this.inventory;
    }

    public void drop(Thing t){
        try{
                this.inventory.remove(t);
        }
        catch (Exception e){

        }

    }

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


    public int getHealth(){
        return this.health;
    }

}
