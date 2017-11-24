package nju.software.provider.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 
 * @author lr12
 *
 */
@Configuration
@ImportResource(locations={"classpath:spring/dubboProvider.xml"})
public class DubboConfig {

}
