package com.imooc.sb002.service.impl;

import org.springframework.stereotype.Service;

import com.imooc.sb002.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	@Override
	public int count(int param) {
		int count = 0;
		switch (param) {
		case 1:
			count = 11;
			break;
		case 2:
			count = 20;
			break;

		default:
			break;
		}
		return count;
	}

}
