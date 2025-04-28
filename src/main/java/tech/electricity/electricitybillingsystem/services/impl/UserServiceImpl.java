package tech.electricity.electricitybillingsystem.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.electricity.electricitybillingsystem.dao.ElecBillDao;
import tech.electricity.electricitybillingsystem.dao.UsersDao;
import tech.electricity.electricitybillingsystem.exception.DataNotFounException;
import tech.electricity.electricitybillingsystem.model.ElecBillModel;
import tech.electricity.electricitybillingsystem.model.UserModel;
import tech.electricity.electricitybillingsystem.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UsersDao usersDao;
	@Autowired
	private ElecBillDao ebillDao;
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	@Override
	public List<UserModel> findAllUsers() {
		usersDao = sessionTemplate.getMapper(UsersDao.class);
		List<UserModel> users = usersDao.findAll();
		for (UserModel user : users) {
			System.out.println(user);
		}
		System.out.println(users);
		return users;
	}

	@Override
	public UserModel findUsersById(Long id) throws DataNotFounException {
		usersDao = sessionTemplate.getMapper(UsersDao.class);
		UserModel user = usersDao.findById(id);
		if (user != null) {
			System.out.println(user);
			return user;
		} else {
			throw new DataNotFounException("User not found with the id : " + id);
		}

	}

	@Override
	public UserModel addUser(UserModel user) {
		System.out.println(user);
		usersDao = sessionTemplate.getMapper(UsersDao.class);
		Long userId = usersDao.findUserIdNextVal();
		user.setUserid(userId);
		usersDao.insert(user);
		System.out.println(user);
		return user;
	}

	@Override
	public UserModel updateUser(UserModel user) throws DataNotFounException {
		usersDao = sessionTemplate.getMapper(UsersDao.class);
        int count =usersDao.update(user);
		System.out.println(user);
		if (count > 0) {
			System.out.println("Updated successfully ");
			return user;
		} else {
			throw new DataNotFounException("User not found with the id : " + user.getUserid());
		}
		
	}

	@Override
	public void deleteUser(Long id) throws DataNotFounException {
		usersDao = sessionTemplate.getMapper(UsersDao.class);
		ebillDao.deleteBillByUserId(id);
		int count = usersDao.deleteById(id);
		
		if (count> 0) {
			System.out.println("deleted successfully ");
		} else {
			throw new DataNotFounException("User not found with the id : " + id);
		}

		System.out.println("deleted successfully ");
	}

	@Override
	public Map<UserModel, List<ElecBillModel>> UserBills() {
		Map<UserModel, List<ElecBillModel>> userBills = new HashMap<UserModel, List<ElecBillModel>>();
		List<UserModel> users = usersDao.findAll();
		for (UserModel user : users) {
			List<ElecBillModel> userebill = ebillDao.findByUserId(user.getUserid());
			userBills.put(user, userebill);
		}
		System.out.println(userBills);
		return userBills;
	}

	@Override
	public List<ElecBillModel>  UserBillsById(Long id) throws DataNotFounException {
		UserModel user = usersDao.findById(id);
		if (user != null) {
			List<ElecBillModel> userEbill = ebillDao.findByUserId(user.getUserid());
			return userEbill;
		} else {
			throw new DataNotFounException("User not found with the id : " + id);
		}
		
	}

	@Override
	public UserModel loginByIdPass(UserModel user) {
		usersDao = sessionTemplate.getMapper(UsersDao.class);
		UserModel fetchedUser = usersDao.loginByIdPass(user);
		return fetchedUser;
	}
}
