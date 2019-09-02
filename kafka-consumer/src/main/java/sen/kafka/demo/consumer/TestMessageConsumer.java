package sen.kafka.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Huang Sen
 */
@Component
public class TestMessageConsumer {

    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord record) {
        Optional<?> message = Optional.ofNullable(record.value());
        message.ifPresent(System.out::println);
    }
}
