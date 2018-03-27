import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Vector;

/*
Creates a Room object

Each room contains a roomDesc, Map<String, Room>, List<Thing
 */
public class Room {

    private String roomDesc;
    private Map<String, Room> rooms = new HashMap<String, Room>();
    private List<Thing> roomContents = new Vector<Thing>();


    /*
    Takes in a desc for the room.

    @param String desc
     */
    Room(String desc){
        this.roomDesc = desc;
    }

    /*
    Gets the desc for the room.

    @return String this.roomDesc.
     */
    public String getDescription(){
        return this.roomDesc;
    }

    /*
    Sets the desc for the room to something new

    @param String desc: New Room description
     */
    public void setDescription(String desc){
        this.roomDesc = desc;
    }

    /*
    Returns the map of the room

    @return Map<String, Room>
     */
    public Map<String, Room> getExits(){
        return this.rooms;
    }

    /*
    Returns a List containing everything within that room

    @return List<Thing> this.roomContents
     */
    public List<Thing> getContents(){
        return this.roomContents;
    }

    /*
    Adds an exit to the room

    @param String name: Name of the exit that is being added.
    @param Room target: The room that the exit goes to.
    @exception ExitExistsException: If the exist already exists.
    @exception NullRoomException: If the target is none.
     */
    public void addExit(String name, Room target) throws ExitExistsException, NullRoomException{
        if(this.rooms.containsKey(name)){
            throw new ExitExistsException();
        }
        else if(target == null){
            throw new NullRoomException();
        }
        else{
            rooms.put(name, target);
        }
    }

    /*
    Removes an exit from a room

    @param String name: Name of the exit that is going to be removed.
    @exception Exception: Silently fails if if the exit doesn't exist.
     */
    public void removeExit(String name){
        try{
            this.rooms.remove(name);
        }
        catch (Exception e){

        }
    }

    /*
    Adds a Thing to the Room

    @param Thing item: The Thing object that is going to be added.
     */
    public void enter(Thing item){
        this.roomContents.add(item);
    }

    /*
    Removes item from the Room

    Note: Will fail by returning false if item is not in the room
    or if something wants to fight item
    @return Boolean: True if successful, false otherwise.
     */
    //TODO: How does thing check to see if it is going to be in a fight?
    public boolean leave(Thing item){
        if (this.roomContents.contains(item)){
            this.roomContents.remove(item);
            return true;
        }
        else{
            return false;
        }
    }

}
