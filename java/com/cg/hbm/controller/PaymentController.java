package com.cg.hbm.controller;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.hbm.entites.Payments;
import com.cg.hbm.exceptions.PaymentNotFoundException;
import com.cg.hbm.service.IPaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	IPaymentService iService;
	

	@PostMapping
	public ResponseEntity<Payments> addPayment(@RequestBody Payments payments) throws PaymentNotFoundException  {
		Payments resultPayments=iService.addPayment(payments);
		return new ResponseEntity<Payments>(resultPayments,HttpStatus.OK) ;
	}

	
	@GetMapping

		public ResponseEntity<List<Payments>> showAllPayments() throws PaymentNotFoundException{
			List<Payments> resultPayments=iService.showAllPayments();
			return new ResponseEntity<List<Payments>>(resultPayments, HttpStatus.OK);
		}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Payments>showPayments(@PathVariable int id) throws PaymentNotFoundException {
		Payments p=iService.showPayments(id);
		if(p!=null) {
			return new ResponseEntity<Payments>(p,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Payments>(HttpStatus.NOT_FOUND);
		}
		
	}
}
