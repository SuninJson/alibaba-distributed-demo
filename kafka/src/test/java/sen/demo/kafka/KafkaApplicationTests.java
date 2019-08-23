package sen.demo.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sen.demo.kafka.producer.TestMessageProducer;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaApplicationTests {

    @Autowired
    private TestMessageProducer testMessageProducer;

    @Test
    public void publishTestMessage() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            testMessageProducer.send();
            TimeUnit.SECONDS.sleep(3);
        }
    }


}
