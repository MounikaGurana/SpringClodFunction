package com.tcs.eam.function;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.servlet.function.ServerResponse;

import com.tcs.eam.model.Student;
import com.tcs.eam.repository.StudentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class StudentGet implements Function<String, Mono<Student>>  {

	
	@Autowired
	StudentRepository repo;
	
	@Override
	public Mono<Student> apply(String n) {
		//Mono<ServerResponse> notFound = ServerResponse.notFound().build();
		Mono<Student> c = repo.findByName(n);
		System.out.println(c.subscribe(c1 -> System.out.println(c1.getName()))
				);
		System.out.println(c.subscribe(c1 -> System.out.println(c1.getId()+ "  "+ c1.getAge())));
		return c;
	}	
	
}
