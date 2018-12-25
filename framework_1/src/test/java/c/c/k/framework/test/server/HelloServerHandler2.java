package c.c.k.framework.test.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Title c.c.k.framework.test
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class HelloServerHandler2 extends SimpleChannelInboundHandler<String> {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println("yyyyy-2");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }


}
