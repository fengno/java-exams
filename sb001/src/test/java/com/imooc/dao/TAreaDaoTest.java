package com.imooc.dao;

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
	public void testQueryAreaById() {
		TArea area = dao.queryAreaById(1);
		Assert.assertEquals("东苑", area.getAreaName());
	}

	@Test
	@Ignore
	public void testInsertArea() {
		TArea area = new TArea();
		area.setAreaName("南苑");
		area.setPriority(1);
		int effectedNm = dao.insertArea(area);
		Assert.assertEquals(1, effectedNm);
	}

	@Test
	@Ignore
	public void testUpdateArea() {
		TArea area = new TArea();
		area.setAreaName("西苑");
		area.setAreaId(3);
		int effectedNm = dao.updateArea(area);
		Assert.assertEquals(1, effectedNm);
		
	}

	@Test
	@Ignore
	public void testDeleteArea() {
		int effectedNm = dao.deleteArea(3);
		Assert.assertEquals(1, effectedNm);
	}

}
