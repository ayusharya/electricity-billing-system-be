package tech.electricity.electricitybillingsystem.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tech.electricity.electricitybillingsystem.dao.ElecBillDao;
import tech.electricity.electricitybillingsystem.model.ElecBillModel;

@Repository
public class ElecBillDaoImpl implements ElecBillDao {
	@Autowired
	private SqlSession sql;

	@Override
	public List<ElecBillModel> findAll() {
		return this.sql.selectList("findAll");
	}

	@Override
	public ElecBillModel findByBillId(Long billId) {
		return this.sql.selectOne("findByBillId", billId);
	}

	@Override
	public List<ElecBillModel> findByUserId(Long userId) {
		return this.sql.selectList("findByUserId", userId);
	}

	@Override
	public Long findbillIdNextVal() {
		return this.sql.selectOne("findbillIdNextVal");
	}

	@Override
	public int insert(ElecBillModel ebill) {
		return this.sql.insert("insert", ebill);
	}

	@Override
	public int deleteByBillId(long billId) {
		return this.sql.delete("deleteByBillId", billId);
	}

	@Override
	public int deleteBillByUserId(long userId) {
		return this.sql.delete("deleteBillByUserId", userId);
	}

	@Override
	public int updateBill(ElecBillModel ebill) {
		return this.sql.update("bill.updateBill", ebill);
	}

}
