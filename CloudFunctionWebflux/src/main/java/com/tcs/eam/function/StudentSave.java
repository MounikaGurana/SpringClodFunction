package com.tcs.eam.function;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import com.tcs.eam.model.Student;
import com.tcs.eam.repository.StudentRepository;
import reactor.core.publisher.Mono;

public class StudentSave implements Function<Student, Mono<Student>> {
	
	@Autowired
	StudentRepository repo;
	
	@Override
	public Mono<Student> apply(Student req) {
		System.out.println(req.getId());
		System.out.println(req.getName());
		Student st = repo.save(req).block();
	//	Mono<Student> s = repo.save(req);
		return Mono.just(st);
	}	
	
}
