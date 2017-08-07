package com.cenyol.example.model.autowire;

import com.cenyol.example.model.autowire.interfaces.CompactDisc;
import com.cenyol.example.model.autowire.interfaces.impl.BlankDisc;
import com.cenyol.example.model.autowire.interfaces.impl.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Cenyol mail: mr.cenyol@gmail.com
 * @date 04/08/2017 21:31
 */
// 自动扫描指定包下面有@Component的类，此处可以指定特定的报名，如果不指定则默认扫描本配置文件所在的包及其子包
// @ComponentScan("com.cenyol.example.model.autowire")

@Configuration
public class CDPlayerConfig {

//     @Bean
//     public CompactDisc getSgtPeppers() {
//         return new SgtPeppers();
//     }

     @Bean
     public CompactDisc getBlankDisc() {
         return new BlankDisc("Sgt. Pepper's Lonely Hearts Club Band", "The Bearleeees");
     }
}
