package com.bjpowernode.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: tianxin
 * @create: 2020-08-15 23:54
 * 一、@ConfigurationProperties 和 @PropertySource、@ImportResource、@Configuration
 * @ConfigurationProperties 将配置文件中配置的每一个属性的值，映射到这个组件中,告诉SpringBoot
 * 将本类中所有的属性和配置文件中的相关配置进行绑定
 * prefix = "person"  指明当前类和配置文件中哪个属性下面的所有属性进行一一映射
 * @Component 只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能，因此需要加上@Component注解
 * @ConfigurationProperties(prefix = "person") 默认从全局配置文件中获取值
 * @PropertySource(value = {"classpath:person.properties"}) 加载指定的配置文件，从指定的配置文件中获取值
 * @ImportResource : 导入Spring的配置文件，让配置文件里面的内容生效
 * SpringBoot里面没有Spring的配置文件，我们自己编写的配置文件也不能被识别，想让配置文件生效并加载进来，就需要@ImportResource注解
 * SpringBoot不用再编写Spring的配置文件，推荐使用全注解的方式进行开发
 * 1、配置类 使用@Configuration表示此类为注解类，例如MyAppConfig，相当于Spring配置文件
 * 2、添加组件 使用@Bean注解向容器中添加组件
 * @Bean 该注解将方法的返回值添加到容器中，容器中这个组件默认的id就是该Service类中对应的方法名
 * 二、@ConfigurationProperties 和 @value
 * @value <bean class ="Person">
 * <properties name = "lastName" value ="字面量 /${key} 从环境变量、配置文件中获取值 /#{SpEl}"></properties>
 * </bean>
 * 区别                 @ConfigurationProperties                        @value
 * 功能                 批量注入配置文件中的属性                           一个个指定
 * 松散语法             支持                                             不支持
 * SpEl                不支持                                           支持
 * JSR303数据校验       支持                                             不支持
 * 复杂类型封装         支持                                             不支持
 * 总结：如果只是在某个业务逻辑中获取一下配置文件中的某个值，使用@value
 * 如果专门编写了一个javaBean来和配置文件进行映射，我们就直接使用@ConfigurationProperties
 */
@PropertySource(value = {"classpath:person.properties"})
@Component
//@ConfigurationProperties(prefix = "person")
//@Validated
public class Person {

    //@Value("${person.last-name}") //写成@Value("${person.lastName}")会报错，因为这里不支持松散绑定
    private String lastName;
    //@Value("#{11*2}")

    private Integer age;
    //@Value("true")
    private Boolean boss;
    //@Value("2020/08/15")
    private Date birthday;
    //@Value("${person.maps}") 不支持复杂类型封装
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birthday=" + birthday +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
