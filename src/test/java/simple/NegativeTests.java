package simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("simple")
public class NegativeTests {

    @Test
    public void test3() {
        Assertions.assertTrue(false);
    }

    @Test
    public void test4() {
        Assertions.assertTrue(false);
    }
}
