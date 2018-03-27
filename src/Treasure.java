public class Treasure extends Thing implements Lootable{

    private double value;

    Treasure(String shortDesc, double value){
        super(shortDesc, shortDesc);
        this.value = value;
    }

    /*
    Returns true if the Thing is an instance of Explorer

    @param Thing looter: Thing object to be tested to see if it
                        can be a looter.
     */
    public boolean canLoot(Thing looter){
        return looter instanceof Explorer;
    }

    /*
    Returns the value of the treasure.

    @return double this.value: Value of the item.
     */
    public double getValue(){
        return this.value;
    }

}
