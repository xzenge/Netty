import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/10/24.
 */
public class Main {
    public static void main(String args[]) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap sb = new ServerBootstrap();

        sb.group(bossGroup, workerGroup);

        sb.channel(NioServerSocketChannel.class);

        sb.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                System.out.println(ch.toString());
            }
        });
        sb.bind(8888);

        System.out.println(BasicOperation.PLUS.apply(1,2));
        System.out.println(BasicOperation.PLUS.getSymbol());

    }
}
