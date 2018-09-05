package com.metacube.training;

import java.util.*;

/**
 * This class contains Implements Injection for Collections
 * 
 * @author Mohit Sharma
 *
 */
public class CollectionInjection {
	List<String> addressList;
	Set<String> addressSet;
	Map<String, String> addressMap;
	Properties addressProp;

	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}

	public List<String> getAddressList() {
		System.out.println("List Elements :" + addressList);
		return addressList;
	}

	public void setAddressSet(Set<String> addressSet) {
		this.addressSet = addressSet;
	}

	public Set<String> getAddressSet() {
		System.out.println("Set Elements :" + addressSet);
		return addressSet;
	}

	public void setAddressMap(Map<String, String> addressMap) {
		this.addressMap = addressMap;
	}

	public Map<String, String> getAddressMap() {
		System.out.println("Map Elements :" + addressMap);
		return addressMap;
	}
}
