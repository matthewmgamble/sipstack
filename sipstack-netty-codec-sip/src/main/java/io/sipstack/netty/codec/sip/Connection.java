/**
 * 
 */
package io.sipstack.netty.codec.sip;

import io.netty.channel.Channel;
import io.netty.channel.socket.DatagramPacket;
import io.pkts.packet.sip.SipMessage;

import java.net.InetSocketAddress;

/**
 * Represents a connection between two end-points and its primary purpose is to
 * encapsulate specific knowledge of which type of underlying {@link Channel} is
 * being used.
 * 
 * @author jonas@jonasborjesson.com
 */
public interface Connection {

    /**
     * Get the local port to which this {@link Connection} is listening to.
     * 
     * @return
     */
    int getLocalPort();

    /**
     * Get the local ip-address to which this {@link Connection} is listening to
     * as a byte-array.
     * 
     * @return
     */
    byte[] getRawLocalIpAddress();

    /**
     * Get the local ip-address to which this {@link Connection} is listening to
     * as a {@link String}.
     * 
     * @return
     */
    String getLocalIpAddress();

    /**
     * Get the remote address to which this {@link Connection} is connected to.
     * 
     * @return
     */
    InetSocketAddress getRemoteAddress();

    /**
     * Get the remote port to which this {@link Connection} is connected to.
     * 
     * @return
     */
    int getRemotePort();

    /**
     * Get the remote ip-address to which this {@link Connection} is connected
     * to as a byte-array.
     * 
     * @return
     */
    byte[] getRawRemoteIpAddress();

    /**
     * Get the remote ip-address to which this {@link Connection} is connected
     * to as a {@link String}.
     * 
     * @return
     */
    String getRemoteIpAddress();

    /**
     * Check whether or not this {@link Connection} is using UDP as its
     * underlying transport protocol.
     * 
     * @return
     */
    boolean isUDP();

    /**
     * Check whether or not this {@link Connection} is using TCP as its
     * underlying transport protocol.
     * 
     * @return
     */
    boolean isTCP();

    /**
     * Check whether or not this {@link Connection} is using TLS as its
     * underlying transport protocol.
     * 
     * @return
     */
    boolean isTLS();

    /**
     * Check whether or not this {@link Connection} is using SCTP as its
     * underlying transport protocol.
     * 
     * @return
     */
    boolean isSCTP();

    /**
     * Check whether or not this {@link Connection} is using websocket as its
     * underlying transport protocol.
     * 
     * @return
     */
    boolean isWS();

    /**
     * Send a message over this connection.
     * 
     * @param msg
     */
    void send(SipMessage msg);

    void sendRawPacket(SipMessage msg, InetSocketAddress remote);
    
    public boolean connect();

}
