package com.imooc.sb002.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.imooc.sb002.Sb002Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Sb002Application.class})
@WebAppConfiguration // 支持Web项目
public class DemoServiceImplTest {
	@Autowired
	private DemoService service;

	@Test
	public void testCount() {
		Assert.assertArrayEquals(new Object[] {
				11,
				20,
				0
		}, new Object[] {
				service.count(1),
				service.count(2),
				service.count(3)
		});
	}

}
