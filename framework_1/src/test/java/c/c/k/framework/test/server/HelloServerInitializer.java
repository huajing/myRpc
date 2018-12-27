package c.c.k.framework.test.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;


/**
 * @Title c.c.k.framework.test
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast("handle", new HelloServerHandler());
        socketChannel.pipeline().addLast("handle1", new HelloServerHandler2());
        socketChannel.pipeline().addFirst();
        System.out.println("xxx");
    }
}
