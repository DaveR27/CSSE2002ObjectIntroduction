import org.junit.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import static org.junit.Assert.*;

public class RoomTest {

    private Room nullRoomDesc, perfectRoom, numberRoom, editDescRoom;

    @Before
    public void setUp(){
        this.perfectRoom = new Room("This is the best room ever");
        this.editDescRoom = new Room("\n Change \n Message \n");
        this.numberRoom = new Room("0");
    }

    @Test
    public void nullRoom(){
        try {
            this.nullRoomDesc = new Room(null);
            fail();
        }catch(NullPointerException e){

        }
    }

    @Test
    public void getDescription() {
        assertEquals("* Change * Message *",
                this.editDescRoom.getDescription());
        assertNotEquals(this.editDescRoom.getDescription(),
                this.perfectRoom.getDescription());
    }

    @Test
    public void setDescription() {
        this.editDescRoom.setDescription("0");
        assertEquals("0", this.editDescRoom.getDescription());
        this.editDescRoom.setDescription("\n Change \n Message \n");
        assertEquals( "* Change * Message *",
                this.editDescRoom.getDescription());
    }

    @Test
    public void getExits() {
        try {
            this.editDescRoom.addExit("TestRoom1", this.perfectRoom);
        }catch (ExitExistsException e){

        }catch (NullRoomException e){

        }
        Map<String, Room> roomExitTest = new HashMap<String, Room>();
        roomExitTest.put("TestRoom1", this.perfectRoom);
        assertEquals(roomExitTest,this.editDescRoom.getExits());
        roomExitTest.put("Test2", this.perfectRoom);
        assertNotEquals(roomExitTest, this.editDescRoom);
    }

    @Test
    public void getContents() {
        //Makes Test objects
        List<Thing> roomTest = new Vector<Thing>();
        Treasure gold = new Treasure("shiny", 30);
        Treasure silver = new Treasure("less shiny", 20);

        //Adds to the room
        this.perfectRoom.enter(gold);
        this.perfectRoom.enter(silver);
        this.editDescRoom.enter(silver);

        //Test
        assertNotEquals(this.editDescRoom.getContents(),
                this.perfectRoom.getContents());
        this.editDescRoom.enter(gold);
        assertTrue(this.editDescRoom.getContents().equals(
                this.perfectRoom.getContents()));
    }

    @Test
    public void addExit() {

        //Tests they are different
        Map<String, Room> TestExits= new HashMap<>();
        TestExits.put("Test", this.perfectRoom);
        try {
            this.editDescRoom.addExit("realExit", this.perfectRoom);
        }catch (NullRoomException e){}
        catch (ExitExistsException e){}
        assertNotEquals(TestExits, this.editDescRoom.getExits());

        //Tests the same
        TestExits.put("realExit", this.perfectRoom);
        try {
            this.editDescRoom.addExit("Test", this.perfectRoom);
        }catch (NullRoomException e){}
        catch (ExitExistsException e){}
        assertEquals(TestExits, this.editDescRoom.getExits());
    }

    @Test
    public void exceptionAddExits(){
        try {
            this.editDescRoom.addExit("Test2", this.perfectRoom);
            this.editDescRoom.addExit("Test1", null);
            fail();
        }catch (NullRoomException e){}
        catch (ExitExistsException e){}
        try {
            this.editDescRoom.addExit("Test2", this.perfectRoom);
            fail();
        }catch (NullRoomException e){}
        catch (ExitExistsException e){}
    }

    @Test
    public void removeExit() {
        Map<String, Room> test=new HashMap<>();
        test.put("exit1", this.perfectRoom);

        try {
            this.editDescRoom.addExit("exit1", this.perfectRoom);
        }catch (NullRoomException e){}
        catch (ExitExistsException e){}

        assertEquals(test,this.editDescRoom.getExits());
        this.editDescRoom.removeExit("exit1");
        assertNotEquals(test,this.editDescRoom.getExits());
        this.editDescRoom.removeExit("exit1");

    }

    @Test
    public void enter() {
        Treasure testThing = new Treasure("test", 2222);
        List<Thing> test = new Vector<>();
        test.add(testThing);

        this.editDescRoom.enter(testThing);
        assertEquals(test, this.editDescRoom.getContents());

        this.editDescRoom.leave(testThing);
        assertNotEquals(test, this.editDescRoom.getContents());

    }

    @Test
    public void leave() {
        Treasure testThing = new Treasure("testTreasure",
                2222);
        Explorer testExplorer = new Explorer("testExplorer",
                "TestExplorer", 10);
        Critter testCritter = new Critter("testCritter",
                "TestCritter", 2, 29);

        assertFalse(this.editDescRoom.leave(testThing));
        this.editDescRoom.enter(testThing);
        this.editDescRoom.enter(testExplorer);
        assertTrue(this.editDescRoom.leave(testExplorer));
        assertFalse(this.editDescRoom.getContents().contains(testExplorer));
        this.editDescRoom.enter(testExplorer);
        this.editDescRoom.enter(testCritter);
        assertFalse(this.editDescRoom.leave(testExplorer));
        assertTrue(this.editDescRoom.getContents().contains(testExplorer));
        assertTrue(this.editDescRoom.leave(testCritter));

    }
}
