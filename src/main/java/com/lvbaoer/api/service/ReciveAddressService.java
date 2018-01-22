package com.lvbaoer.api.service;

import java.util.List;

import com.lvbaoer.api.bean.AddressParam;
import com.lvbaoer.api.domain.ReciveAddress;

public interface ReciveAddressService {
	int save(AddressParam addr, String userId);

	void update(ReciveAddress addr);

	void delete(int id);

	List<ReciveAddress> getAddrs(String userId);
}
