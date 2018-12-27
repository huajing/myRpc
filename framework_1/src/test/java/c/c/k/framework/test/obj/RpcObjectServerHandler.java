package c.c.k.framework.test.obj;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Title c.c.k.framework.test.obj
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/27 chenck
 */
public class RpcObjectServerHandler extends SimpleChannelInboundHandler<Object> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        RpcObject rpcObject = (RpcObject)o;

        System.out.println("RpcObjectServerHandler" + rpcObject);
    }
}
