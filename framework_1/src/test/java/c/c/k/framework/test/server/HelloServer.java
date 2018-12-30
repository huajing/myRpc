package c.c.k.framework.test.server;

import c.c.k.framework.Constants;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Title c.c.k.framework.test
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class HelloServer {
    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap b = new ServerBootstrap();
        //The EventLoopGroup which is used to handle all the events for the to-be-created Channel
        b.group(bossGroup, workerGroup);
        //The Class which is used to create Channel instances from.
        b.channel(NioServerSocketChannel.class);
        //Set the ChannelHandler which is used to serve the request for the Channel's.
        b.childHandler(new HelloServerInitializer());

        try {
            //Create a new Channel and bind it.
            //Waits for this future until it is done, and rethrows the cause of the failure if this future failed.
            ChannelFuture f = b.bind(Constants.SERVER_PORT).sync();
//            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
//            e.printStackTrace();
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
