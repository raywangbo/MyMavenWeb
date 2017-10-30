import com.ym.shiro.cache.JedisManager;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by Ray on 2017/10/23.
 */
public class test {

   @Test
    public void testRedis(){
       JedisManager jedisManager = new JedisManager();
       System.out.println(jedisManager.getJedis());
    }

}
