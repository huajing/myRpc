package c.c.k.framework.server;

import c.c.k.framework.ParamObject;
import c.c.k.framework.util.ServiceUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 服务器接受客户端的请求，调用服务器service后，返回对象
 * @Title c.c.k.framework.server
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/27 chenck
 */
public class ServerNettyHandler extends SimpleChannelInboundHandler<Object> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        ParamObject paramObject = (ParamObject)o;
        ServiceUtil.callService(paramObject);
        channelHandlerContext.writeAndFlush(channelHandlerContext);
        channelHandlerContext.close();
    }
}
