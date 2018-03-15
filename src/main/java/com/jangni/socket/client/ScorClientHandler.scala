package com.jangni.socket.client

import java.util.Date

import io.netty.buffer.ByteBuf
import io.netty.channel.{ChannelHandlerContext, ChannelInboundHandlerAdapter}

/**
  * Author ZhangGuoQiang
  * Date: 2018/3/12/012
  * Time: 15:50
  * Description:
  */
class ScorClientHandler extends ChannelInboundHandlerAdapter {


  override def channelRead(ctx: ChannelHandlerContext, msg: Any): Unit = {
    val m = msg.asInstanceOf[ByteBuf]
    try {
      val currentTimeMillis = (m.readUnsignedInt - 2208988800L) * 1000L
     println(new Date(currentTimeMillis))
      ctx.close
    } finally m.release
  }
  override def exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable): Unit = {
    cause.printStackTrace()
    ctx.close
  }
}
