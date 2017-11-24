package io.pivotal.practice.springdatajpaexploration.logging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder()
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Slf4j
public class Foo {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
}
