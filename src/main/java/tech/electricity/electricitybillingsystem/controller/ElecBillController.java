package tech.electricity.electricitybillingsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.electricity.electricitybillingsystem.exception.DataNotFounException;
import tech.electricity.electricitybillingsystem.model.ElecBillModel;
import tech.electricity.electricitybillingsystem.services.ElecBillService;

@RestController
@RequestMapping("/elecBill")
@Validated
public class ElecBillController {
	@Autowired
	private ElecBillService elecBillService;
	@GetMapping("/allbill")
	public ResponseEntity<List<ElecBillModel>> getAllbill() {
		List<ElecBillModel> bills = elecBillService.findAllBill();
		return new ResponseEntity<>(bills, HttpStatus.OK);
	}
	
	

	@GetMapping("/find/{billId}")
	public ResponseEntity<ElecBillModel> getBillById(@Valid @PathVariable("billId") Long id) throws DataNotFounException {
		System.out.print(id);
		ElecBillModel bill = elecBillService.findBillById(id);
		return new ResponseEntity<>(bill, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<ElecBillModel> addBill(@Valid @RequestBody ElecBillModel ebill) {
		ElecBillModel newBill = elecBillService.addBill(ebill);
		return new ResponseEntity<>(newBill, HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ElecBillModel> updateBill(@Valid @RequestBody ElecBillModel user) throws DataNotFounException {
		ElecBillModel updatebill = elecBillService.updateBill(user);
		return new ResponseEntity<ElecBillModel>(updatebill, HttpStatus.OK);
	}
	
	@PostMapping("/delete/{billId}")
	public ResponseEntity<String> deleteBill(@Valid @PathVariable("billId") Long id) throws DataNotFounException {
		elecBillService.deleteBillSer(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@PostMapping("/deletebillbyuserid/{userId}")
	public ResponseEntity<String> deleteBillByUser(@Valid @PathVariable("userId") Long id) throws DataNotFounException {
		elecBillService.deleteBillByUserSer(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
