public interface Lootable {

    //Returns the value of the item
    double getValue();

    //Returns true if the item is able to be looted
    boolean canLoot(Thing looter);
}
