package com.shxt.interceptor;

import java.util.Map;

import org.apache.struts2.dispatcher.ServletDispatcherResult;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoggerInterceptor implements Interceptor {
	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("BIGEIN-----------------------------");
		/*找到运行的Action对象，并打印其类名--在执行那个Action*/
		System.out.println("Action名称:["+invocation.getAction().getClass().getName()+"]");
		/*找到运行的ActionProxy对象，并打印其要运行的方法名--在执行这个Action中的哪个方法*/
		System.out.println("Method方法名称:["+invocation.getProxy().getMethod()+"]");
		/*找到这次请求的request中的parameter参数，并打印*/
		Map<String, Object> map = invocation.getInvocationContext().getParameters();
		for(String key : map.keySet()){
			Object obj = map.get(key);
			
			if(obj instanceof String[]){
				String[] arr = (String[])obj;
				System.out.print("Param:["+key+"] --- Value:[");  
                for (String value:arr){  
                    System.out.print(value);  
                }  
                System.out.println("]");
			}
		}
		
		//运行后续的拦截器、Action和Result  
        String resultCode = invocation.invoke();  
        
        //在Action和Result运行之后，得到Result对象  
        //并且可以强制转换成ServletDispatcherResult，打印其下一个JSP的位置  
        Result rresult = invocation.getResult();  
        if (rresult instanceof ServletDispatcherResult){  
            ServletDispatcherResult result = (ServletDispatcherResult) rresult;  
            System.out.println("JSP:"+result.getLastFinalLocation());  
        }  
		
		
        System.out.println("end-------------------------------");           
        return resultCode;
	}
	
	public void destroy() {}

	public void init() {}

}
