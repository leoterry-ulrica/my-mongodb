package com.ulrica.mongodb.demo.dao;

import java.util.List;

import com.ulrica.mongodb.demo.model.UserEntity;

public interface UserDao {

	public abstract void _test();  
	/**
	 * 创建集合
	 */
    public abstract void createCollection();  
  
    public abstract List<UserEntity> findList(int skip, int limit);  
  
    public abstract List<UserEntity> findListByAge(int age);  
  
    public abstract UserEntity findOne(String id);  
  
    public abstract UserEntity findOneByUsername(String username);  
  
    public abstract void insert(UserEntity entity);  
  
    public abstract void update(UserEntity entity);  
    
}
