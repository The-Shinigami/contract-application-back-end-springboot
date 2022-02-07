package org.lsi.service;

import java.math.BigInteger;

import java.util.List;

import org.lsi.entities.Contract;
import org.lsi.entities.Proprety;
import org.lsi.entities.User;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;

public interface TestService {
	Tuple7<String, String, String, String, BigInteger, String, String> Propreties(BigInteger param0) throws Exception;
	BigInteger PropretyCount() throws Exception;
//	TransactionReceipt addLand(String numeroC,String idProp, String ownerLand, String buyerLand, BigInteger cost, String desc, String date) throws Exception;
	BigInteger getNumberLands() throws Exception;
	//public List<Contract> getAllOfOwner(String idOwner);
	public List<Contract> getAll();
	public Contract addLand(User buyer, User seller, BigInteger cost, String desc,Proprety prop, String date) throws Exception;
	List<Contract> getAllOfOwner(String id);
}
