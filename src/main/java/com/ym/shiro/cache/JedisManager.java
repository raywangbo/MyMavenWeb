package com.ym.shiro.cache;

import com.ym.utils.SerializeUtil;
import org.apache.shiro.session.Session;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Redis Manager Utils
 *
 * @auther Administrator Ray
 * @create 2017/10/30
 */
public class JedisManager {

    private JedisPool jedisPool;

    /**
     * Get Jedis object
     * @Auther Ray
     * @Date 2017/10/30 10:19
     */
    public Jedis getJedis(){
        Jedis jedis = null;
        try {
            jedis = getJedisPool().getResource();
        }catch (JedisConnectionException e){
            if("Could not get a resource from the pool".equalsIgnoreCase(e.getMessage())){
                System.out.println("++++++++++请检查redis服务++++++++++");
                System.exit(0);//停止项目
            }
            throw new JedisConnectionException(e);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return jedis;
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public void closeResource(Jedis jedis){
        if(jedis == null){
            return;
        }
        jedis.close();
    }

    /**
     * 通过键值获取值
     * @param dbIndex
     * @param key
     * @return
     */
    public byte[] getValByKey(int dbIndex, byte[] key){
        Jedis jedis = null;
        byte[] result = null;
        try{
            jedis = getJedis();
            jedis.select(dbIndex);
            result = jedis.get(key);
        }catch (Exception e){
            throw e;
        }finally {
            closeResource(jedis);
        }
        return  result;
    }

    /**
     * 根据键值删除内容
     * @param dbIndex
     * @param key
     */
    public void deleteByKey(int dbIndex, byte[] key){
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            jedis.del(key);
        } catch (Exception e){
            throw  e;
        } finally {
            closeResource(jedis);
        }
    }

    /**
     * 保存键值及值
     * @param dbIndex
     * @param key
     * @param value
     * @param expireTime
     */
    public void saveValByKey(int dbIndex, byte[] key, byte[] value, int expireTime){
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(dbIndex);
            jedis.set(key, value);
            if(expireTime > 0){
                jedis.expire(key, expireTime);//Set a timeout on the specified key.
            }
        } catch (Exception e){
            throw e;
        } finally {
            closeResource(jedis);
        }
    }

    public Collection<Session> getAllSession(int dbIndex, String redisSession){
        Jedis jedis = null;
        Set<Session> sessions = new HashSet<>();
        jedis = getJedis();
        jedis.select(dbIndex);
        Set<byte[]> byteKeys = jedis.keys(JedisShiroSessionRepository.REDIS__ALLSEESION.getBytes());
        if(byteKeys != null && byteKeys.size() > 0){
            for(byte[] ele : byteKeys){
                sessions.add(SerializeUtil.deserialize(ele, Session.class));
            }
        }

        return sessions;
    }
}
