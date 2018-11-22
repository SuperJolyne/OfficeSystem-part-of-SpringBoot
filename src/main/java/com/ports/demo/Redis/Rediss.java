package com.ports.demo.Redis;

import redis.clients.jedis.Jedis;

public class Rediss {
    public static final String SERVER_ADDRESS = "127.0.0.1"; // 服务器地址
    public static final Integer SERVER_PORT = 6379; // 端口

    private Jedis jedis;

    public void init(){
        jedis = new Jedis(SERVER_ADDRESS,SERVER_PORT);
    }

    public void dis(){
        jedis.disconnect();
    }

    public void pubPict() {
        jedis.publish("__keyevent@0__:expired","order:picture");
    }

    public void pubNotice() {
        jedis.publish("__keyevent@0__:expired","order:notice");
    }

}

