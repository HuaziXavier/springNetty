package com.lepp.no1.netty.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("channelInitializerHandler")
@Scope("prototype")
public class ChannelInitializerHandler extends ChannelInitializer<SocketChannel> {
    @Autowired
    private ServerHandler serverHandler;

    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline p  = ch.pipeline();
        p.addLast(new StringEncoder(CharsetUtil.UTF_8));
        p.addLast(new StringDecoder(CharsetUtil.UTF_8));
        p.addLast(serverHandler);
    }
}
