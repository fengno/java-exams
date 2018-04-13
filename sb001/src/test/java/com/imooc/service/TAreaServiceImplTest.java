package com.imooc.service;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
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
public class TAreaServiceImplTest {
	@Autowired
	private TAreaService service;

	@Test
	public void testGetAreaList() {
		List<TArea> list = service.getAreaList();
		Assert.assertNotNull(list);
		for (TArea item : list) {
			System.out.println(ReflectionToStringBuilder.toString(item, ToStringStyle.MULTI_LINE_STYLE));
		}
	}

	@Test
	public void testGetAreaById() {
		TArea area = service.getAreaById(1);
		Assert.assertNotNull(area);
		System.out.println(ReflectionToStringBuilder.toString(area, ToStringStyle.MULTI_LINE_STYLE));
	}

	@Test
	@Ignore
	public void testAddArea() {
		TArea area = new TArea();
		area.setAreaName("test area");
		area.setPriority(2);
		boolean result = service.addArea(area );
		Assert.assertTrue(result);
//		testGetAreaList();
	}

	@Test
	@Ignore
	public void testModifyArea() {
		TArea area = service.getAreaById(1);
		System.out.println(ReflectionToStringBuilder.toString(area, ToStringStyle.MULTI_LINE_STYLE));
		String oldName = area.getAreaName();
		area.setAreaName("new name");
		boolean result = service.modifyArea(area);
		Assert.assertTrue(result);
		area = service.getAreaById(1);
		System.out.println(ReflectionToStringBuilder.toString(area, ToStringStyle.MULTI_LINE_STYLE));
		area.setAreaName(oldName);
		service.modifyArea(area);
	}

	@Test
	@Ignore
	public void testDeleteArea() {
		boolean result = service.deleteArea(4);
		Assert.assertTrue(result);
	}

}
