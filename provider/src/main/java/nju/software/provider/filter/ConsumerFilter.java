package nju.software.provider.filter;

import java.lang.reflect.Method;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;


/**
 * 
 * @author lr12
 *
 */
public class ConsumerFilter implements Filter{

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		Method[] methods=invoker.getInterface().getDeclaredMethods();
		for(Method m:methods){
			System.out.println(m.getName()+"::name");
		}
		return invoker.invoke(invocation);
	}

}
