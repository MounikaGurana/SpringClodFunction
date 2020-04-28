package com.tcs.eam;

import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class CloudFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudFunctionApplication.class, args);
//		FunctionCatalog catalog = c.getBean(FunctionCatalog.class);
//		Function<Flux<String>, Flux<String>> func = catalog.lookup("upperCase");
		
	} 
	
	@Bean
	public Function<Flux<String>, Flux<String>> function() {
		return value -> value.map(v -> v.toUpperCase());
	}
	
	@Bean
	public Supplier<Flux<String>> samp(){
		return () -> {
			String v1= String.valueOf(System.nanoTime());
			String v2= String.valueOf(System.nanoTime());
			String v3= String.valueOf(System.nanoTime());
			return Flux.just(v1,v2,v3);
		};
	}
	
}
