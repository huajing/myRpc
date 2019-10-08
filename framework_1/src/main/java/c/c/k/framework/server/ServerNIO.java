package c.c.k.framework.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @Title c.c.k.framework.server.nio
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class ServerNIO implements IRpcServer{
    public void start() {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel socketChannel = ServerSocketChannel.open();
            socketChannel.socket().bind(new InetSocketAddress(9999));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true){
                if(selector.select(1000) == 0){
                    continue;
                }

                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey next = iterator.next();
                    if(next.isAcceptable()){
//                        System.out.println("isAcceptable");
                        handAccept(next);
                    }

                    if(next.isReadable()){
//                        System.out.println("isReadable");
                        handRead(next);
                    }

                    if(next.isWritable()){
//                        System.out.println("isWritable");
                        handWrite(next);
                    }
                    /*if(next.isConnectable()){
                        System.out.println("isConnectable");
                    }*/
                    iterator.remove();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void handAccept(SelectionKey key) throws IOException {
        ServerSocketChannel socketChannel = (ServerSocketChannel)key.channel();
        SocketChannel accept = socketChannel.accept();
        accept.configureBlocking(false);
        accept.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocateDirect(1024));
    }

    public static void handRead(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel)key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        int readBytes = channel.read(buffer);
        while (readBytes>0){
            buffer.flip();
            while (buffer.hasRemaining()){
                buffer.get();
//                System.out.print((char) buffer.get());;//data here
            }
            buffer.clear();
            readBytes = channel.read(buffer);
        }

        if(readBytes == -1){
            channel.close();
        }
        channel.register(key.selector(), SelectionKey.OP_WRITE, new Object());
    }

    public static void handWrite(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel)key.channel();
//        ByteBuffer buffer = (ByteBuffer) key.attachment();
//        buffer.flip();

//        while (buffer.hasRemaining()){
//            channel.write(buffer);
//        }
//        buffer.compact();
        ByteBuffer byteBuffer = ByteBuffer.wrap("abc".getBytes());
        byteBuffer.flip();
        channel.write(byteBuffer);
        channel.close();
    }
}
