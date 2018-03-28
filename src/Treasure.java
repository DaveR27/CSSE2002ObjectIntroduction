/**
 * This class is used for items that can be picked up and used as a reward when
 * found by an Explorer. The class extends Thing and implements Lootable.
 */
public class Treasure extends Thing implements Lootable{

    private double value;

    /**
     * Creates a Treasure object that has a short description and a value, as
     * Treasure extends Thing it also needs a long description so the short
     * description is used for that as well.
     *
     * @param shortDesc The description of the Treasure obj.
     * @param value How much the Treasure object is worth.
     *
     * @require The shortDesc cannot be null of the object will not be created.
     */
    public Treasure(String shortDesc, double value){
        super(shortDesc, shortDesc);
        this.value = value;
    }

    /**
     * Checks to see if the Thing object is an explorer so it can loot the
     * Treasure object.
     *
     * @param looter The object being checked to see if it is an Explorer
     * @return True if Explorer, false otherwise.
     */
    public boolean canLoot(Thing looter){
        return looter instanceof Explorer;
    }

    /**
     * Gets the value of the Treasure object.
     *
     * @return Value of the Object
     */
    public double getValue(){
        return this.value;
    }

}
