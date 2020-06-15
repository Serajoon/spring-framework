package com.condition;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
    throws BeansException {
    BeanDefinition bd = beanFactory.getBeanDefinition("conditionMain");
    //bean默认是singleton,修改为prototype
    bd.setScope(ConfigurableBeanFactory.SCOPE_PROTOTYPE);
  }
}