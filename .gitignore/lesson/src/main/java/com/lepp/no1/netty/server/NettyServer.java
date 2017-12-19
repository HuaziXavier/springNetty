package com.lepp.no1.netty.server;

import com.lepp.no1.netty.handler.ChannelInitializerHandler;
import com.lepp.no1.netty.handler.ServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("nettyServer")
public class NettyServer {

    @Autowired
    private ChannelInitializerHandler channelInitializerHandler;

    @PostConstruct
    public void init() {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("==================netty服务端启动");
                EventLoopGroup parent = new NioEventLoopGroup(1);
                EventLoopGroup child = new NioEventLoopGroup();
                try {
                    ServerBootstrap bt = new ServerBootstrap();
                    bt.group(parent, child);
                    bt.channel(NioServerSocketChannel.class);
                    bt.option(ChannelOption.SO_BACKLOG, 128);
                    bt.childHandler(channelInitializerHandler);
                    ChannelFuture future = bt.bind(8090).sync();
                    future.channel().closeFuture().sync();
                    System.out.println("==================netty服务端启动完成");
                } catch (Exception e) {

                } finally {
                    parent.shutdownGracefully();
                    child.shutdownGracefully();
                }
            }
        }).start();


    }

}
