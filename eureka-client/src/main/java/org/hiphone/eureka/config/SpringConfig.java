package org.hiphone.eureka.config;

import org.hiphone.eureka.constants.Constant;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author HiPhone
 */
@Component
public class SpringConfig {

    private HttpComponentsClientHttpRequestFactory httpRequestFactory() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setReadTimeout(Constant.TIMEOUT_VALUE);
        httpRequestFactory.setConnectionRequestTimeout(Constant.TIMEOUT_VALUE);
        httpRequestFactory.setConnectTimeout(Constant.TIMEOUT_VALUE);
        return httpRequestFactory;
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(httpRequestFactory());
    }

    @Bean
    @LoadBalanced
    public RestTemplate loadBalanced() {
        return new RestTemplate(httpRequestFactory());
    }
}
