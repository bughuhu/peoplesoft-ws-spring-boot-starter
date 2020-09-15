package net.qihoo.ehr.peoplesoft.ws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.qihoo.ehr.peoplesoft.ws.service.PeopleSoftHttpService;

/**
 * @author Carrot
 * @date 2020/09/14
 * ----------------------------------------------------
 * 版本   描述
 * v1.0   Starter自动配置加载类
 * <p>
 * ----------------------------------------------------
 */
@Configuration
@ConditionalOnClass(PeopleSoftHttpService.class)
@EnableConfigurationProperties(StarterServiceProperties.class)
public class StarterAutoConfigure {

    @Autowired
    private StarterServiceProperties properties;
    
    @Bean
    @ConditionalOnMissingBean
    PeopleSoftHttpService peopleSoftHttpService() {
    	return new PeopleSoftHttpService(properties.getUrl());
    }
}
