package com.cenyol.example.model.autowire;

import org.springframework.context.annotation.ComponentScan;

/**
 * @author Cenyol mail: mr.cenyol@gmail.com
 * @date 04/08/2017 21:31
 */
// 此处可以指定特定的报名，如果不指定则默认扫描本配置文件所在的包及其子包
@ComponentScan("com.cenyol.example.model.autowire")
public class CDPlayerConfig {
}
