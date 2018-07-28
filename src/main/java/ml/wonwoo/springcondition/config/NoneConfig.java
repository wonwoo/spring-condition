package ml.wonwoo.springcondition.config;

import ml.wonwoo.springcondition.sample.Bar;
import ml.wonwoo.springcondition.sample.Foo;
import ml.wonwoo.springcondition.sample.FooService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.NoneNestedConditions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import static ml.wonwoo.springcondition.config.NoneConfig.NoneCondition;

@Configuration
@Conditional(NoneCondition.class)
public class NoneConfig {

  @Bean
  FooService fooService() {
    return new FooService();
  }

  static class NoneCondition extends NoneNestedConditions {

    public NoneCondition() {
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
