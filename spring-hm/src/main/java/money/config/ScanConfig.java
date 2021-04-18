package money.config;

import money.config.a.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * @author hanmeng
 * @date 2021.01.30 14:08
 * @since 1.0
 */
//@ComponentScan(useDefaultFilters = false,
//		includeFilters = {
//				@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
//		}
//)
//@ComponentScan(useDefaultFilters = false)
@ComponentScan
//@Configuration
//@PropertySource(value = "classpath:app1.properties",ignoreResourceNotFound = true)
//@Import(value = {Student.class})
//@Import(Student.class)
public class ScanConfig{

//	@Autowired
//	Environment env;
//
//	@Bean
//	public Object bBean(){
//		return new Object();
//	}
//
//	@Bean
//	public Object cBean() {
//		return new Object();
//	}
}
