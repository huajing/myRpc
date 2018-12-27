package c.c.k.framework.test.time1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Title c.c.k.framework.test.time1
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/27 chenck
 */
public class TimerServerString extends SimpleChannelInboundHandler<String> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        super.channelActive(ctx);
        System.out.println("server write efg　as channelActive");
        ctx.writeAndFlush("efg\r\n");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println("get msg from client:" + channelHandlerContext +  "  " + this + "  " + s);

    }
}
