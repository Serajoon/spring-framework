package money.newbegin;

import junit.framework.TestCase;
import money.config.MyBeanFactoryPostProcessor;
import money.config.ScanConfig;
import money.config.a.Person;
import money.scan.ScanClass;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

/**
 * @author hanmeng
 * @date 2021.01.30 13:55
 * @since 1.0
 */
public class NewMain extends TestCase {

	public void test0() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());
		applicationContext.register(ScanConfig.class);
		applicationContext.refresh();
		String[] allBeans = applicationContext.getBeanDefinitionNames();
		for (String beanName : allBeans) {
			System.out.println(beanName);
		}
	}


	public void test1() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScanClass.class);
		System.out.println("获得所有的bean");
		String[] allBeans = applicationContext.getBeanDefinitionNames();
		for (String beanName : allBeans) {
			System.out.println(beanName);
		}
		System.out.println();
	}

	public void test2() {
		// true：默认TypeFilter生效，这种模式会查询出许多不符合你要求的class名
		// false：关闭默认TypeFilter
		ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
		// 自定义过滤器(这是扫描全部,但不能扫描出接口,原因: 09:25:09.062 [main] DEBUG org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider - Ignored because not a concrete top-level class: file [E:\company\code\git_code\spring-demo\target\classes\com\example\demo\service\IndexService.class])
		TypeFilter includeFilter = (metadataReader, metadataReaderFactory) -> true;
//        provider.addIncludeFilter(includeFilter);
		// Configuration
		provider.addIncludeFilter(new AnnotationTypeFilter(Configuration.class));
		// 扫描IndexService接口的实现类,(接口不会被扫描出来,原因同上)
//        provider.addIncludeFilter(new AssignableTypeFilter(IndexService.class));
		// 指定扫描的包名
		Set<BeanDefinition> candidateComponents = provider.findCandidateComponents("com.serajoon");
		candidateComponents.forEach(beanDefinition -> {
			GenericBeanDefinition definition = (GenericBeanDefinition) beanDefinition;
			System.out.println(definition.getBeanClassName());
			//com.example.demo.configuration.MyValidator
			//com.example.demo.configuration.ThreadConfiguration
			//com.example.demo.configuration.WebMvcConfiguration
			//com.example.demo.controller.IndexController
			//com.example.demo.service.impl.IndexServiceImpl
		});

	}

	public void test3() throws Exception {
		Set<BeanDefinition> candidates = new LinkedHashSet<>();
		PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		//读取classpath相关路径下的类
		Resource[] resources = resourcePatternResolver.getResources("classpath*:money/config/*.class");
		SimpleMetadataReaderFactory factory = new SimpleMetadataReaderFactory();
		for (Resource resource : resources) {
			MetadataReader metadataReader = factory.getMetadataReader(resource);
			ScannedGenericBeanDefinition sbd = new ScannedGenericBeanDefinition(metadataReader);
			sbd.setResource(resource);
			sbd.setSource(resource);
			candidates.add(sbd);
		}
		//遍历BeanDefinition,找到有相关注解的类
		for (BeanDefinition beanDefinition : candidates) {
			String classname = beanDefinition.getBeanClassName();
			Controller controller = Class.forName(classname).getAnnotation(Controller.class);
			Service service = Class.forName(classname).getAnnotation(Service.class);
			Component component = Class.forName(classname).getAnnotation(Component.class);
			//是否含有@Controller @Service @Component注解
			if (controller != null || service != null || component != null) {
				System.out.println(classname);
			}
		}
	}

	public void test5() {
		StandardEnvironment standardEnvironment = new StandardEnvironment();
		String java_home = standardEnvironment.getProperty("java.version");
		System.out.println(java_home);
	}

	public void test6() {
		StandardAnnotationMetadata metadata = new StandardAnnotationMetadata(ScanConfig.class);
	}


}
