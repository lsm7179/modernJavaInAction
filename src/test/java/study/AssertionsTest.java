package study;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionsTest {
    @Test
    public void test() {
        int a = 10;
        assertThat(a).isEqualTo(10);
    }
}
