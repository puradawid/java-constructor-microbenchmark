package pro.puradawid.constructor;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class DataStructureParametersCuboidTest {

    @Test
    public void shouldCalculateCorrectVolume() {
        PlainParametersCuboid cuboid = new PlainParametersCuboid(1, 1, 1, 1, 1, 1);
        assertThat(cuboid.volume(), CoreMatchers.is(1.0));
    }

}