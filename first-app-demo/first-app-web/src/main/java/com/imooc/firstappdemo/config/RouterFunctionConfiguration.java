package com.imooc.firstappdemo.config;

import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.imooc.firstappdemo.domain.User;
import com.imooc.firstappdemo.repository.UserRepository;

import reactor.core.publisher.Flux;

/**
 * 路由器函数 配置
 */
@Configuration // 加上该注解表示是一个配置对象
public class RouterFunctionConfiguration {

	/**
	 * Servlet:
	 * 		请求接口：ServletRequest 或者 HttpServletRequest
	 * 		响应接口：ServletResponse 或者 HttpServletResponse
	 * Spring 5.0 重新定义了服务请求和响应接口：
	 * 		请求接口：ServerRequest
	 * 		响应接口：ServerResponse
	 * 既可支持Servlet规范，也可支持自定义，比如  Netty （Web Server）
	 * 以本例：
	 * 定义GET请求，并返回所有的用户对象 URI：/user/find/all
	 * Flux 是 0 - N 个对象集合
	 * Mono 是 0 - 1 个对象集合
	 * Reactive 中的 Flux 或 Mono 它是异步处理的
	 * 集合对象基本上是同步处理
	 *  Flux 或 Mono 都是 Publisher
	 */
	@Bean
	public RouterFunction<ServerResponse> userFindAll(UserRepository userRepo) {
		return RouterFunctions.route(RequestPredicates.GET("/user/find/all"), 
				request -> {
					Collection<User> users = userRepo.findAll();
					Flux<User> userFlux = Flux.fromIterable(users);
					return ServerResponse.ok().body(userFlux, User.class);
				});
	}
}
