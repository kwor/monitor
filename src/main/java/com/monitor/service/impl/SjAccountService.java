package com.monitor.service.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.monitor.service.ISjAccountService;
import com.monitor.util.HttpTool;
@Service("SjAccountService")
public class SjAccountService implements ISjAccountService {

	@SuppressWarnings("static-access")
	@Override
	public String getToken() {
		// TODO Auto-generated method stub
		String surl="https://api.saj-solar.com/accessToken?client_id=15426&client_secret=2E7D9390-D68C-436D-A632-798422781066&grant_type=2E7D9390-D68C-436D-A632-798422781066&scope=read,write";
		String jsoninfo = null;
		try {
			jsoninfo = new HttpTool().sendPost("", surl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsoninfo;
	}

}
