package com.corus_je.corus_je.web;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.json.AbstractJackson2Encoder;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;
import java.util.Optional;

@Configuration
@ComponentScan({"com.corus_je.corus_je"})
@EnableWebMvc
public class webConfig extends WebMvcConfigurerAdapter {
    public webConfig(){
        super();
    }

    @Override
    public void extendMessageConverters(final List<HttpMessageConverter<?>> converters){
        Optional<HttpMessageConverter<?>> converterFound=converters.stream().filter(c -> c instanceof AbstractJackson2HttpMessageConverter).findFirst();
        if(converterFound.isPresent()){
            final AbstractJackson2HttpMessageConverter converter=(AbstractJackson2HttpMessageConverter)converterFound.get();
            converter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            converter.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        }
    }
   //Java Beans Validation on our API Resources
    @Bean
    public javax.validation.Validator localValidatorFactoryBean(){
        return new LocalValidatorFactoryBean();
    }
}
