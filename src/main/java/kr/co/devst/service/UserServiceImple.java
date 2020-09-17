package kr.co.devst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.devst.dao.UserDao;
import kr.co.devst.model.UserVO;


@Service
public class UserServiceImple implements UserService{
	
	@Autowired
	private UserDao userDao;

	// 이메일 중복체크
	@Override
	public int emailChk(String memEmail) throws Exception {
		int result = userDao.emailChk(memEmail);
		return result;
	}
	
	// 회원가입
	@Override
	public int doJoin(UserVO userVO) throws Exception {
		return userDao.doJoin(userVO);
	}




}
