package nju.software.provider.rpc;

import nju.software.interfaces.service.ProviderService;

public class MultiVersionServiceImpl implements ProviderService {

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "vsersion2:"+name+":hello";
	}

	@Override
	public String asyncHello(String name) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "vsersion2:"+name+":hello(aync)";
	}

}
