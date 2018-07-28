package ml.wonwoo.springcondition.config;

import ml.wonwoo.springcondition.sample.Bar;
import ml.wonwoo.springcondition.sample.Foo;
import ml.wonwoo.springcondition.sample.FooService;
import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import static ml.wonwoo.springcondition.config.AnyConfig.AnyCondition;

@Configuration
@Conditional(AnyCondition.class)
public class AnyConfig {

  @Bean
  FooService fooService() {
    return new FooService();
  }

  static class AnyCondition extends AnyNestedCondition {

    public AnyCondition() {
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
