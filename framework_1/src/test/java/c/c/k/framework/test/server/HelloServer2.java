package c.c.k.framework.test.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Title c.c.k.framework.test.server
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class HelloServer2 {
    public static void main(String[] args) {
        ServerBootstrap ss = new ServerBootstrap();
        //java.lang.IllegalStateException: group not set
        ss.group(new NioEventLoopGroup());
        //java.lang.IllegalStateException: channel or channelFactory not set
        ss.channel(NioServerSocketChannel.class);
        //java.lang.IllegalStateException: childHandler not set
        ss.childHandler(new HelloServerInitializer());
        try {
            ss.bind(1234).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
