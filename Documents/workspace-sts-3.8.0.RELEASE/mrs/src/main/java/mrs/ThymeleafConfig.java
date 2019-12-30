//-------------------------------------------
//20191228 s.toku
//-------------------------------------------
package mrs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

/**
 * Java8TimeDialectをBean定義するConfigクラスです。
 * 
 * @author shoheitokumaru
 *
 */

@Configuration
public class ThymeleafConfig {
	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}
}
