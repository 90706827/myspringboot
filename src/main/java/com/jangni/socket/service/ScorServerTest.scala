package com.jangni.socket.service

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.{ChannelFuture, ChannelInitializer, ChannelOption, EventLoopGroup}
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel

/**
  * @Description:
  * @Autor: Jangni
  * @Date: Created in  2018/3/12/012 22:41
  */
class ScorServerTest (port:Int) {

  def run:Unit = {
    val bossGroup:EventLoopGroup = new NioEventLoopGroup
    val workerGroup:EventLoopGroup = new NioEventLoopGroup

    try{
      val b : ServerBootstrap = new ServerBootstrap
      b.group(bossGroup,workerGroup)
        .channel(classOf[NioServerSocketChannel])
        .childHandler(new ChannelInitializer[SocketChannel] {
          @throws[Exception]
          def initChannel(ch: SocketChannel): Unit = {
            ch.pipeline.addLast(new MTimeServerHandler)
          }
        })
//        .option(ChannelOption.SO_BACKLOG,128)
//        .childOption(ChannelOption.SO_KEEPALIVE,true)

      val  f:ChannelFuture = b.bind(port).sync()
      f.channel().closeFuture().sync()
    }finally{
      workerGroup.shutdownGracefully()
      bossGroup.shutdownGracefully()
    }
  }

}
object ScorServerTest extends App{
  val  prot = 18080
  new ScorServerTest(prot).run
}
