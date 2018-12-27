package c.c.k.framework.test.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Title c.c.k.framework.test.time
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/26 chenck
 */
public class TimeServerHandlerSimple extends SimpleChannelInboundHandler<ByteBuf> {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        byte[] bytes = new byte[byteBuf.readableBytes()];
    }
}
