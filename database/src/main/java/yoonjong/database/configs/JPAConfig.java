package yoonjong.database.configs;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("yoonjong.database.repositories")
@EntityScan("yoonjong.database.entities")
public class JPAConfig {
}
