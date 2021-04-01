package com.cg.hbm.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cg.hbm.dao.ITransactionRepository;

import com.cg.hbm.entites.Transactions;
@Service
@Transactional
public class ITransactionServiceImpl implements ITransactionService{
	@Autowired
	ITransactionRepository irepository;
	@Override
	public Transactions addTransaction(Transactions transaction) {
		// TODO Auto-generated method stub
		irepository.saveAndFlush(transaction);
		return transaction;
	}
	@Override
	 public List<Transactions> showAllTransactions() {
	 
	 return irepository.findAll();
	 }
	 
}
