package tech.electricity.electricitybillingsystem.services;

import java.util.List;

import tech.electricity.electricitybillingsystem.exception.DataNotFounException;
import tech.electricity.electricitybillingsystem.model.ElecBillModel;

public interface ElecBillService {
	public ElecBillModel addBill(ElecBillModel ebill);

	public List<ElecBillModel> findAllBill();

	public ElecBillModel findBillById(Long id) throws DataNotFounException;

	public void deleteBillSer(Long id) throws DataNotFounException;

	public ElecBillModel updateBill(ElecBillModel user) throws DataNotFounException;

	void deleteBillByUserSer(Long id) throws DataNotFounException;

}
