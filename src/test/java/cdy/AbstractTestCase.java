package cdy;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext.xml" })
public abstract class AbstractTestCase extends AbstractTransactionalJUnit4SpringContextTests 
{
   

    @Before
    public void setUp() throws Exception
    {
        System.out.println("setup");
    }

    @After
    public void tearDown() throws Exception
    {
    }
    
}