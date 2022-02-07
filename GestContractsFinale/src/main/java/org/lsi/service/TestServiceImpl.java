package org.lsi.service;

import java.math.BigInteger;


import java.util.List;

import org.lsi.Constants;
import org.lsi.Contracts;
import org.lsi.config.Web3jConfig;
import org.lsi.entities.Contract;
import org.lsi.entities.Proprety;
import org.lsi.entities.User;
import org.lsi.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;



@Service
public class TestServiceImpl implements TestService{
	
	@Autowired 
	ContractRepository contRep;
	
	
	private final Web3j web3j=Web3jConfig.web3j();


 //    web3j = Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));
	 Credentials credentials = Credentials.create(Constants.PRIVATE_KEY);


@SuppressWarnings("deprecation")
@Override
public Tuple7<String, String, String, String, BigInteger, String, String> Propreties(BigInteger param0) throws Exception {
	Contracts test=Contracts.load(Constants.CONTRATC_ADDRESS,web3j,credentials,Constants.GAS_PRICE,Constants.GAS_LIMIT);
	return test.Propreties(param0).send();
}


@SuppressWarnings("deprecation")
@Override
public BigInteger PropretyCount() throws Exception {
	Contracts test=Contracts.load(Constants.CONTRATC_ADDRESS,web3j,credentials,Constants.GAS_PRICE,Constants.GAS_LIMIT);
	return test.PropretyCount().send();
}

//
//@SuppressWarnings("deprecation")
//@Override
//public TransactionReceipt addLand(String typePro, String ownerLand, String buyerLand, BigInteger cost, String desc,String date) throws Exception {
//	Contracts test=Contracts.load(Constants.CONTRATC_ADDRESS,web3j,credentials,Constants.GAS_PRICE,Constants.GAS_LIMIT);
//	return test.addLand(typePro, ownerLand, buyerLand, cost,desc,date).send();
//}
//

@SuppressWarnings("deprecation")
@Override
public BigInteger getNumberLands() throws Exception {
	Contracts test=Contracts.load(Constants.CONTRATC_ADDRESS,web3j,credentials,Constants.GAS_PRICE,Constants.GAS_LIMIT);
	return test.getNumberLands().send();
}


@Override
public List<Contract> getAll() {
	
	return contRep.findAll();
}


@SuppressWarnings("deprecation")
@Override
public Contract addLand(User buyer, User seller, BigInteger cost, String desc, Proprety prop, String date) throws Exception{
	Contract c=new Contract(buyer,seller,cost,date,prop,desc);
	contRep.save(c); 
	Contracts test=Contracts.load(Constants.CONTRATC_ADDRESS,web3j,credentials,Constants.GAS_PRICE,Constants.GAS_LIMIT);
//	System.out.println("contract id : "+c.getId());
//	System.out.println("prop id : "+prop.getId());
//	System.out.println("seller id : "+c.getId());
//	System.out.println("buyer id : "+ buyer.getId_user());
//	System.out.println("cost : "+cost);
//	System.out.println("prop desc : "+prop.getDesc());
//	System.out.println("date : "+date);
	//return test.addLand(c.getId(), prop.getId(),seller.getId_user(), buyer.getId_user(), cost,prop.getDesc(),date).send();
  return c;
}


@Override
public List<Contract> getAllOfOwner(String id) {
	// TODO Auto-generated method stub
	return null;
}





}
