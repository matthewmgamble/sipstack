/**
 * 
 */
package io.sipstack.netty.codec.sip;

import io.netty.channel.Channel;
import io.netty.channel.socket.DatagramPacket;
import io.pkts.packet.sip.SipMessage;

import java.net.InetSocketAddress;

/**
 * @author jonas@jonasborjesson.com
 */
public final class TcpConnection extends AbstractConnection {


    public TcpConnection(final Channel channel, final InetSocketAddress remote) {
        super(channel, remote);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void send(final SipMessage msg) {
        channel().writeAndFlush(toByteBuf(msg));
    }

    @Override
    public boolean connect() {
        return true;
    }

    @Override
    public void sendRawPacket(SipMessage msg, InetSocketAddress remote) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
