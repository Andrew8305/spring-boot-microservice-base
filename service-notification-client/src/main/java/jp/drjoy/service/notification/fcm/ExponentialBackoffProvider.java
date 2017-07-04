package jp.drjoy.service.notification.fcm;

import java.time.Duration;

/**
 * ExponentialBackoffProvider provides an exponential backoff implementation.
 */
public class ExponentialBackoffProvider implements BackoffProvider {

    private static final Duration MIN_BACK_OFF = Duration.ofSeconds(1);
    private static final Duration MAX_BACK_OFF = Duration.ofSeconds(10);

    private double attempt;

    /** Factor is multiplying factor for each increment step. */
    private double factor;

    /** Jitter eases contention by randomizing backoff steps*/
    private boolean jitter;

    /** The minimum value of the counter */
    private Duration min;

    /** The maximum value of the counter */
    private Duration max;

    private Duration currentDelay;

    ExponentialBackoffProvider() {
        this(0, 2, true, MIN_BACK_OFF, MAX_BACK_OFF);
    }

    ExponentialBackoffProvider(
            double attempt,
            double factor,
            boolean jitter,
            Duration min,
            Duration max) {
        this.attempt = attempt;
        this.factor = factor;
        this.jitter = jitter;
        this.min = min;
        this.max = max;

        currentDelay = forAttempt(attempt);
    }

    /**
     * Returns true if not over the reties limit.
     */
    @Override public boolean sendAnother() {
        return currentDelay.compareTo(max) <= 0;
    }

    /**
     * Set the minimum delay for backoff
     */
    @Override public void setMin(Duration min) {
        this.min = min;
        if (currentDelay.compareTo(min) < 0) {
            currentDelay = min;
        }
    }

    /**
     * Sleep for the current value of backoff
     */
    @Override public void sleep() throws InterruptedException {
        Thread.sleep(currentDelay.toMillis());
        currentDelay = duration();
    }

    /**
     * Duration returns the duration for the current attempt before incrementing
     * the attempt counter.
     *
     * @see ExponentialBackoffProvider#forAttempt(double)
     */
    Duration duration() {
        Duration duration = forAttempt(attempt);
        attempt++;
        return duration;
    }

    /**
     * ForAttempt returns the duration for a specific attempt. This is useful if
     * you have a large number of independent Backoffs, but don't want use
     * unnecessary memory storing the Backoff parameters per Backoff. The first
     * attempt should be 0.
     */
    Duration forAttempt(double attempt) {
        // Zero-values are nonsensical, so we use them to apply defaults
        Duration min = this.min;
        if (min.compareTo(Duration.ZERO) <= 0) {
            min = Duration.ofMillis(100);
        }
        Duration max = this.max;
        if (max.compareTo(Duration.ZERO) <= 0) {
            max = Duration.ofSeconds(10);
        }
        if (min.compareTo(max) >= 0) {
            // short-circuit
            return max;
        }
        double factor = this.factor;
        if (factor <=  0) {
            factor = 2;
        }
        // calculate this duration
        long minLong = min.toMillis();
        double durationDouble = minLong * Math.pow(factor, attempt);
        if (this.jitter) {
            double random = Math.random();
            durationDouble = random * (durationDouble - minLong) + minLong;
        }
        Duration duration = Duration.ofMillis(Math.round(durationDouble));
        // keep within bounds
        if (duration.compareTo(min) < 0) {
            return min;
        } else if (duration.compareTo(max) > 0) {
            return max;
        }
        return duration;
    }

    /**
     * Reset restarts the current attempt counter at zero.
     */
    void reset() {
        attempt = 0;
    }

    double getAttempt() {
        return attempt;
    }
}
