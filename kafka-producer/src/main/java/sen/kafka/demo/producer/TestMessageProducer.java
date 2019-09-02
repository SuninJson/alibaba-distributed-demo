package sen.kafka.demo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Huang Sen
 */
@Component
public class TestMessageProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public TestMessageProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send() {
        kafkaTemplate.send("test", "testMessageKey", "testMessageData");
    }

}
