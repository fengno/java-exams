package com.imooc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.imooc.AreaRuntimeException;
import com.imooc.entity.TArea;
import com.imooc.service.TAreaService;

@RestController
@RequestMapping("/area")
public class AreaController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private TAreaService areaService;
	
	@GetMapping(value= {"/transaction/arearun"})
	private void testTransactionAreaRuntimeException() {
		areaService.testTransactionAreaRuntimeException();
	}
	
	@GetMapping(value= {"/transaction"})
	private void testTransaction() {
		areaService.testTransaction();
	}
	
	@GetMapping(value= {"/exception"})
	private Object genException() {
		return 1/0;
	}
	
	@GetMapping(value= {"/areaexception"})
	private Object genAreaException() {
		int tmp = 0;
		try {
			tmp = 1/0;
		} catch (Exception e) {
			AreaRuntimeException ex = new AreaRuntimeException("area runtime exception test");
			throw ex;
		}
		return tmp;
	}
	
	@GetMapping(value= {"/list"})
	public Map<String, Object> listArea() {
		logger.info("list area......");
		List<TArea> list = areaService.getAreaList();
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("areaList", list);
		return modelMap;
	}
	
	@GetMapping(value= {"/byid"})
	public String getAreaById(Integer id) {
		logger.info("query area by id......");
		TArea area = areaService.getAreaById(id);
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("area", area);
		return JSON.toJSONString(modelMap);
	}
	
	@PostMapping
	private Map<String, Object> addArea(@RequestBody @Valid TArea area, BindingResult bindingResult) {
		Map<String, Object> modelMap = new HashMap<>();
		if (bindingResult.hasErrors()) {
			modelMap.put("result", false);
			modelMap.put("msg", bindingResult.getFieldError().getDefaultMessage());
		} else {
			modelMap.put("result", areaService.addArea(area));
		}
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
	
	@PostMapping(value="/modify")
	private Map<String, Object> modifyAreaByPost(@RequestBody TArea area) {
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("result", areaService.modifyArea(area));
		return modelMap;
	}
	
	@DeleteMapping(value="/{areaId}")
	private Map<String, Object> removeArea(@PathVariable("areaId") Integer id) {
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("result", areaService.deleteArea(id));
		return modelMap;
	}
	
	@GetMapping(value="/remove")
	private Map<String, Object> removeAreaByGet(Integer id) {
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("result", areaService.deleteArea(id));
		return modelMap;
	}
	
	@PostMapping(value="/remove")
	private Map<String, Object> removeAreaByPost(Integer id) {
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("result", areaService.deleteArea(id));
		return modelMap;
	}
}
