package tech.electricity.electricitybillingsystem.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tech.electricity.electricitybillingsystem.dao.UsersDao;
import tech.electricity.electricitybillingsystem.model.UserModel;

@Repository
public class UsersDaoImpl implements UsersDao {

	@Autowired
	private SqlSession sql;

	@Override
	public List<UserModel> findAll() {
		return this.sql.selectList("findAll");
	}

	@Override
	public UserModel findById(Long userId) {
		return this.sql.selectOne("findById", userId);
	}

	@Override
	public Long findUserIdNextVal() {
	  return this.sql.selectOne("findUserIdNextVal");
	}

	@Override
	public int deleteById(long userid) {
		return this.sql.delete("deleteById", userid);
	}

	@Override
	public int insert(UserModel user) {
		return this.sql.insert("insert", user);
	}

	@Override
	public int update(UserModel user) {
		return sql.update("user.update", user);
	}

	@Override
	public UserModel loginByIdPass(UserModel user) {
		return this.sql.selectOne("user.loginByIdPass", user);
	}

}
