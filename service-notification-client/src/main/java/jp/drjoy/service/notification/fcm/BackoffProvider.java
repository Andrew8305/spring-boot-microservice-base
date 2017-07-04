package jp.drjoy.service.notification.fcm;

import java.time.Duration;

/**
 * BackoffProvider defines an interface for backoff.
 */
public interface BackoffProvider {

    /**
     * Returns true if not over the retries limit.
     */
    boolean sendAnother();

    /**
     * Set the minimum delay for backoff.
     */
    void setMin(Duration min);

    /**
     * Sleep for the current value of backoff.
     */
    void sleep() throws InterruptedException;

}


