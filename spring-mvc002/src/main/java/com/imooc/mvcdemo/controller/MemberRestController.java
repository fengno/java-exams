package com.imooc.mvcdemo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.mvcdemo.model.Member;

@Controller
@RequestMapping("/rest/members")
public class MemberRestController
{

	// 无参
    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Member> listAllMembers()
    {
    	List<Member> list = new ArrayList<>();
    	Member member = new Member(1L, "张三", "abc@123.com", "13987654321");
    	list.add(member);
    	member = new Member(2L, "张三", "abc@123.com", "13987654321");
    	list.add(member);
        return list;
    }

    // 路径参数
    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody Member lookupMemberById(@PathVariable("id") Long id)
    {
    	Member member = new Member(id, "张三", "abc@123.com", "13987654321");
        return member;
    }
    
    // 查询参数
    @RequestMapping(value="/id", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody Member lookupMemberById002(@RequestParam("id") Long id)
    {
    	Member member = new Member(id, "张三", "abc@123.com", "13987654321");
    	return member;
    }
    
    // 请求体自动转成对象
    @RequestMapping(method=RequestMethod.POST, consumes="application/json", produces="application/json")
    // 请求体采用json格式，各属性名称与Member类的个属性名称对应
    public @ResponseBody Object addMember(@RequestBody Member member)
    {
    	System.out.println(ReflectionToStringBuilder.toString(member, ToStringStyle.MULTI_LINE_STYLE));
    	Map<String, Object> map = new HashMap<>();
    	map.put("code", "2000");
    	map.put("message", "添加成功");
    	map.put("data", member);
    	return map;
    }
    
    // 请求体是字符串
    @RequestMapping(
    		value="/json", 
    		method=RequestMethod.POST, 
    		consumes= {"application/json", "application/xml"}, 
    		produces="application/json")
    public @ResponseBody Object addMemberWithJsonStr(@RequestBody String data)
    {
    	System.out.println(data);
    	Map<String, String> map = new HashMap<>();
    	map.put("data", data);
    	map.put("code", "2000");
    	map.put("message", "添加成功");
    	return map;
    }
    
    // 参数格式 application/x-www-form-urlencoded
    @RequestMapping(value="/form", method=RequestMethod.POST, 
    		consumes= {"application/x-www-form-urlencoded"},
    		produces="application/json")
    public @ResponseBody Object addMemberWithForm(String name, Integer pageSize, Integer pageNo)
    {
    	Map<String, Object> map = new HashMap<>();
    	map.put("name", name);
    	map.put("pageSize", pageSize);
    	map.put("pageNo", pageNo);
    	map.put("code", "2000");
    	map.put("message", "添加成功");
    	return map;
    }
    
	// 参数格式 multipart/form-data
    @RequestMapping(value="/multipart", method=RequestMethod.POST, 
    		consumes= {"multipart/form-data"},
    		produces="application/json")
    public @ResponseBody Object addMemberWithMultipart(String name, Integer pageSize, Integer pageNo)
    {
    	Map<String, Object> map = new HashMap<>();
    	map.put("name", name);
    	map.put("pageSize", pageSize);
    	map.put("pageNo", pageNo);
    	map.put("code", "2000");
    	map.put("message", "添加成功");
    	return map;
    }    
    
    @RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes="application/json", produces="application/json")
    // 请求体采用json格式，各属性名称与Member类的个属性名称对应
    public @ResponseBody Object modifyMember(@PathVariable("id") Long id, @RequestBody Member member)
    {
    	System.out.println("id=" + id);
    	System.out.println(ReflectionToStringBuilder.toString(member, ToStringStyle.MULTI_LINE_STYLE));
    	Map<String, Object> map = new HashMap<>();
    	map.put("code", "2001");
    	map.put("message", "修改成功");
    	map.put("id", id);
    	map.put("member", member);
    	return map;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE, produces="application/json")
    public @ResponseBody Object deleteMember(@PathVariable("id") Long id)
    {
    	System.out.println("id=" + id);
    	Map<String, Object> map = new HashMap<>();
    	map.put("code", "2002");
    	map.put("message", "删除成功");
    	map.put("id", id);
    	return map;
    }
    
    //TODO　上传文件的接口
}
