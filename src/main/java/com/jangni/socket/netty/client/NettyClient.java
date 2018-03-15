package com.jangni.socket.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Description:
 * @Autor: Jangni
 * @Date: Created in  2018/3/14/014 23:22
 */
public class NettyClient {
//    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//    EventLoopGroup group = new NioEventLoopGroup();
//    public void connect(int port,String host)throws  Exception{
//        try{
//            Bootstrap b = new Bootstrap();
//            b.group(group)
//                    .channel(NioServerSocketChannel.class)
//                    .handler(new ChannelInitializer<SocketChannel>() {
//                        @Override
//                        protected void initChannel(SocketChannel ch) throws Exception {
//                                  ch.pipeline().addLast(new NettyMessage)
//                        }
//                    })
//        }catch (Exception e){
//            group.shutdownGracefully();
//        }
//    }
}
