package cn.test;

import org.junit.Test;

import cn.e3mall.common.utils.FastDFSClient;

public class Demo {

	@Test
	public void s() throws Exception{
		
		FastDFSClient fastDFSClient = new FastDFSClient("E:/e3mall/code1.0/e3-manager-web/src/main/resources/conf/client.conf");
		String string = fastDFSClient.uploadFile("C:/Users/WangZhuo/Desktop/extra/1.jpg", "jpg");
		System.out.println(string);
		
	}
}
