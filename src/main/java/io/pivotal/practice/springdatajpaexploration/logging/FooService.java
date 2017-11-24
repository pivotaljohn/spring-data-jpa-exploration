package io.pivotal.practice.springdatajpaexploration.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FooService {
	@Autowired
	private FooRepository foos;

	public void saveSomething() {
		Foo bar = Foo.builder().name("bar").build();
		foos.save(bar);
	}
}
