import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test01(){
        redisTemplate.opsForValue().set("ssm_demo","test");
        System.out.println(redisTemplate.opsForValue().get("ssm_demo"));
    }
}
