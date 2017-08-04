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
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShoudNotBeNull() {
        Assert.assertNotNull(cd);
    }
}
