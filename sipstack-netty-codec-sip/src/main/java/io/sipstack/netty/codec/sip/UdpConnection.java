package io.sipstack.netty.codec.sip;

import io.netty.channel.Channel;
import io.netty.channel.socket.DatagramPacket;
import io.pkts.packet.sip.SipMessage;

import java.net.InetSocketAddress;

/**
 * Encapsulates a
 * 
 * @author jonas@jonasborjesson.com
 */
public final class UdpConnection extends AbstractConnection {

    // public UdpConnection(final ChannelHandlerContext ctx, final InetSocketAddress remoteAddress)
    // {
    // super(ctx, remoteAddress);
    // }
    
   

    public UdpConnection(final Channel channel, final InetSocketAddress remoteAddress) {
        super(channel, remoteAddress);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isUDP() {
        return true;
    }

    /**
     * {@inheritDoc}
     * @param msg
     */
    @Override
    public void send(final SipMessage msg) {
        final DatagramPacket pkt = new DatagramPacket(toByteBuf(msg), getRemoteAddress());
        channel().writeAndFlush(pkt);
      //  channel().
    }
    
    
    @Override
    public void sendRawPacket(final SipMessage msg, InetSocketAddress remote) {
        final DatagramPacket pkt = new DatagramPacket(toByteBuf(msg), remote);
        channel().writeAndFlush(pkt);
       
    }

    @Override
    public boolean connect() {
        return true;
    }

}
