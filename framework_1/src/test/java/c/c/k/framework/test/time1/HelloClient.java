package c.c.k.framework.test.time1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Title c.c.k.framework.test.time1
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/27 chenck
 */
public class HelloClient {
    public static void main(String[] args) {
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
                        pipeline.addLast(new StringDecoder());
                        pipeline.addLast(new StringEncoder());

                        pipeline.addLast(new HelloClientString());
                    }
                });
            }
        });
        try {
            ChannelFuture f = b.connect("localhost", 1234).sync();
            while (true){
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    String line = br.readLine();
                    if(line.equals("exit"))
                        break;
                    f.channel().writeAndFlush(line + "\r\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
