package com.bing.server;

import com.bing.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@Component
@ServerEndpoint(value = "/chat/{client}")
public class WebSocketServer {

    private String name;
    private Session session;

    @Autowired
    private UserMapper userMapper;

    /**
     * 为spring提供无参构造函数
     */
    public WebSocketServer(){

    }

    public WebSocketServer(String name, Session session) {
        this.name = name;
        this.session = session;
    }

    @OnOpen
    public void sessionOpen(@PathParam(value = "client")String client, Session session){
        this.session = session;
        this.name = client;

        System.out.println(client + "建立连接...");
    }

    @OnMessage
    public void onMessage(String message){

        System.out.println(message);
    }

    @OnClose
    public void onClose(){
        System.out.println(this.name + "disconnected...");
    }


}
