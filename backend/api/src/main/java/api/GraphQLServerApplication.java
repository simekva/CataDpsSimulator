package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "items")
@EntityScan(basePackages = "items")
public class GraphQLServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQLServerApplication.class, args);
    }
}
