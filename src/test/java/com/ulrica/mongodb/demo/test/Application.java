package com.ulrica.mongodb.demo.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ulrica.mongodb.demo.dao.UserDao;
import com.ulrica.mongodb.demo.impl.UserDaoImpl;
import com.ulrica.mongodb.demo.model.NameEntity;
import com.ulrica.mongodb.demo.model.UserEntity;

public class Application {

	public static void main(String[] args) {

		System.out.println("Bootstrapping HelloMongo");

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring.xml");

		UserDao userDao = context.getBean(UserDaoImpl.class);
		userDao._test();
		UserEntity user1 = new UserEntity();
		user1.setId("11");
		user1.setAge(1);
		NameEntity ne = new NameEntity();
		ne.setUsername("user1");
		ne.setNickname("用户1");
		user1.setName(ne);
		user1.setBirth(new Date());
		user1.setPassword("asdfasdf");
		user1.setRegionName("北京");
		user1.setWorks(1);
		userDao.insert(user1);
		userDao.update(user1);
		userDao.createCollection();

		List<UserEntity> list = userDao.findList(0, 10);
		for (UserEntity e : list) {
			System.out.println("all - id=" + e.getId() + ", age=" + e.getAge() + ", password=" + e.getPassword()
					+ ", regionName=" + e.getRegionName() + ", special=" + Arrays.toString(e.getSpecial()) + ", name="
					+ e.getName().getUsername() + "-" + e.getName().getNickname() + ", birth=" + e.getBirth());
		}

		list = userDao.findListByAge(1);
		for (UserEntity e : list) {
			System.out.println("age=1 - id=" + e.getId() + ", age=" + e.getAge() + ", password=" + e.getPassword()
					+ ", regionName=" + e.getRegionName() + ", special=" + Arrays.toString(e.getSpecial()) + ", name="
					+ e.getName().getUsername() + "-" + e.getName().getNickname() + ", birth=" + e.getBirth());
		}

		UserEntity e = userDao.findOne("11");
		System.out.println("id=1 - id=" + e.getId() + ", age=" + e.getAge() + ", password=" + e.getPassword()
				+ ", regionName=" + e.getRegionName() + ", special=" + Arrays.toString(e.getSpecial()) + ", name="
				+ e.getName().getUsername() + "-" + e.getName().getNickname() + ", birth=" + e.getBirth());

		e = userDao.findOneByUsername("user1");
		System.out.println("username=limingnihao - id=" + e.getId() + ", age=" + e.getAge() + ", password="
				+ e.getPassword() + ", regionName=" + e.getRegionName() + ", special=" + Arrays.toString(e.getSpecial())
				+ ", name=" + e.getName().getUsername() + "-" + e.getName().getNickname() + ", birth=" + e.getBirth());

		context.close();
		System.out.println("DONE!");
	}
}
