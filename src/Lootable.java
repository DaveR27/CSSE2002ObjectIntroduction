/**
 * Makes the Lootable interface for all the objects in the game that need to
 * give loot.
 */
public interface Lootable {

    /**
     * Gets the value of the Lootable object and returns it.
     *
     * @return the value of the Lootable object.
     */
    double getValue();

    /**
     * Works out if a Thing can loot this object
     *
     * @param looter Thing that needs to be tested to see if it can loot this
     *               object.
     * @return true if it can loot it, false otherwise.
     */
    boolean canLoot(Thing looter);
}
