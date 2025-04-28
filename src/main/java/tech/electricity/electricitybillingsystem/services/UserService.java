package tech.electricity.electricitybillingsystem.services;

import java.util.List;
import java.util.Map;

import tech.electricity.electricitybillingsystem.exception.DataNotFounException;
import tech.electricity.electricitybillingsystem.model.ElecBillModel;
import tech.electricity.electricitybillingsystem.model.UserModel;

public interface UserService {
	
	public List<UserModel> findAllUsers();
	
	public UserModel findUsersById(Long id) throws DataNotFounException;
	
	public UserModel addUser(UserModel user);
	
	public UserModel updateUser(UserModel user) throws DataNotFounException;
	
	public void deleteUser(Long id) throws DataNotFounException;

	public Map<UserModel, List<ElecBillModel>> UserBills();
	
	public List<ElecBillModel> UserBillsById(Long id) throws DataNotFounException;

	public UserModel loginByIdPass(UserModel user);

	
}
