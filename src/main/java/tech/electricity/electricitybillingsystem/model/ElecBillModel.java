package tech.electricity.electricitybillingsystem.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class ElecBillModel {
	private Long billId;
	@NotNull(message = "User id is mandatory") 
	private Long userId;
	private Date billDate;
	@NotNull(message = "Amount is mandatory") 
	private Long billAmount;
	 
	private boolean paymentStatus;

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Long getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Long billAmount) {
		this.billAmount = billAmount;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "ElecBillModel [billId=" + billId + ", userId=" + userId + ", billDate=" + billDate + ", billAmount="
				+ billAmount + ", paymentStatus=" + paymentStatus + "]";
	}

}
