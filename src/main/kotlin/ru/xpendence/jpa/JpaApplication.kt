package ru.xpendence.jpa

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpaApplication

fun main(args: Array<String>) {
	runApplication<JpaApplication>(*args)
}
