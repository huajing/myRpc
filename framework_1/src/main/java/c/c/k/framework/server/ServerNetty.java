package c.c.k.framework.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @Title c.c.k.framework.server.netty
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class ServerNetty implements IRpcServer {
    public void start() throws IOException, InterruptedException{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();        //1
            b.group(bossGroup, workerGroup)                                    //2
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 2048)
//                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {//3
                        @Override
                        public void initChannel(SocketChannel ch)throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
//                            pipeline.addLast(new ObjectEncoder());
                            pipeline.addLast(new FixedLengthFrameDecoder(16));
//                            pipeline.addLast(new ObjectDecoder(1024, ClassResolvers.weakCachingConcurrentResolver(ServerNetty.class.getClassLoader())));
                            //网络连接交给handler来处理
                            pipeline.addLast(new ServerNettyHandler());
                        }
                    });
            ChannelFuture f = b.bind(9999).sync();
            System.out.println("start listening ...");
            f.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully().sync();
            workerGroup.shutdownGracefully();
        }
    }
}
