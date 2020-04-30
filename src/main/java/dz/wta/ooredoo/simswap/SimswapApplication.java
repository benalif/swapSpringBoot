package dz.wta.ooredoo.simswap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages= {"dz.wta.ooredoo.simswap.*"})
@EnableJpaRepositories(basePackages="dz.wta.ooredoo.simswap.repository")
@EntityScan("dz.wta.ooredoo.simswap.entity")
@SpringBootApplication
public class SimswapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimswapApplication.class, args);
	}

}
