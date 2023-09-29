import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BigBangIntegrationTesting {
    private final List<Integer> feelingsListWithSadFeelings = List.of(-1, -1, 0, 0, 1, 1, -1, 1, 0, -1, 1, 0, 1, 1, -1, 0, 1, 1);

    @Test
    public void TestBeHappy() {
        List<Integer> initialFeelings = new ArrayList<>(feelingsListWithSadFeelings);
        List<Integer> transformedFeelings = Main.beHappy(initialFeelings);
        Assertions.assertArrayEquals(
                transformedFeelings.toArray(),
                List.of(1, -1, 1, -1, 1, 0, 0, 1, 1, -1, 1, 0, 1, -1, 1, 0, 1, 1, -1, 1, 0, 1, 1).toArray()
        );
    }
}
