package HA.DocUploadApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class DocUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocUploadApplication.class, args);
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(5242880); // Set the maximum upload size in bytes
		return multipartResolver;
	}
}
