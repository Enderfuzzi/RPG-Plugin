package level;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.falgael.rpg.proficiency.Level;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LevelInstantiationTests {


    @Test
    @DisplayName("Simple Level Coverage")
    public void simple_Level_Check() {
        assertEquals(Level.ONE, Level.ZERO.getNextLevel());
        assertEquals(Level.ZERO, Level.ONE.getPrevious());
    }

}
