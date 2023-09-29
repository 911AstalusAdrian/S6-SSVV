import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WhiteBoxTesting {
    private final List<Integer> feelingsListWithSadFeelings = List.of(0, 0, -1, 0, 1);
    private final List<Integer> feelingsListWithSadFeelingLast = List.of(0, 1, 0, 0, -1);

    @Test
    public void TestCheckNeighboursOnInvalidPosition1() {
        Assertions.assertFalse(Main.checkNeighbours(feelingsListWithSadFeelings, -1));
    }

    @Test
    public void TestCheckNeighboursOnInvalidPosition2() {
        Assertions.assertFalse(Main.checkNeighbours(feelingsListWithSadFeelings, 100));
    }

    @Test
    public void TestCheckNeighboursOnNonSadFeeling() {
        Assertions.assertFalse(Main.checkNeighbours(List.of(0, 0, 1, 0, -1), 2));
    }

    @Test
    public void TestCheckNeighboursFirstPositionAndSadFeeling() {
        Assertions.assertTrue(Main.checkNeighbours(List.of(-1, 0, -1, 0, 1), 0));
    }

    @Test
    public void TestCheckNeighboursLastPositionAndSadFeeling() {
        Assertions.assertTrue(Main.checkNeighbours(feelingsListWithSadFeelingLast, feelingsListWithSadFeelingLast.size() - 1));
    }

    @Test
    public void TestCheckNeighboursOnSadFeelingWithANonHappyNeighbour1() {
        Assertions.assertTrue(Main.checkNeighbours(List.of(0, -1, 1, 0, 1), 1));
    }

    @Test
    public void TestCheckNeighboursOnSadFeelingWithANonHappyNeighbour2() {
        Assertions.assertTrue(Main.checkNeighbours(List.of(1, -1, 0, 0, 1), 1));
    }


    @Test
    public void TestCheckNeighboursOnSadFeelingWithNoNonHappyNeighbour() {
        Assertions.assertFalse(Main.checkNeighbours(List.of(0, 1, -1, 1, 0), 2));
    }

}
