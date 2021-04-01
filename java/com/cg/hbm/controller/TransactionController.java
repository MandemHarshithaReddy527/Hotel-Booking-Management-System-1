package com.cg.hbm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbm.entites.Transactions;
import com.cg.hbm.service.ITransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	ITransactionService iService;
	
	@PostMapping
	public Transactions addTransaction(@RequestBody Transactions transaction) {
		return iService.addTransaction(transaction);
	}
	@GetMapping
	public List<Transactions> showAllPayments() {
		return iService.showAllTransactions();
	}
}

