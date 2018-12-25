package c.c.k.framework.test.client;

import c.c.k.framework.Constants;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Title c.c.k.framework.test
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class HelloClient {
    public static String host = "127.0.0.1";
    public static int port = Constants.SERVER_PORT;

    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap b = new Bootstrap();
        b.group(group)
                .channel(NioSocketChannel.class)
                .handler(new HelloClientInitializer());

        try {
            Channel ch = b.connect(host, port).sync().channel();
            ch.writeAndFlush("haha\r\n");
        } catch (InterruptedException e) {
            group.shutdownGracefully();
        }

    }
}
