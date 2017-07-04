package jp.drjoy.service.notification.fcm;

import java.time.Duration;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

public class ExponentialBackoffProviderTest {

    @Test
    public void forAttempt() throws Exception {
        ExponentialBackoffProvider provider =
                new ExponentialBackoffProvider(0, 2, false,
                        Duration.ofMillis(100), Duration.ofSeconds(10));

        assertThat(provider.forAttempt(0), is(Duration.ofMillis(100)));
        assertThat(provider.forAttempt(1), is(Duration.ofMillis(200)));
        assertThat(provider.forAttempt(2), is(Duration.ofMillis(400)));
        provider.reset();
        assertThat(provider.forAttempt(0), is(Duration.ofMillis(100)));
    }

    @Test
    public void test2() throws Exception {
        ExponentialBackoffProvider provider =
                new ExponentialBackoffProvider(0, 1.5, false,
                        Duration.ofMillis(100), Duration.ofSeconds(10));

        assertThat(provider.duration(), is(Duration.ofMillis(100)));
        assertThat(provider.duration(), is(Duration.ofMillis(150)));
        assertThat(provider.duration(), is(Duration.ofMillis(225)));
        provider.reset();
        assertThat(provider.duration(), is(Duration.ofMillis(100)));
    }

    @Test
    public void test3() throws Exception {
        ExponentialBackoffProvider provider =
                new ExponentialBackoffProvider(0, 1.75, false,
                        Duration.ofMillis(100), Duration.ofSeconds(10));

        assertThat(provider.duration(), is(Duration.ofMillis(100)));
        assertThat(provider.duration(), is(Duration.ofMillis(175)));
        assertThat(provider.duration(), is(Duration.ofMillis(306)));
        provider.reset();
        assertThat(provider.duration(), is(Duration.ofMillis(100)));
    }

    @Test
    public void test4() throws Exception {
        Duration expect =  Duration.ofSeconds(100);
        ExponentialBackoffProvider provider =
                new ExponentialBackoffProvider(0, 1, false,
                        Duration.ofSeconds(500), expect);

        assertThat(provider.duration(), is(expect));
    }

    @Test
    public void testGetAttempt() throws Exception {
        ExponentialBackoffProvider provider =
                new ExponentialBackoffProvider(0, 2, false,
                        Duration.ofMillis(100), Duration.ofSeconds(10));

        assertThat(provider.getAttempt(), is(0.0));
        assertThat(provider.duration(), is(Duration.ofMillis(100)));
        assertThat(provider.getAttempt(), is(1.0));
        assertThat(provider.duration(), is(Duration.ofMillis(200)));
        assertThat(provider.getAttempt(), is(2.0));
        assertThat(provider.duration(), is(Duration.ofMillis(400)));
        assertThat(provider.getAttempt(), is(3.0));
        provider.reset();
        assertThat(provider.getAttempt(), is(0.0));
        assertThat(provider.duration(), is(Duration.ofMillis(100)));
        assertThat(provider.getAttempt(), is(1.0));
    }

    @Test
    public void testJitter() throws Exception {
        ExponentialBackoffProvider provider =
                new ExponentialBackoffProvider(0, 2, true,
                        Duration.ofMillis(100), Duration.ofSeconds(10));

        assertThat(provider.duration(), is(Duration.ofMillis(100)));
        assertTrue(inRange(provider.duration(), Duration.ofMillis(100), Duration.ofMillis(200)));
        assertTrue(inRange(provider.duration(), Duration.ofMillis(100), Duration.ofMillis(400)));
        provider.reset();
        assertThat(provider.duration(), is(Duration.ofMillis(100)));
    }

    private boolean inRange(Duration actual, Duration low, Duration high) {
        return actual.compareTo(low) >= 0 && actual.compareTo(high) <= 0;
    }
}