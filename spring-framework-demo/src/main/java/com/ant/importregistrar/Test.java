package com.ant.importregistrar;

import com.ant.importregistrar.config.Appconfig;
import com.ant.importregistrar.dao.UserDao;
import com.ant.importregistrar.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: Test
 * @Description: Test
 * @datetime 2019/3/16 18:53
 * @Version 1.0
 */
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext
				= new AnnotationConfigApplicationContext();

		/**
		 * 这行代码是把我们自己定义的AppConfig.class的class类转换成bd,
		 * 然后put到我们的beanDifinitionMap当中去;
		 * beanDifinitonMap实际上是我们的DefaultListableBeanFactory的属性
		 * 那么我们的DefaultListableBeanFactory是怎么来的呢？在工厂中的什么位置呢？
		 **/

		annotationConfigApplicationContext.register(Appconfig.class);

		annotationConfigApplicationContext.refresh();

//		UserService userService = annotationConfigApplicationContext.getBean(UserService.class);
//		userService.query();

		UserDao dao = annotationConfigApplicationContext.getBean(UserDao.class);
		dao.query();
	}
}
