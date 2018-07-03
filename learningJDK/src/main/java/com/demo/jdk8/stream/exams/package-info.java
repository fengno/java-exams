/**
 * java.util.Stream 代表一个序列元素，<br>
 * 这些元素能够执行一个或多个操作， Stream 操作既可以是intermediate 或者terminal.<br>
 *  而terminal操作返回某个类型的一个结果, intermediate 操作返回的是stream自身，这样你能将多个调用链接在一行中实现。<br>
 *  Stream 是被一个源 如一个java.util.Collection 类似lists 或 sets 创建(maps还没有支持). <br>
 *  Stream 操作可以顺序也可以并行实现。<br>
 */
package com.demo.jdk8.stream.exams;