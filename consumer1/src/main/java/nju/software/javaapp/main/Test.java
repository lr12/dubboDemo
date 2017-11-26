package nju.software.javaapp.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import nju.software.interfaces.service.ProviderService;
import nju.software.javaapp.dynamicds.DataSourceRouter;
import nju.software.javaapp.util.FileOperateUtil;
import nju.software.javaapp.util.StringUtil;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.GenericService;

public class Test {




	public static void main(String[] args) throws InterruptedException, ExecutionException{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml",
				"classpath:applicationContextDataSource.xml");
	    //GenericService genericService=(GenericService) applicationContext.getBean("providerService");
	    ProviderService providerService=(ProviderService) applicationContext.getBean("providerService");
	     
	    // 基本类型以及Date,List,Map等不需要转换，直接调用 
	    //System.out.println(genericService.$invoke("sayHello", new String[] {"java.lang.String"}, new Object[] {"world"}));
	    while(true){
	    	System.out.println(providerService.sayHello("lr"));
	    	Future<String> future=RpcContext.getContext().getFuture();
	    	
	    	Thread.sleep(10000);
	    	System.out.println(future.get());
	    }
	}

	public static void testAsync(ProviderService providerService) throws Exception{
		System.out.println(providerService.sayHello("lr"));
    	Future<String> future=RpcContext.getContext().getFuture();
    	
    	Thread.sleep(10000);
    	System.out.println(future.get());
	}
}
