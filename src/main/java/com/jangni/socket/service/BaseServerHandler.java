package com.jangni.socket.service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
/**
 * @Description:
 * @Autor: Jangni
 * @Date: Created in  2018/3/14/014 0:03
 */

public class BaseServerHandler extends ChannelInboundHandlerAdapter{


    private int counter;


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        String body = (String)msg;
        System.out.println("server receive order : " + body + ";the counter is: " + ++counter);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf message = null;
            message = Unpooled.buffer("123".getBytes().length);
            message.writeBytes("123".getBytes());
            ctx.writeAndFlush(message);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}