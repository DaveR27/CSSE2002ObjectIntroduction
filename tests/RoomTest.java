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
public class RoomTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Room.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getDescription() {
    }

    @Test
    public void setDescription() {
    }

    @Test
    public void getExits() {
    }

    @Test
    public void getContents() {
    }

    @Test
    public void addExit() {
    }

    @Test
    public void removeExit() {
    }

    @Test
    public void enter() {
    }

    @Test
    public void leave() {
    }
}
