package tech.electricity.electricitybillingsystem.services.impl;

import java.util.Date;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.electricity.electricitybillingsystem.dao.ElecBillDao;
import tech.electricity.electricitybillingsystem.exception.DataNotFounException;
import tech.electricity.electricitybillingsystem.model.ElecBillModel;
import tech.electricity.electricitybillingsystem.services.ElecBillService;

@Service
public class ElecBillServiceImpl implements ElecBillService {
	@Autowired
	private ElecBillDao ebillDao;
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	@Override
	public ElecBillModel addBill(ElecBillModel ebill) {
		ebillDao = sessionTemplate.getMapper(ElecBillDao.class);
		Long billId = ebillDao.findbillIdNextVal();
		ebill.setBillId(billId);
		ebill.setBillDate(new Date());
		ebillDao.insert(ebill);
		System.out.println(ebill);
		return ebill;
	}

	@Override
	public List<ElecBillModel> findAllBill() {
		ebillDao = sessionTemplate.getMapper(ElecBillDao.class);
		List<ElecBillModel> bills = ebillDao.findAll();
		System.out.println(bills);
		return bills;

	}

	@Override
	public ElecBillModel findBillById(Long billId) throws DataNotFounException {
		ebillDao = sessionTemplate.getMapper(ElecBillDao.class);
		ElecBillModel bill = ebillDao.findByBillId(billId);
		if (bill != null) {
			System.out.println(bill);
			return bill;
		} else {
			throw new DataNotFounException("Bill not found with the id : " + billId);
		}

	}
	
	@Override
	public ElecBillModel updateBill(ElecBillModel ebill) throws DataNotFounException
	{
		ebillDao = sessionTemplate.getMapper(ElecBillDao.class);
		int count = ebillDao.updateBill(ebill);
		if (count > 0) {
			System.out.println(ebill);
			return ebill;
		} else {
			throw new DataNotFounException("Bill not found with the id : " + ebill.getBillId());
		}
		
	}
	
	@Override
	public void deleteBillSer(Long id) throws DataNotFounException
	{
		ebillDao = sessionTemplate.getMapper(ElecBillDao.class);
		int count = ebillDao.deleteByBillId(id);
		if (count > 0) {
			System.out.println("deleted successfully ");
		} else {
			throw new DataNotFounException("Bill not found with the id : " + id);
		}
		
	}
	
	@Override
	public void deleteBillByUserSer(Long id) throws DataNotFounException
	{
		ebillDao = sessionTemplate.getMapper(ElecBillDao.class);
		int count = ebillDao.deleteBillByUserId(id);
		if (count > 0) {
			System.out.println("deleted successfully ");
		} else {
			throw new DataNotFounException("User not found with the id : " + id);
		}
		
	}
}
