import com.lifecycle.LifeCycleMain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import sun.misc.Unsafe;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.concurrent.RunnableFuture;
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
	public void test4() throws Exception{
		Field age = Person.class.getDeclaredField("age");
		long l = reflectGetUnsafe().objectFieldOffset(age);
		Assert.assertEquals(12L,l);
		AtomicBoolean b = new AtomicBoolean(true);
		boolean b1 = b.compareAndSet(true, false);
		Assert.assertTrue(b1);
		boolean b2 = b.get();
		Assert.assertFalse(b2);
		boolean andSet = b.getAndSet(true);
		Assert.assertFalse(andSet);
		Assert.assertTrue(b.get());
//		b.lazySet();

	}

	@Test
	public void test5() throws Exception{
		Unsafe unsafe = reflectGetUnsafe();
		Person person = new Person("han",12);
		Field nameField = person.getClass().getDeclaredField("name");
		long nameOffset = unsafe.objectFieldOffset(nameField);
		long ageOffset = unsafe.objectFieldOffset(person.getClass().getDeclaredField("age"));
		unsafe.putObject(person,nameOffset,"meng");
//		unsafe.putInt(person,ageOffset,10);
//		unsafe.putIntVolatile(person,ageOffset,10);
		unsafe.putOrderedInt(person,ageOffset,10);
		System.out.println(person);

	}

	private static Unsafe reflectGetUnsafe() {
		try {
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			return (Unsafe) field.get(null);
		} catch (Exception e) {
			return null;
		}
	}
}

@Component
@Resource(name="aaa")
@Controller
@AllArgsConstructor
@ToString
@Data
class Person {
	private String name;
	private int age;

	@Bean
	public String getName() {
		return name;
	}
}
