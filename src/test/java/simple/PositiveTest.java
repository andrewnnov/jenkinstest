package simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Tag("simple")
public class PositiveTest {

    @Test
    public void test1() {
        Assertions.assertTrue(true);
    }

    @Test
    public void test2() {
        Assertions.assertTrue(true);
    }
}
