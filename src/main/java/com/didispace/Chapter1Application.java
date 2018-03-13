package com.didispace;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class Chapter1Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter1Application.class, args);
	}
	
	 //@Bean
	 public EmbeddedServletContainerFactory servletContainerFactory() {
	        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
	            @Override
	            protected void postProcessContext(Context context) {
	                SecurityConstraint securityConstraint = new SecurityConstraint();
	                securityConstraint.setUserConstraint("CONFIDENTIAL");
	                SecurityCollection collection = new SecurityCollection();
	                collection.addPattern("/*");
	                securityConstraint.addCollection(collection);
	                context.addConstraint(securityConstraint);
	            }
	        };
	        tomcat.addAdditionalTomcatConnectors(httpConnector());
	        return tomcat;
	    }

	    //@Bean
	    public Connector httpConnector() {
	        Connector connector=new Connector("org.apache.coyote.http11.Http11NioProtocol");
	        connector.setScheme("http");
	        connector.setPort(8080);
	        connector.setSecure(false);
	        connector.setRedirectPort(8443);
	        return connector;
	    }
	    
	    private CorsConfiguration buildConfig() {  
	        CorsConfiguration corsConfiguration = new CorsConfiguration();  
	        corsConfiguration.addAllowedOrigin("*");  
	        corsConfiguration.addAllowedHeader("*");  
	        corsConfiguration.addAllowedMethod("*");  
	        return corsConfiguration;  
	    }  
	      
	    /** 
	     * 跨域过滤器 
	     * @return 
	     */  
	    @Bean  
	    public CorsFilter corsFilter() {  
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
	        source.registerCorsConfiguration("/**", buildConfig()); // 4  
	        return new CorsFilter(source);  
	    }  

}
