package com.imooc.service;

import java.util.List;

import com.imooc.entity.TArea;

public interface TAreaService {

	List<TArea> getAreaList();
	
	TArea getAreaById(int areaId);
	
	boolean addArea(TArea area);
	
	boolean modifyArea(TArea area);
	
	boolean deleteArea(int areaId);
}
