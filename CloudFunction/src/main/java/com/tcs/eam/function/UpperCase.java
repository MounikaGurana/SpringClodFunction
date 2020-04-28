package com.tcs.eam.function;

import java.util.function.Function;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UpperCase implements Function<String, Flux<String>> {

	@Override
	public Flux<String> apply(String v) {
		// TODO Auto-generated method stub
		System.out.println(v.toUpperCase());
		return Flux.just(v.toUpperCase());
	}

}
