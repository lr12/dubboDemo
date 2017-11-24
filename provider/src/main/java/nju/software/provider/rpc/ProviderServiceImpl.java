package nju.software.provider.rpc;

import nju.software.interfaces.service.ProviderService;

public class ProviderServiceImpl implements ProviderService{

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return name+":hello";
	}

}
