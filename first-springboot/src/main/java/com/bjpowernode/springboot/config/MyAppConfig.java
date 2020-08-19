package com.bjpowernode.springboot.config;

import com.bjpowernode.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.events.Event;

/**
 * @author: tianxin
 * @create: 2020-08-17 18:58
 * @Configuration 指明当前类是一个配置类，替代之前的Spring配置文件
 * 配置文件中使用Bean标签进行配置，配置类中使用与之对应的@Bean注解
 */
@Configuration
public class MyAppConfig {

    //将方法的返回值添加到容器中，容器中这个组件默认的id就是该Service类中对应的方法名
    @Bean
    public HelloService helloService() {
        return new HelloService();

    }
/**
 * Spring Boot配置
 *
 * 1、配置文件
 *  application.properties或者application.yml
 *  application.yml配置文件中获取javaBean类中的属性
 * 	* 将配置文件中配置的每一个属性的值，映射到这个组件中  导入配置文件处理器，配置文件进行绑定之后就会有提示
 * 	* @ConfigurationProperties 告诉SpringBoot将本类中所有的属性和配置文件中的相关配置进行绑定
 * 	*      prefix = "person"  指明当前类和配置文件中哪个属性下面的所有属性进行一一映射
 * 	* @Component 告诉SpringBoot本类是容器的组件，只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能
 *  * SpringBoot单元测试
 *  * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 *
 * 2、YAML基本语法
 *
 * 3、配置文件值注入
 * 	1、@ConfigurationProperties 和 @PropertySource、@ImportResource
 * 	2、@ConfigurationProperties和@value
 * 	3、@validate
 *
 * 4、配置文件占位符
 *
 * 5、Profile
 * 	1、多Profile文件
 * 	2、yml支持多文档块方式 spring.profiles.active激活文档块之后，整个文档块的配置都会生效
 * 	3、激活指定profile spring.profiles.active=dev
 *
 * 6、配置文件加载位置
 * 	SpringBoot启动会扫描一下位置下的applicatio.properties或者application.yml文件作为SpringBoot的默认配置文件
 * 	-file: 		./config/
 * 	-file: 		./
 * 	-classpath:	./config/
 * 	-classpath:	./
 * 	优先级从高到低，高优先级的配置会覆盖低优先级的配置
 * 	互补配置：
 *
 *
 * 	我们还可以通过spring.config.Location来改变默认的配置文件的位置。在项目打包好以后，我们可
 * 	以使用命令行参数的形式，启动项目的时候，来指定配置文件的新位置
 * 	指定的配置文件和默认加载的这些配置文件会共同起作用，形成互补配置
 *
 * 7、外部配置加载顺序
 * 	SpringBoot也可以从以下位置加载配置，优先级从高到低，高优先级的配置会覆盖低优先级的配置，所有的配置都会形成互不配置
 * 	1、命令行配置 多个配置用空格隔开   --配置项=值
 * 	2、来自java：comp/env的NDI属性
 * 	3、java系统属性
 * 	4、操作系统环境变量
 * 	5、RandomValuePropertiesSource配置的random.*属性
 *
 * 	优先加载带profile的，由jar包外像jar包内进行寻找
 * 	6、jar包外部的application-{profile}.properties或application.yml(带spring.profile)配置文件
 * 	7、jar包内部的application-{profile}.properties或application.yml(带spring.profile)配置文件
 * 	再来加载不带profile的
 * 	8、jar包外部的application.properties或application.yml(不带spring.profile)配置文件
 * 	9、jar包内部的application.properties或application.yml(不带spring.profile)配置文件
 *
 * 	10、@Configuration注解类上的PropertySource
 * 	11、通过SpringApplication.setDefaultProperties指定的默认属性
 *
 * 8、自动配置原理
 * 8、1 自动配置原理
 *  1、SpringBoot启动的时候加载主配置类，开启自动配置功能@EnableAutoConfiguration
 *  2、@EnableAutoConfiguration 将类路径下 META-INF/spring.factories 文件中配置的所有EnableAutoConfiguration添加入容器中
 *      利用AutoConfigurationImportSelector类中的selectImports方法，selectImports方法调用getAutoConfigurationEntry方法
 *      protected AutoConfigurationEntry getAutoConfigurationEntry(AnnotationMetadata annotationMetadata) {
 * 		if (!isEnabled(annotationMetadata)) {
 * 			return EMPTY_ENTRY;
 *                }
 * 		AnnotationAttributes attributes = getAttributes(annotationMetadata);
 *
 *
 *      //获取候选的配置
 * 		List<String> configurations = getCandidateConfigurations(annotationMetadata, attributes);
 *
 *
 * 		configurations = removeDuplicates(configurations);
 * 		Set<String> exclusions = getExclusions(annotationMetadata, attributes);
 * 		checkExcludedClasses(configurations, exclusions);
 * 		configurations.removeAll(exclusions);
 * 		configurations = getConfigurationClassFilter().filter(configurations);
 * 		fireAutoConfigurationImportEvents(configurations, exclusions);
 * 		return new AutoConfigurationEntry(configurations, exclusions);* 	}
 *
 * 	  protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
 * 		List<String> configurations = SpringFactoriesLoader.loadFactoryNames(getSpringFactoriesLoaderFactoryClass(),
 * 				getBeanClassLoader());
 * 		Assert.notEmpty(configurations, "No auto configuration classes found in META-INF/spring.factories. If you "
 * 				+ "are using a custom packaging, make sure that file is correct.");
 * 		return configurations;
 *    }
 *
 *    public static List<String> loadFactoryNames(Class<?> factoryType, @Nullable ClassLoader classLoader) {
 * 		String factoryTypeName = factoryType.getName();
 * 		return loadSpringFactories(classLoader).getOrDefault(factoryTypeName, Collections.emptyList());
 *    }
 *
 *    扫描所有类路径下的META-INF/spring.factories
 *    public static final String FACTORIES_RESOURCE_LOCATION = "META-INF/spring.factories";
 *
 *    吧扫描到的这些文件内容包装成properties对象
 *    Properties properties = PropertiesLoaderUtils.loadProperties(resource);
 *
 *    从properties中获取EnableAutoConfiguration.class对应的值，然后把他们添加到容器中
 *    protected Class<?> getSpringFactoriesLoaderFactoryClass() {
 * 		return EnableAutoConfiguration.class;
 *    }
 *  3、每个自动配置类EnableAutoConfiguration.class进行自动配置功能
 *  4、以HttpHandlerAutoConfiguration为例解释自动配置原理
 *      @Configuration(proxyBeanMethods = false)    表示这是一个配置类
 *      @ConditionalOnClass({ DispatcherHandler.class, HttpHandler.class })     判断当前项目中有没有这个类
 *      @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)      Spring底层的@Conditional注解
 *      ，根据不同的条件，如果满足指定的条件，整个配置类里面的配置就会生效。此处为判断当前应用是否为web应用，如果是，当前配置类生效
 *      @ConditionalOnMissingBean(HttpHandler.class)
 *      @AutoConfigureAfter({ WebFluxAutoConfiguration.class })
 *      @AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
 *      public class HttpHandlerAutoConfiguration {
 *
 *      根据当前不通的条件判断，决定这个配置类是否生效，一旦这个配置类生效，这个配置类就会向容器中添加各种组件，
 *      这些组件的属性是从对应的properties类中获取的，这些类里面的每一个属性又都是和配置文件绑定的。
 *      @Bean
 *      public HttpHandler httpHandler(ObjectProvider<WebFluxProperties> propsProvider) {
 * 			HttpHandler httpHandler = WebHttpHandlerBuilder.applicationContext(this.applicationContext).build();
 * 			WebFluxProperties properties = propsProvider.getIfAvailable();
 * 			if (properties != null && StringUtils.hasText(properties.getBasePath())) {
 * 				Map<String, HttpHandler> handlersMap = Collections.singletonMap(properties.getBasePath(), httpHandler);
 * 				return new ContextPathCompositeHandler(handlersMap);
 *            }
 * 			return httpHandler;
 *      }
 *  5、所有在配置文件中配置的属性都是在对应的XXXProperties类中封装着，配置文件能配置什么就可以参照某个功能对应的属性类进行配置
 *
 *  SpringBoot精髓：
 *  1、SpringBoot启动会加载大量的自动配置类
 *  2、判断我们需要的功能有没有SpringBoot默认写好的自动配置类
 *  3、再来看这个自动配置类中到底配置了那些组件（只要有我们用的组件，就不需要我们再进行配置）
 *  4、给容器中自动添加配置类的时候，会从对应的properties类中获取某些属性，我们就可以在配置文件中指定这些属性的值
 *
 *  XXXAutoConfiguration ：自动配置类
 *  向容器中添加组件
 *  XXXProperties：封装配置文件中的相关属性
 *
 * 8、2 自动配置细节
 *  1、@Conditional派生注解（详情可查看Spring注解版原生的@Conditional注解）
 *  作用：必须是@Conditional指定的条件成立，才会给容器添加组件，配置类里面配置的内容才会生效
 *  @Conditional派生注解扩展
 *  自动配置类必须在一定的条件下才会生效
 *  那我们怎么知道哪些自动配置类生效了呢？  可以通过启用 debug = true 属性，来让控制台打印自动配置报告（已启用、未启用）
 */

/**
 * 日志
 * 1、日志框架
 * SpringBoot：底层是Spring框架，Spring框架默认使用JCL
 * SpringBoot选用SLF4j和logback
 * 2、SLF4j使用
 *  1、如何在系统中使用SLF4j
 *  以后开发的时候，日志记录方法的调用，不应该来直接调用日志的实现类，而是调用日志抽象层里面的方法
 * import org.slf4j.Logger;
 * import org.slf4j.LoggerFactory;
 *
 * public class HelloWorld {
 *   public static void main(String[] args) {
 *     Logger logger = LoggerFactory.getLogger(HelloWorld.class);
 *     logger.info("Hello World");
 *   }
 * }
 * 每一个日志的实现框架都有自己的配置文件，使用slf4j以后，配置文件还是做成实现日志框架自身的配置文件
 *  2、遗留问题
 *      统一日志记录，即使是别的框架也和我一起统一使用slf4j进行输出
 *      如何让系统中所有的日志框架统一使用slf4j进行输出？
 *      1、将系统中的其他日志框架先排除出去
 *      2、用中间包来替换原有的日志框架
 *      3、导入slf4j的实现
 *  3、SpringBoot日志关系
 *      总结：1、SpringBoot底层也是使用slf4j+logback的方式进行日志记录
 *           2、SpringBoot也把其他的日志都替换成了slf4j
 *           3、中间替换包
 *           4、如果我们要引入其他框架，一定要把这个框架的默认日志的依赖移除掉
 *           Spring框架使用的是commons-logging，在spring-boot-starter的pom文件中已经将它的依赖移除掉了
 *      SpringBoot能自动适配所有的日志，而且底层使用slf4j+logback的方式记录日志，引入其他框架的时候，
 *      只要要把这个框架依赖的日志框架排除掉即可。
 *  4、日志使用
 *      1、默认配置
 *  //记录器
 * 	Logger logger = LoggerFactory.getLogger(getClass());
 *        @Test
 *    public void contextLoads() {
 * 		//System.out.println();
 *
 * 		//日志的级别；
 * 		//由低到高   trace<debug<info<warn<error
 * 		//可以调整输出的日志级别；日志就只会在这个级别以以后的高级别生效
 * 		logger.trace("这是trace日志...");
 * 		logger.debug("这是debug日志...");
 * 		//SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root级别
 * 		logger.info("这是info日志...");
 * 		logger.warn("这是warn日志...");
 * 		logger.error("这是error日志...");
 *
 *
 *    }
 *
 *    日志输出格式：
 * 		%d表示日期时间，
 * 		%thread表示线程名，
 * 		%-5level：级别从左显示5个字符宽度
 * 		%logger{50} 表示logger名字最长50个字符，否则按照句点分割。
 * 		%msg：日志消息，
 * 		%n是换行符
 *     -->
 *     %d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n
 *
 *     SpringBoot修改日志的默认配置
 *     logging.level.com.atguigu=trace
 *     #logging.path=
 *     # 不指定路径在当前项目下生成springboot.log日志
 *     # 可以指定完整的路径；
 *     #logging.file=G:/springboot.log
 *     # 在当前磁盘的根路径下创建spring文件夹和里面的log文件夹；使用 spring.log 作为默认文件
 *     logging.path=/spring/log
 *     #  在控制台输出的日志的格式
 *     logging.pattern.console=%d{yyyy-MM-dd} [%thread] %-5level %logger{50} - %msg%n
 *     # 指定文件中日志输出的格式
 *     logging.pattern.file=%d{yyyy-MM-dd} === [%thread] === %-5level === %logger{50} ==== %msg%n
 *
 *     2、指定配置
 *     给类路径下放上每个日志框架自己的配置文件即可；SpringBoot就不使用他默认配置的了
 *     logback.xml：直接就被日志框架识别了；
 *     logback-spring.xml：日志框架无法识别此配置文件，就不直接加载日志的配置项，由SpringBoot解析日志配置，
 *     可以使用SpringBoot的高级Profile功能
 *     <springProfile name="staging">
 *     <!-- configuration to be enabled when the "staging" profile is active -->
 *   	可以指定某段配置只在某个环境下生效
 *      </springProfile>
 *
 *      <appender name="stdout" class="ch.qos.logback.core.ConsoleAppender">
 *         <!--
 *         日志输出格式：
 * 			%d表示日期时间，
 * 			%thread表示线程名，
 * 			%-5level：级别从左显示5个字符宽度
 * 			%logger{50} 表示logger名字最长50个字符，否则按照句点分割。
 * 			%msg：日志消息，
 * 			%n是换行符
 *         -->
 *         <layout class="ch.qos.logback.classic.PatternLayout">
 *             <springProfile name="dev">
 *                 <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} ----> [%thread] ---> %-5level %logger{50} - %msg%n</pattern>
 *             </springProfile>
 *             <springProfile name="!dev">
 *                 <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} ==== [%thread] ==== %-5level %logger{50} - %msg%n</pattern>
 *             </springProfile>
 *         </layout>
 *     </appender>
 *
 *     如果使用logback.xml作为日志配置文件，还要使用profile功能，会有以下错误：
 *          no applicable action for [springProfile]`
 *
 * 5、切换日志框架
 *      切换为log4j2：
 *    <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-starter-web</artifactId>
 *             <exclusions>
 *                 <exclusion>
 *                     <artifactId>spring-boot-starter-logging</artifactId>
 *                     <groupId>org.springframework.boot</groupId>
 *                 </exclusion>
 *             </exclusions>
 *         </dependency>
 *
 * <dependency>
 *   <groupId>org.springframework.boot</groupId>
 *   <artifactId>spring-boot-starter-log4j2</artifactId>
 * </dependency>
 */
}
