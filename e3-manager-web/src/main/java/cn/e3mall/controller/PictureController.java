package cn.e3mall.controller;

import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.e3mall.common.utils.FastDFSClient;
import cn.e3mall.common.utils.JsonUtils;

@Controller
public class PictureController {

	@Value("${imageUrl}")
	private String imageUrl;
	
	@RequestMapping(value="/pic/upload",produces=org.springframework.http.MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	@ResponseBody
	public String uploadPic(MultipartFile uploadFile){
		String name = uploadFile.getOriginalFilename();
		String extName = name.substring(name.lastIndexOf(".")+1);
		
		
		try {
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
			String string = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
			
			string = imageUrl + string;
			System.out.println(string);
			
			HashMap<Object,Object> hashMap = new HashMap<>();
			hashMap.put("error", 0);
			hashMap.put("url", string);
			
			return JsonUtils.objectToJson(hashMap);
			
		} catch (Exception e) {
			e.printStackTrace();
			HashMap<Object,Object> hashMap = new HashMap<>();
			hashMap.put("error", 1);
			hashMap.put("message","上传过程中出现错误！" );
			return JsonUtils.objectToJson(hashMap);
			
		}
		
		
	}
	
}
