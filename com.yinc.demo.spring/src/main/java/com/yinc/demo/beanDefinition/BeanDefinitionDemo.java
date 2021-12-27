package com.yinc.demo.beanDefinition;

import com.yinc.demo.mode.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * 注册一个bean
 */
//注解等方式注入
@Import(BeanDefinitionDemo.ComponentDemo.class)
public class BeanDefinitionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //多个不同注解方式注入
        applicationContext.register(BeanDefinitionDemo.class);
        //api方式注入
        registerbeanDefinition(applicationContext, "yinc-user", User.class);
        registerbeanDefinition(applicationContext, null, User.class);
        registerbeanDefinition(applicationContext, null, User.class);

        applicationContext.refresh();

        System.out.println("获取 BeanDefinitionDemo ： " + applicationContext.getBeansOfType(BeanDefinitionDemo.class));
        System.out.println("获取 ComponentDemo ： " + applicationContext.getBeansOfType(ComponentDemo.class));
        System.out.println("获取 user ： " + applicationContext.getBeansOfType(User.class));

    }


    public static void registerbeanDefinition(BeanDefinitionRegistry registry, String beanName, Class<?> beanClass) {
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(beanClass);
        beanDefinitionBuilder.addPropertyValue("name", "yinc帅哥");
        beanDefinitionBuilder.addPropertyValue("age", 18);
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        if (StringUtils.hasText(beanName)) {
            registry.registerBeanDefinition(beanName, beanDefinition);
        } else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
        }

    }


    @Component
    public static class ComponentDemo {
        @Bean
        public User user() {
            User user = new User();
            user.setAge(18);
            user.setName("yinc帅哥");
            return user;
        }
    }


}
