package c.c.k.framework.test.time1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Title c.c.k.framework.test.time1
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/27 chenck
 */
public class HelloClientString extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println("get server string:" + s);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client write abc ");
        ctx.writeAndFlush("client writer abc\r\n");
    }

}
