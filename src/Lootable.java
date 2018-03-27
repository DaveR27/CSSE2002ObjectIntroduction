public interface Lootable {

    /*
    Returns a double value

    @return double
     */
    double getValue();

    /*
    Returns a boolean of whether or not a Thing can loot this object

    @param Thing looter: A thing that is able to take the loot
    @return Boolean
     */
    boolean canLoot(Thing looter);
}
