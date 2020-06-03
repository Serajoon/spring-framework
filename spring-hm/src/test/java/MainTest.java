import com.lifecycle.LifeCycleMain;
import lombok.Data;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Conditional;

import java.lang.reflect.Field;

public class MainTest {
	@Test
	public void a() throws NoSuchFieldException, IllegalAccessException {
		Person person = new Person();
		Class<? extends Person> aClass = person.getClass();
		Field name = aClass.getDeclaredField("name");
		name.set(person,"aaaaa");
		System.out.println(person);
	}
	@Data
	private static class Person{
		String name;
	}

	@Test
	public void test1(){
		String aaa = BeanFactoryUtils.transformedBeanName("&&aaa");
		System.out.println(aaa);
	}

	@Test
	public void test2(){
		String name = MainTest.class.getName();
		System.out.println(name);
		System.out.println(LifeCycleMain.class.getName());
		System.out.println(LifeCycleMain.class.getSimpleName());
		System.out.println(Conditional.class.getName());
		System.out.println(ApplicationContext.class.getName());
	}
}
