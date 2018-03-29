import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


public class TreasureTest {

    private Treasure perfectTreasure, descReplaceTreasure;
    private Explorer perfectLooter;
    private Critter noLooter;

    @Before
    public void setUp(){
        this.perfectTreasure = new Treasure("prefect treasure", 9000);
        this.descReplaceTreasure =
                new Treasure("Hello; My \n is Frank \r", 20);
        this.perfectLooter  =
                new Explorer("perfect", "perfect looter");
        this.noLooter = new Critter("bad", "no looting", 2, 1);
    }

    @Test
    public void nullTreasure(){
        try{
            Treasure nullTreasure = new Treasure(null, 4);
            fail();
        }catch (NullPointerException e){

        }
    }

    @Test
    public void canLoot() {
        assertTrue(this.perfectTreasure.canLoot(this.perfectLooter));
        assertFalse(this.perfectTreasure.canLoot(this.noLooter));
        assertFalse(this.perfectTreasure.canLoot(this.perfectTreasure));
    }

    @Test
    public void getValue() {
        assertTrue(9000 == this.perfectTreasure.getValue());
        assertFalse(0 == this.perfectTreasure.getValue());
    }

    @Test
    public void getDescription() {
        assertTrue("prefect treasure" ==
                this.perfectTreasure.getDescription());
        assertFalse("Not Perfect" ==
                this.perfectTreasure.getDescription());
        assertEquals("Hello* My * is Frank *",
                this.descReplaceTreasure.getDescription());
        assertNotEquals(this.perfectTreasure.getDescription(),
                this.descReplaceTreasure.getDescription());
        assertEquals(this.descReplaceTreasure.getDescription(),
                this.descReplaceTreasure.getShort());
        assertEquals(this.descReplaceTreasure.getDescription(),
                this.descReplaceTreasure.getLong());
    }

    @Test
    public void getLong() {
        assertTrue("prefect treasure" ==
                this.perfectTreasure.getLong());
        assertFalse("Not Perfect" ==
                this.perfectTreasure.getLong());
        assertEquals("Hello* My * is Frank *",
                this.descReplaceTreasure.getLong());
        assertNotEquals(this.perfectTreasure.getLong(),
                this.descReplaceTreasure.getLong());
    }

    @Test
    public void getShort() {
        assertNotEquals("Hello; My \n is Frank \r",
                this.descReplaceTreasure.getShort());
        assertEquals("Hello* My * is Frank *",
                this.descReplaceTreasure.getShort());
        assertNotEquals(this.descReplaceTreasure.getShort(),
                this.perfectTreasure.getShort());
    }

    @Test
    public void getShortDescription() {
        assertNotEquals("Hello; My \n is Frank \r",
                this.descReplaceTreasure.getShortDescription());
        assertEquals("Hello* My * is Frank *",
                this.descReplaceTreasure.getShortDescription());
        assertNotEquals(this.descReplaceTreasure.getShortDescription(),
                this.perfectTreasure.getShortDescription());
    }

    @Test
    public void setLong() {
        this.descReplaceTreasure.setLong(this.perfectTreasure.longDesc);
        assertEquals(this.descReplaceTreasure.getLong(),
                this.perfectTreasure.getLong());
        this.descReplaceTreasure.setLong("0");
        assertEquals("0", this.descReplaceTreasure.getLong());
        this.descReplaceTreasure.setLong("Hello; My \n is Frank \r");
        assertEquals("Hello* My * is Frank *",
                this.descReplaceTreasure.getLong());
        assertNotEquals("Hello; My \n is Frank \r",
                this.descReplaceTreasure.getLong());
    }

    @Test
    public void setShort() {
        this.descReplaceTreasure.setShort(this.perfectTreasure.longDesc);
        assertEquals(this.descReplaceTreasure.getShort(),
                this.perfectTreasure.getShort());
        this.descReplaceTreasure.setShort("0");
        assertEquals("0", this.descReplaceTreasure.getShort());
        this.descReplaceTreasure.setShort("Hello; My \n is Frank \r");
        assertEquals("Hello* My * is Frank *",
                this.descReplaceTreasure.getShort());
        assertNotEquals("Hello; My \n is Frank \r",
                this.descReplaceTreasure.getShort());
    }
}
