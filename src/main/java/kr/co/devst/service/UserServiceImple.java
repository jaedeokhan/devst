package kr.co.devst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.devst.dao.UserDao;
import kr.co.devst.model.UserVO;


@Service
public class UserServiceImple implements UserService{
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public int doJoin(UserVO param) {
		
		return userDao.doJoin(param);
	}

}
