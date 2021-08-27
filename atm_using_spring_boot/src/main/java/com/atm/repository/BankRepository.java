package com.atm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.atm.model.Bank;
import com.atm.model.Response;

@Repository
public interface BankRepository extends MongoRepository<Bank, Long>{

	//@Query(value="select totalBalance from bank b where b.id=:id")
	Response<Bank> findByTotalBalance();
	//double findTotalBalance();

	//void save(double balance);

	//void saveTotalBalance(double balance);

}
