package money.config;

import org.springframework.context.annotation.Bean;

/**
 * @author hanmeng
 * @date 2021.02.19 09:23
 * @since 1.0
 */
public interface DefaultInterface {
	@Bean
	default Object hello() {
		return new Object();
	}
}
