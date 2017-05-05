package com.zuzu.ng2boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(
        basePackageClasses = {Ng2bootApplication.class, Jsr310JpaConverters.class}

)
@SpringBootApplication
public class Ng2bootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ng2bootApplication.class, args);
	}
}
