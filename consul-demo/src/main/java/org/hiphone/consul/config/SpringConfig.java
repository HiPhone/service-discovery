package org.hiphone.consul.config;

import org.hiphone.consul.constants.Constant;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfig {

    private HttpComponentsClientHttpRequestFactory httpRequestFactory() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setReadTimeout(Constant.TIMEOUT_VALUE);
        httpRequestFactory.setConnectionRequestTimeout(Constant.TIMEOUT_VALUE);
        httpRequestFactory.setConnectTimeout(Constant.TIMEOUT_VALUE);
        return httpRequestFactory;
    }

    @Bean
    @LoadBalanced
    public RestTemplate loadBalanced() {
        return new RestTemplate(httpRequestFactory());
    }

}
