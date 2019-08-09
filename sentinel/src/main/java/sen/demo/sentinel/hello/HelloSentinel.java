package sen.demo.sentinel.hello;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huang Sen
 */
public class HelloSentinel {

    public static final String HELLO_SENTINEL_RESOURCE = "HelloSentinelResource";

    /**
     * 执行效果：
     * 查看logs\csp下的文件：
     * |--timestamp-|------date time----|--resource-|p |block|s |e|rt
     * 1529998904000|2018-06-26 15:41:44|hello world|20|0    |20|0|0
     * 1529998905000|2018-06-26 15:41:45|hello world|20|5579 |20|0|728
     * 1529998906000|2018-06-26 15:41:46|hello world|20|15698|20|0|0
     * <p>
     * p：    代表通过的请求,
     * block：代表被阻止的请求,
     * s：    代表成功执行完成的请求个数,
     * e：    代表用户自定义的异常,
     * rt：   代表平均响应时长
     *
     * @param args
     */
    public static void main(String[] args) {
        // 配置规则.
        initFlowRules();

        while (true) {
            // 1.5.0 版本开始可以直接利用 try-with-resources 特性
            try (Entry entry = SphU.entry(HELLO_SENTINEL_RESOURCE)) {
                // 被保护的逻辑
                System.out.println("hello sentinel");
            } catch (BlockException ex) {
                // 处理被流控的逻辑
                System.out.println("blocked!");
            }
        }
    }

    /**
     * 通过流控规则来指定允许该资源通过的请求次数:
     * 定义了资源 HelloSentinelResource 每秒最多只能通过 20 个请求。
     *
     * 围绕资源的实时状态设定的规则，可以包括流量控制规则、熔断降级规则以及系统保护规则。所有规则可以动态实时调整。
     */
    private static void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource(HELLO_SENTINEL_RESOURCE);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

    /**
     * 通过添加{@link SentinelResource}，helloSentinelResource() 方法就成了我们的一个资源。
     *
     * 资源是 Sentinel 的关键概念。它可以是 Java 应用程序中的任何内容，
     * 例如，由应用程序提供的服务，或由应用程序调用的其它应用提供的服务，甚至可以是一段代码。
     * 只要通过 Sentinel API 定义的代码，就是资源，能够被 Sentinel 保护起来。
     * 大部分情况下，可以使用方法签名，URL，甚至服务名称作为资源名来标示资源。
     *
     * 注意注解支持模块需要配合 Spring AOP 或者 AspectJ 一起使用
     */
    @SentinelResource(HELLO_SENTINEL_RESOURCE)
    public void helloSentinelResource() {
        // 资源中的逻辑
        System.out.println("hello sentinel resource");
    }
}
