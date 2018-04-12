package com.imooc.dao;

import java.util.List;

import com.imooc.entity.TArea;


public interface TAreaDao {

	List<TArea> queryArea();

	TArea queryAreaById(int areaId);

	int insertArea(TArea area);

	int updateArea(TArea area);

	int deleteArea(int areaId);
}
