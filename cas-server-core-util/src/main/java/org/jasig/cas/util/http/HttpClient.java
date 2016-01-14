package org.jasig.cas.util.http;

import javax.validation.constraints.NotNull;
import java.net.URL;

/**
 * Define the behaviour of a HTTP client.
 *
 * @author Jerome Leleu
 * @author Misagh Moayyed
 * @since 4.0.0
 */
public interface HttpClient {

    /**
     * Sends a message to a particular endpoint.  Option of sending it without
     * waiting to ensure a response was returned.
     * <p/>
     * This is useful when it doesn't matter about the response as you'll perform no action based on the response.
     *
     * @param message The message that should be sent to the http endpoint
     * @return boolean if the message was sent, or async was used.  false if the message failed.
     * @since 4.1.0
     */
    boolean sendMessageToEndPoint(@NotNull HttpMessage message);

    /**
     * Send message to an endpoint as a GET and return the resulting http message.
     *
     * @param url the url
     * @return the http message
     */
    HttpMessage sendMessageToEndPoint(@NotNull URL url);

    /**
     * Make a synchronous HTTP(S) call to ensure that the url is reachable.
     *
     * @param url the url to call
     * @return whether the url is valid
     */
    boolean isValidEndPoint(@NotNull String url);

    /**
     * Make a synchronous HTTP(S) call to ensure that the url is reachable.
     *
     * @param url the url to call
     * @return whether the url is valid
     */
    boolean isValidEndPoint(@NotNull URL url);

    /**
     * Gets wrapped http client.
     *
     * @return the wrapped http client
     */
    org.apache.http.client.HttpClient getWrappedHttpClient();
}
