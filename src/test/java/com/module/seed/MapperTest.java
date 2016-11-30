package com.module.seed;

import com.module.seed.mapper.FloorMapper;
import com.module.seed.model.Floor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@ActiveProfiles("local")
public class MapperTest {

    @Autowired
    private FloorMapper floorMapper;


    private static final Logger logger = LoggerFactory.getLogger(ApplicationTest.class);

    @Before
    public void before() {
        logger.debug("do some thing before test here...");
    }

    @Test
    public void testBaseCRUD() {
        // test delete
        Floor floor = floorMapper.selectByPrimaryKey(1L);
        logger.debug("find by name result is:{}", floor.getName());
    }

    @After
    public void after() {
        logger.debug("do some thing after test here...");
    }

}
