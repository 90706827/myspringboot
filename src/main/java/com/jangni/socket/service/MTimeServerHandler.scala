package com.jangni.socket.service

import io.netty.channel.{ChannelFuture, ChannelFutureListener, ChannelHandlerContext, ChannelInboundHandlerAdapter}

/**
  * Author ZhangGuoQiang
  * Date: 2018/3/12/012
  * Time: 17:07
  * Description:
  */
class MTimeServerHandler extends ChannelInboundHandlerAdapter {

  override def channelActive(ctx: ChannelHandlerContext): Unit = {
    val time = ctx.alloc.buffer(4) // (2)
    time.writeInt((System.currentTimeMillis / 1000L + 2208988800L).toInt)

    val f = ctx.writeAndFlush(time) // (3)
    f.addListener(new ChannelFutureListener() {
      override def operationComplete(future: ChannelFuture): Unit = {
        assert(f eq future)
        ctx.close
      }
    }) // (4)

  }
  override def exceptionCaught(ctx:ChannelHandlerContext,cause:Throwable):Unit = {
    cause.printStackTrace()
    ctx.close()
  }
}
