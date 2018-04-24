package com.imooc.firstappdemo.repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.imooc.firstappdemo.domain.User;

/**
 * {@linkplain User} {@linkplain Repository}
 */
@Repository
public class UserRepository {

	/**
	 * 采用内存型的存储方式 -> Map
	 */
	private final ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>();
	
	private final static AtomicInteger idGenerator = new AtomicInteger();
	
	/**
	 * 保存用户对象
	 * @param user {@linkplain User}对象
	 * @return 成功返回<code>true</code>, 失败返回<code>false</code>
	 */
	public boolean save(User user) {
		int id = idGenerator.incrementAndGet();
		user.setId(id);
		return repository.put(id, user) == null;
	}
	
	public Collection<User> findAll() {
		return repository.values();
	}
}
