package com.lamichhane.restfulwebservice.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping("/filtering")
public class FilteringController
{
	@GetMapping("/retrieve-singlebean")
	public MappingJacksonValue retriveSecurityBean()
	{
		SecurityBean securitybean=new SecurityBean("1","Mahesh","mahesh3434");
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("id","username");
		FilterProvider  filters=new SimpleFilterProvider().addFilter("SecurityBeanFilter", filter);
		MappingJacksonValue mapping=new MappingJacksonValue(securitybean);
		mapping.setFilters(filters);
		return mapping;
   }
	
	@GetMapping("/retrieve-listbean")
	public MappingJacksonValue retriveListOfSecurityBean()
	{
		List<SecurityBean> list= Arrays.asList(new SecurityBean("1","Mahesh","mahesh3434"),new SecurityBean("2","Akash","akash89"));
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("id");
		FilterProvider  filters=new SimpleFilterProvider().addFilter("SecurityBeanFilter", filter);
		MappingJacksonValue mapping=new MappingJacksonValue(list);
		mapping.setFilters(filters);
		return mapping;
	}

}
