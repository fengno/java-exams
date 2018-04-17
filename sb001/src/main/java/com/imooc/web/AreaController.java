package com.imooc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.imooc.AreaException;
import com.imooc.entity.TArea;
import com.imooc.service.TAreaService;

@RestController
@RequestMapping("/area")
public class AreaController {

	@Autowired
	private TAreaService areaService;
	
	@GetMapping(value= {"/exception"})
	private Object genException() {
		return 1/0;
	}
	
	@GetMapping(value= {"/exception/area"})
	private Object genAreaException() {
		int tmp = 0;
		try {
			tmp = 1/0;
		} catch (Exception e) {
			AreaException ex = new AreaException("area runtime exception test");
			throw ex;
		}
		return tmp;
	}
	
	@GetMapping(value= {"/list"})
	private Map<String, Object> listArea() {
		List<TArea> list = areaService.getAreaList();
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("areaList", list);
		return modelMap;
	}
	
	@GetMapping(value= {"/byid"})
	private Map<String, Object> getAreaById(Integer id) {
		TArea area = areaService.getAreaById(id);
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("area", area);
		return modelMap;
	}
	
	@PostMapping
	private Map<String, Object> addArea(@RequestBody TArea area) {
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("result", areaService.addArea(area));
		return modelMap;
	}
	
	@PostMapping(value= {"/json"})
	private Map<String, Object> addAreaJson(@RequestBody String jsonData) {
		TArea area = JSON.parseObject(jsonData, TArea.class);
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("result", areaService.addArea(area));
		return modelMap;
	}
	
	@PutMapping
	private Map<String, Object> modifyArea(@RequestBody TArea area) {
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("result", areaService.modifyArea(area));
		return modelMap;
	}
	
	@DeleteMapping
	private Map<String, Object> removeArea(Integer id) {
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("result", areaService.deleteArea(id));
		return modelMap;
	}
}
