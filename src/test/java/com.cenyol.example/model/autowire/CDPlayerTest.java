package com.cenyol.example.model.autowire;

import com.cenyol.example.model.autowire.interfaces.CompactDisc;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Cenyol mail: mr.cenyol@gmail.com
 * @date 04/08/2017 21:38
 */
@RunWith(SpringJUnit4ClassRunner.class)

// 指定要创建bean的xml文件
//@ContextConfiguration("classpath:config-beans.xml")

// 指定上下文配置文件，在这里就是指定要扫描哪个包下面的bean
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShoudNotBeNull() {
        Assert.assertNotNull(cd);
        cd.play();
    }
}
