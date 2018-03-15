package com.jangni.socket.client

import io.netty.bootstrap.Bootstrap
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.channel.{ChannelFuture, ChannelInitializer, ChannelOption, EventLoopGroup}

/**
  * Author ZhangGuoQiang
  * Date: 2018/3/12/012
  * Time: 11:25
  * Description:
  */
class ScorClient(host: String, port: Int) {

  val workerGroup: EventLoopGroup = new NioEventLoopGroup()
  val bootstrap = new Bootstrap()
  bootstrap.group(workerGroup)
    .channel(classOf[NioSocketChannel])

  protected def connect: ChannelFuture = {

    try {
      bootstrap
        .handler(new ChannelInitializer[SocketChannel] {
          override def initChannel(ch: SocketChannel): Unit = {
            ch.pipeline().addLast(new ScorClientHandler())
          }
        })
      val f: ChannelFuture = bootstrap.connect(host, port).sync()
      f.channel().closeFuture().sync()
    } finally {
      workerGroup.shutdownGracefully()
    }
  }

  //  def send(msg:String):Future[String] = {
  //    connect.addListener(new ChannelFutureListener {
  //      override def operationComplete(future: ChannelFuture): Unit = {
  //        if(future.isSuccess){
  //          future.channel().writeAndFlush(msg)
  //        }
  //      }
  //    })
  //  }

}
