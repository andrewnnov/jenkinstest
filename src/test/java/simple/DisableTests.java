package simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("simple")
public class DisableTests {

    @Test
    @Disabled("Fix later")
    public void test1() {
        Assertions.assertTrue(true);
    }

    @Test
    @Disabled("Not actually anymore")
    public void test2() {
        Assertions.assertTrue(true);
    }
}
