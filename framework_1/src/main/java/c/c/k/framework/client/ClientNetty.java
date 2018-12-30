package c.c.k.framework.client;

import c.c.k.framework.Constants;
import c.c.k.framework.ParamObject;
import c.c.k.framework.server.ServerNetty;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * @Title c.c.k.framework.client
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/27 chenck
 */
public class ClientNetty extends IRpcClient {
    private ChannelFuture channelFuture;

    public ClientNetty(){
        Bootstrap b = new Bootstrap();
        EventLoopGroup group = new NioEventLoopGroup();
        b.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline pipeline = socketChannel.pipeline();
                pipeline.addLast(new ObjectEncoder());
                pipeline.addLast(new ObjectDecoder(1024, ClassResolvers.weakCachingConcurrentResolver(ServerNetty.class.getClassLoader())));
                //网络连接交给handler来处理
                pipeline.addLast(new ClientNettyHandler());
            }
        });

        try {
            channelFuture = b.connect(Constants.SERVER_ADDR, Constants.SERVER_PORT).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    @Override
    protected Object callRemote(ParamObject paramObject) {
        channelFuture.channel().writeAndFlush(paramObject);
        return null;
    }
}
