package com.ym.shiro.cache;

import com.ym.shiro.session.ShiroSessionRepository;
import com.ym.utils.SerializeUtil;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.util.Collection;

/**
 * Session管理
 *
 * @auther Administrator Ray
 * @create 2017/10/30
 */
public class JedisShiroSessionRepository implements ShiroSessionRepository{
    public static final String REDIS_SESSION = "my-maven-web-session:";
    //这里有个小BUG，因为Redis使用序列化后，Key反序列化回来发现前面有一段乱码，解决的办法是存储缓存不序列化
    public static final String REDIS__ALLSEESION = "*my-maven-web-session:*";
    private static final int SESSION_VAL_TIME_SPAN = 18000;
    @Value("$redis.dbindex")
    private static  int DB_INDEX;

    private JedisManager jedisManager;

    @Override
    public void saveSession(Session session) {
        if(session == null || session.getId() == null){
            throw new NullPointerException("Session is empty");
        }

        byte[] key = buildRedisSessionKey(session.getId()).getBytes();
        byte[] value = session.toString().getBytes();
        jedisManager.saveValByKey(DB_INDEX, key, value, (int)(session.getTimeout() / 1000));
    }

    @Override
    public void deleteSession(Session session) {
        if(session ==null || session.getId() ==null){
            throw new NullPointerException("Session is empty");
        }
        jedisManager.deleteByKey(DB_INDEX,buildRedisSessionKey(session.getId()).getBytes());
    }

    @Override
    public Session getSession(Serializable id) {
        if (id == null)
            throw new NullPointerException("session id is empty");
        Session session = null;
        try {
            byte[] value = jedisManager.getValByKey(DB_INDEX,buildRedisSessionKey(id).getBytes());
            session = SerializeUtil.deserialize(value, Session.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }

    @Override
    public Collection<Session> getAllSession() {
        return jedisManager.getAllSession(DB_INDEX,REDIS_SESSION);//////////
    }

    private String buildRedisSessionKey(Serializable sessionId){
        return REDIS_SESSION + sessionId;
    }
}
