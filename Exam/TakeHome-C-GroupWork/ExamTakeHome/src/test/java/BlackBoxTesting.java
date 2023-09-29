import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BlackBoxTesting {

    @Test
    public void TestFindSadFeelingValidPosition() {
       Assertions.assertEquals(2, Main.findSadFeeling(List.of(0, 0, -1, 0, 1), 1));
    }

    @Test
    public void TestFindSadFeelingInvalidPosition1() {
        Assertions.assertEquals(-1, Main.findSadFeeling(List.of(0, 0, -1, 0, 1), -1));
    }

    @Test
    public void TestFindSadFeelingInvalidPosition2() {
        Assertions.assertEquals(-1, Main.findSadFeeling(List.of(0, 0, -1, 0, 1), 100));
    }

    @Test
    public void TestFindSadFeelingEmptyList() {
        Assertions.assertEquals(-1, Main.findSadFeeling(List.of(), 0));
    }

    @Test
    public void TestFindSadFeelingNoSadFeelings() {
        Assertions.assertEquals(-1, Main.findSadFeeling(List.of(0, 0, 1, 1, 0), 0));
    }

    @Test
    public void TestFindSadFeelingsInvalidFeelings() {
        Assertions.assertEquals(-1, Main.findSadFeeling(List.of(2, 0, -1, 0, 1), 0));
    }

}
