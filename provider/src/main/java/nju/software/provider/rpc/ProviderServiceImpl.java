package nju.software.provider.rpc;

import nju.software.interfaces.service.ProviderService;

public class ProviderServiceImpl implements ProviderService{

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return name+":hello";
	}

	@Override
	public String asyncHello(String name) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name+":hello(async)";
	}

}
