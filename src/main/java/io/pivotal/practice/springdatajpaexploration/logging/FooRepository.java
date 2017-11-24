package io.pivotal.practice.springdatajpaexploration.logging;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FooRepository extends JpaRepository<Foo, Long> {
}
