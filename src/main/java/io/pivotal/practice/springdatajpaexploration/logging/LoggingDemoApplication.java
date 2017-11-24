package io.pivotal.practice.springdatajpaexploration.logging;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoggingDemoApplication {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(LoggingDemoApplication.class);
		application.setAdditionalProfiles("logging");
		application.run(args);
	}

	@Bean
	CommandLineRunner demoLogging(FooService fooService) {
		return args -> fooService.saveSomething();
	}

	@Bean
	public DefaultPointcutAdvisor traceJpaMethods() {
		CustomizableTraceInterceptor loggingAdvice = new CustomizableTraceInterceptor();
		loggingAdvice.setHideProxyClassNames(true);
		loggingAdvice.setEnterMessage("> $[targetClassShortName].$[methodName]($[arguments])");
		loggingAdvice.setExitMessage("< $[targetClassShortName].$[methodName]() = $[returnValue] (took $[invocationTime]ms.)");
		loggingAdvice.setLoggerName("springdatajpaexploration.jpa");

		AspectJExpressionPointcut jpaMethods = new AspectJExpressionPointcut();
		jpaMethods.setExpression("execution(public * org.springframework.data.jpa.repository.JpaRepository+.*(..))");

		return new DefaultPointcutAdvisor(jpaMethods, loggingAdvice);
	}
}
