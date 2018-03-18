import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Vector;

public class Room {

    private String roomDesc;
    protected Map<String, Room> rooms = new HashMap<String, Room>();
    protected List<Thing> roomContents = new Vector<Thing>();

    Room(String desc){
        this.roomDesc = desc;
    }

    public String getDescription(){
        return this.roomDesc;
    }

    public void setDescription(String desc){
        this.roomDesc = desc;
    }

    public Map<String, Room> getExits(){
        return this.rooms;
    }

    public List<Thing> getContents(){
        return this.roomContents;
    }

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

    public void removeExit(String name){
        this.rooms.remove(name);
    }

    public void enter(Thing item){
        this.roomContents.add(item);
    }

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
