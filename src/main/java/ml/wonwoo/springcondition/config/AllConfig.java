package ml.wonwoo.springcondition.config;

import ml.wonwoo.springcondition.sample.Bar;
import ml.wonwoo.springcondition.sample.Foo;
import ml.wonwoo.springcondition.sample.FooService;
import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import static ml.wonwoo.springcondition.config.AllConfig.AllCondition;

@Configuration
@Conditional(AllCondition.class)
public class AllConfig {

  @Bean
  FooService fooService() {
    return new FooService();
  }

  static class AllCondition extends AllNestedConditions {

    public AllCondition() {
      super(ConfigurationPhase.REGISTER_BEAN);
    }

    @ConditionalOnBean(Foo.class)
    static class FooCondition {

    }

    @ConditionalOnBean(Bar.class)
    static class BarCondition {

    }
  }
}
