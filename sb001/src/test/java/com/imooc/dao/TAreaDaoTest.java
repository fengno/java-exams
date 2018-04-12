package com.imooc.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imooc.entity.TArea;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TAreaDaoTest {
	@Autowired
	private TAreaDao dao;

	@Test
	public void testQueryArea() {
		List<TArea> list = dao.queryArea();
		Assert.assertEquals(2, list.size());
	}

	@Test
	@Ignore
	public void testQueryAreaById() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testInsertArea() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testUpdateArea() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testDeleteArea() {
		fail("Not yet implemented");
	}

}
