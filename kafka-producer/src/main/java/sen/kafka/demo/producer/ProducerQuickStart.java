package sen.kafka.demo.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * 使用Kafka的原生API实现生产者
 *
 * @author Huang Sen
 */
public class ProducerQuickStart {
    private static final String BROKER_ADDRESS = "139.155.81.220:9092";
    private static final String TOPIC = "quick-start-demo";

    public static void main(String[] args) {
        String serializeClassName = StringSerializer.class.getName();

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_ADDRESS);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, serializeClassName);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, serializeClassName);

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC,
                "Hello consumer in my kafka's quick start demo,I'm producer!");
        producer.send(record);

        producer.close();
    }
}
