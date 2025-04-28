package tech.electricity.electricitybillingsystem.dao;

import java.util.List;

import tech.electricity.electricitybillingsystem.model.UserModel;

public interface UsersDao {

	public List<UserModel> findAll();

	public UserModel findById(Long userId);

//	@Select("SELECT nextval(pg_get_serial_sequence('users','user_id'))")
	public Long findUserIdNextVal();

	public int deleteById(long userid);

	public int insert(UserModel user);

	public int update(UserModel user);

	public UserModel loginByIdPass(UserModel uLogin);

}
