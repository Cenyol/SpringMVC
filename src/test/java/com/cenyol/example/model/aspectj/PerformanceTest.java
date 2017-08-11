package com.cenyol.example.model.aspectj;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Cenyol mail: mr.cenyol@gmail.com
 * @date 07/08/2017 11:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = ConcertConfig.class)
@ContextConfiguration("classpath:aspectj-beans.xml")
public class PerformanceTest {

    @Autowired
    private Performance performance;

    @Test
    public void testAspectj() {
        Assert.assertNotNull(performance);

        performance.perform();
    }
}
