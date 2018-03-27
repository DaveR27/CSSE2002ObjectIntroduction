import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class TreasureTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Treasure.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Before
    public void setUp() throws Exception {
        Treasure treasureNull = new Treasure("this is shortDesc", 3);

    }

    @Test
    public void canLoot() {
    }

    @Test
    public void getValue() {
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getLong() {
    }

    @Test
    public void getShort() {
    }

    @Test
    public void getShortDescription() {
    }

    @Test
    public void setLong() {
    }

    @Test
    public void setShort() {
    }
}
