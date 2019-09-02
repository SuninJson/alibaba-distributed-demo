package sen.kafka.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * 使用Kafka的原生API实现生产者
 *
 * @author Huang Sen
 */
public class ConsumerQuickStart {
    private static final String BROKER_ADDRESS = "139.155.81.220:9092";
    private static final String TOPIC = "quick-start-demo";
    private static final String GROUP_ID = "quick-start-group";

    public static void main(String[] args) {
        String deserializerClassName = StringDeserializer.class.getName();

        //设置Consumer参数
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_ADDRESS);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, deserializerClassName);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializerClassName);

        //创建Consumer实例
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        //订阅主题
        consumer.subscribe(Collections.singletonList(TOPIC));

        //循环消费消息
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.value());
            }
        }

    }

}
