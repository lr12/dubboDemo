package nju.software.provider.filter;

import java.lang.reflect.Method;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import nju.software.provider.util.IpWhiteList;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.RpcResult;

/**
 * 
 * @author lr12
 *
 */
@Slf4j
public class ConsumerFilter implements Filter {

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation)
			throws RpcException {
		String clientIp = RpcContext.getContext().getRemoteHost();
		log.debug(clientIp + ":调用");
		List<String> whiteIps = IpWhiteList.whiteIps;
		if (whiteIps.contains(clientIp)) {
			return invoker.invoke(invocation);
		} else {
			return new RpcResult();
		}
	}

}
