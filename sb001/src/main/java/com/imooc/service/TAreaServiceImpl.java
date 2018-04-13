package com.imooc.service;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.dao.TAreaDao;
import com.imooc.entity.TArea;

@Service
public class TAreaServiceImpl implements TAreaService {
	@Autowired
	private TAreaDao areaDao;

	@Override
	public List<TArea> getAreaList() {
		return areaDao.queryArea();
	}

	@Override
	public TArea getAreaById(int areaId) {
		return areaDao.queryAreaById(areaId);
	}

	@Override
	@Transactional//通过rollbackFor指定针对哪些异常进行回滚，默认是RuntimeException(rollbackFor=Exception.class)
	public boolean addArea(TArea area) {
		if (null != area && StringUtils.isNotEmpty(area.getAreaName())) {
			area.setCreateTime(Calendar.getInstance().getTime());
			area.setLastEditTime(area.getCreateTime());
			try {
				int effectedNum = areaDao.insertArea(area);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("插入区域信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("插入区域信息失败:" + e.getMessage());
			}
		} else {
			throw new RuntimeException("区域信息不能为空！");
		}
	}

	@Override
	@Transactional
	public boolean modifyArea(TArea area) {
		if (null != area && area.getAreaId() > 0) {
			area.setLastEditTime(Calendar.getInstance().getTime());
			try {
				int effectedNum = areaDao.updateArea(area);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("更新区域信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("更新区域信息失败:" + e.getMessage());
			}
		} else {
			throw new RuntimeException("区域信息不能为空！");
		}
	}

	@Override
	public boolean deleteArea(int areaId) {
		if (areaId > 0) {
			try {
				int effectedNum = areaDao.deleteArea(areaId);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("删除区域信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("删除区域信息失败:" + e.getMessage());
			}
		} else {
			throw new RuntimeException("区域Id不能为空！");
		}
	}

}
