package tech.electricity.electricitybillingsystem.dao;

import java.util.List;

import tech.electricity.electricitybillingsystem.model.ElecBillModel;

public interface ElecBillDao {

//	@Select("select bill_id as billId, user_id as userID, "
//			+ "bill_date as billDate, bill_amount as billAmount,payment_status as paymentStatus from elec_bill")
	public List<ElecBillModel> findAll();

//	@Select("select bill_id as billId, user_id as userID, "
//			+ "bill_date as billDate, bill_amount as billAmount,payment_status as paymentStatus from elec_bill WHERE bill_id = #{billId}")
	public ElecBillModel findByBillId(Long billId);

//	@Select("select bill_id as billId, user_id as userID, "
//			+ "bill_date as billDate, bill_amount as billAmount,payment_status as paymentStatus from elec_bill WHERE user_id = #{userID}")
	public List<ElecBillModel> findByUserId(Long userID);

//	@Select("SELECT nextval(pg_get_serial_sequence('elec_bill','bill_id'))")
	public Long findbillIdNextVal();

//	@Insert("INSERT INTO elec_bill(bill_id, user_id, bill_date,bill_amount,payment_status) "
//			+ " VALUES (#{billId}, #{userId}, #{billDate}, #{billAmount},#{paymentStatus})")
	public int insert(ElecBillModel ebill);

//	@Delete("DELETE FROM elec_bill WHERE bill_id = #{billId}")
	public int deleteByBillId(long billId);
//	@Delete("DELETE FROM elec_bill WHERE user_id = #{userId}")
	public int deleteBillByUserId(long userId);

//	@Update("Update elec_bill set bill_date=#{billDate},"
//			+ " bill_amount=#{billAmount}, payment_status=#{paymentStatus} where bill_id=#{billId}")
	public int updateBill(ElecBillModel ebill);

}
