package com.ant.importregistrar.registrar;

import com.ant.importregistrar.dao.UserDao;
import com.ant.importselector.test.TestDemo;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.FactoryBean;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: MyFactoryBean
 * @Description: MyFactoryBean
 * @datetime 2019/3/16 19:35
 * @Version 1.0
 */
public class MyFactoryBean implements FactoryBean {

	Class clazz;

	public MyFactoryBean(Class clazz) {
		this.clazz = clazz;
	}

	@Override
	public Object getObject() throws Exception {
		Class[] clazzs = new Class[]{clazz};

		Object proxy = Proxy.newProxyInstance(MyFactoryBean.class.getClassLoader(), clazzs, new MyInvocationHandler<>(this));

		return proxy;
	}

	@Override
	public Class<?> getObjectType() {
		return clazz;
	}

}
