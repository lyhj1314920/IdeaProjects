package com.bjpowernode.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @SpringBootApplication SpringBoot应用，注解在某个类上，表示这个类是Spring Boot的主配置类，
 * SpringBoot通过运行这个类的main方法来启动springboot应用
 * @SpringBootConfiguration SpringBoot配置类，注解在某个类上，表示这个类是SpringBoot的配置类
 *  @Configuration Spring配置类，表示这个类是一个配置类，类的作用和配置文件相同，
 *  配置类也是容器中的组件，类名上有Spring的@Component注解
 * @EnableAutoConfiguration SpringBoot开启自动配置功能 SpringBoot在启动时会从类路径下的META-INF\spring.factories中
 * 获取EnableAutoConfiguration指定的值，并将这些值作为自动配置类导入到容器中，自动配置类就会生效，帮助我们进行自动配置工作。
 * J2EE的整体整合解决方案和自动配置都在C:\mavenRepository\org\springframework\boot\spring-boot-autoconfigure\2.3.2.RELEASE
 * \spring-boot-autoconfigure-2.3.2.RELEASE.jar中
 *  @AutoConfigurationPackage 自动配置包 将主配置类（@SpringBootApplication注解的类）所在的包以及下面所有
 *  子包中所有的组件扫描到Spring容器中
 *      @Import(AutoConfigurationPackages.Registrar.class) 通过Spring的底层注解@Import，给容器中导入组件
 *      AutoConfigurationPackages.Registrar.class，通过其中的registerBeanDefinitions方法获取主配置类
 *      （@SpringBootApplication注解的类）所在的路径，再由@AutoConfigurationPackage将主配置类（@SpringBootApplication
 *      注解的类）所在的包以及下面所有子包中所有的组件扫描到Spring容器中
 *  @Import(AutoConfigurationImportSelector.class) 自动配置类导入选择器，选择当前场景所有需要导入的自动配置组件（自动配置类），
 *  并配置好这些组件，将全部的这些组件以全类名的方式返回，然后这些组件就会被添加到容器中了
 *  @ImportResource(locations = {"classpath:beans.xml"}) 导入Spring的配置文件，让配置
 */

@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
public class FirstSpringbootApplication {

    public static void main(String[] args) {
        //启动了springboot程序，启动了spring容器，启动了内嵌的tomcat
        SpringApplication.run(FirstSpringbootApplication.class, args);
    }

}
