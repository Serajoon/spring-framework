import com.condition.ConditionMain;
import com.lifecycle.LifeCycleMain;
import com.serajoon.ClassTest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.BeanMetadataAttribute;
import org.springframework.beans.BeanMetadataAttributeAccessor;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.core.type.StandardClassMetadata;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainTest {

	@Test
	public void test1() {
		String aaa = BeanFactoryUtils.transformedBeanName("&&aaa");
		System.out.println(aaa);
	}

	@Test
	public void test2() {
		String name = MainTest.class.getName();
		System.out.println(name);
		System.out.println(LifeCycleMain.class.getName());
		System.out.println(LifeCycleMain.class.getSimpleName());
		System.out.println(Conditional.class.getName());
		System.out.println(ApplicationContext.class.getName());
	}

	@Test
	public void test3() {
		StandardAnnotationMetadata sm = new StandardAnnotationMetadata(Person.class);
		Set<String> annotationTypes = sm.getAnnotationTypes();
		Set<String> metaAnnotationTypes = sm.getMetaAnnotationTypes("org.springframework.stereotype.Controller");
		boolean b = sm.hasAnnotatedMethods("org.springframework.stereotype.Controller");
		boolean annotated = sm.isAnnotated("org.springframework.context.annotation.Configuration");
		System.out.println(1);
	}

	@Test
	public void test4(){
		AtomicBoolean active = new AtomicBoolean();
		System.out.println(active.get());
	}
}

@Component
@Resource(name="aaa")
@Controller
class Person {
	private String name;

	@Bean
	public String getName() {
		return name;
	}
}
