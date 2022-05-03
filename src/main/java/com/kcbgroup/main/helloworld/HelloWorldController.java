package com.kcbgroup.main.helloworld;

import org.springframework.web.bind.annotation.*;

//Controller
@RestController //Controller
@RequestMapping("/hello/")
public class HelloWorldController {

	@GetMapping(path = "hello-world", consumes = "application/json")
	public String helloWorld() {
		return "Hello Neph";
	}

	@GetMapping(path = "hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello Neph");
	}

	@GetMapping(path = "hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPath(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello Neph, %s", name));
	}
}
