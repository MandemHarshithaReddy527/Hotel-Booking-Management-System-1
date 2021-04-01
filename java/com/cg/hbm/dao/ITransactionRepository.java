package com.cg.hbm.dao;
import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.hbm.entites.Transactions;

public interface ITransactionRepository extends JpaRepository<Transactions,Integer >{
	//public Transactions addTransaction(Transactions transaction);
}
