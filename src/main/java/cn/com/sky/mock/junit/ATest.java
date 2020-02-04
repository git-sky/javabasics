package cn.com.sky.mock.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ATest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("setUpBeforeClass..............");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("tearDownAfterClass.................");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp........");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown............");
    }

    @Test
    public void testGetPlanDetail() {
        System.out.println("testGetPlanDetail.........1");
    }

    @Test
    public void test1() {
        fail("Not yet implemented");
    }

    @Ignore
    public void test2() {
        fail("Not yet implemented");
    }

}
