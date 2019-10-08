package c.c.k.framework.server;

import c.c.k.framework.ParamObject;
import c.c.k.framework.util.ServiceUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * 服务器接受客户端的请求，调用服务器service后，返回对象
 * @Title c.c.k.framework.server
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/27 chenck
 */
public class ServerNettyHandler extends SimpleChannelInboundHandler<Object> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception {
//        ParamObject paramObject = (ParamObject)o;
//        ServiceUtil.callService(paramObject);
//        channelHandlerContext.writeAndFlush(channelHandlerContext);
//        channelHandlerContext.close();

        ByteBuf buf = (ByteBuf) msg;

        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);

        String body = new String(req, "UTF-8");
//        System.out.println(body);
//        System.out.println("time server receive: " + body + ", counter: " + counter++);

        String currentTime = "QUERY TIME ORDER".equals(body) ? new Date().toString() : "BADY ORDER";
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        channelHandlerContext.write(resp);
        channelHandlerContext.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
