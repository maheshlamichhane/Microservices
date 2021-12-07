package com.lamichhane.restfulwebservice.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
	@Autowired
	private MessageSource bundleMessageSource;
	
	//@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	@GetMapping(path="/hello-world")
	public String handleHelloWorldRequest()
	{
		return "Hello World";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean HelloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping("/hello-world-bean/{name}")
	public HelloWorldBean HelloWorldBeanWithPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello World "+name);
	}
	
	@GetMapping("/good-morning-internatiolization")
	public String GoodMorningWithInternationalization(@RequestHeader(name="Accept-Language")
	Locale locale) {
		return bundleMessageSource.getMessage("good.morning.message",null, locale);
	}

}
