import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Class that is designed to be a building block of a Map.
 */
public class Room {

    private String roomDesc;
    private Map<String, Room> roomExits = new HashMap<String, Room>();
    private List<Thing> roomContents = new Vector<Thing>();

    /**
     * Creates a new Room object.
     *
     * @param desc The description of the new Room being created.
     */
    public Room(String desc){
        this.roomDesc = desc.replaceAll("\n", "*");
    }

    /**
     * Gets the description of the Room.
     *
     * @return The description of the Room.
     */
    public String getDescription(){
        return this.roomDesc;
    }

    /**
     * Sets the new description for the Room.
     *
     * @param desc The new description of the Room.
     */
    public void setDescription(String desc){
        this.roomDesc = desc.replaceAll("\n", "*");
    }

    /**
     * Gets all the exits from the current Room.
     *
     * @return A Map with the name of the exits for this Room and where
     *         they go to
     */
    public Map<String, Room> getExits(){
        return this.roomExits;
    }

    /**
     * Gets the List of all the Things within a Room.
     *
     * @return A List containing everything within that Room.
     */
    public List<Thing> getContents(){
        return this.roomContents;
    }

    /**
     * Adds an exit to the Room.
     *
     * @param name Name of the exit that is being added.
     * @param target The room that the exit goes to.
     * @throws ExitExistsException Thrown if the exist already exists.
     * @throws NullRoomException Thrown if the target is Null.
     */
    public void addExit(String name, Room target) throws ExitExistsException,
            NullRoomException{
        if(this.roomExits.containsKey(name)){
            throw new ExitExistsException();
        }
        else if(target == null){
            throw new NullRoomException();
        }
        else{
            roomExits.put(name, target);
        }
    }

    /**
     * Removes and exit from the room.
     *
     * @param name Name of the exit that is going to be removed.
     * @exception Exception Fails silently if room doesn't exist.
     */
    public void removeExit(String name){
        try{
            this.roomExits.remove(name);
        }
        catch (Exception e){

        }
    }

    /**
     * Adds a Thing obj to the roomContents Vector
     *
     * @param item The Thing object that is going to be added.
     */
    public void enter(Thing item){
        this.roomContents.add(item);
    }

    /**
     * Removes item from the Room
     *
     * Note: Will fail by returning false if item is not in the room
     * or if something wants to fight item.
     *
     * @param item The Thing object to be removed from the room
     * @return boolean true is the item is removed, otherwise false
     */
    public boolean leave(Thing item){
        if (this.roomContents.contains(item)){
            if (item instanceof Mob) {
                Mob mobItem = (Mob) item;
                for (Object obj : this.roomContents) {
                    if (obj instanceof Critter) {
                        Critter critterObj = (Critter) obj;
                        if (critterObj.wantsToFight(mobItem) == false) {
                            return true;
                        }
                        else{
                            return false;
                        }
                    }
                }
            }
            this.roomContents.remove(item);
            return true;
        }
        return false;
    }

}
