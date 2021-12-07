package com.lamichhane.restfulwebservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class RestfulwebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulwebserviceApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver()
	{
		AcceptHeaderLocaleResolver localeResolver=new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
		
	}
	
	@Bean
	public ResourceBundleMessageSource bundleMessageSource() {
		ResourceBundleMessageSource bundleMessageSource=new ResourceBundleMessageSource();
		bundleMessageSource.addBasenames("messages");
		return bundleMessageSource;
	}
	
	@Bean
	public LinkDiscoverers discoverers() {
	    List<LinkDiscoverer> plugins = new ArrayList<>();
	    plugins.add(new CollectionJsonLinkDiscoverer());
	    return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
	}
	
	

}
