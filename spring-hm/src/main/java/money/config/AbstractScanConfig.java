package money.config;

import org.springframework.context.annotation.Bean;

/**
 * @author hanmeng
 * @date 2021.02.19 06:40
 * @since 1.0
 */
public abstract class AbstractScanConfig {
	@Bean
	public Object aBean(){
		return new Object();
	}
}
