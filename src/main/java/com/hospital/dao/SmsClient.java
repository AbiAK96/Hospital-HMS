package com.hospital.dao;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class SmsClient {
	
	private static SmsClient sms = new SmsClient();

    public static SmsClient getInstance() {
        return sms;
    }
    public void SendSms(String number, String message) throws RestClientException{
        new RestTemplate().getForObject("http://www.textit.biz/sendmsg/index.php?id=94756003912&password=8934&text="+message.replaceAll(" ", "%20")+"&to=" + number,String.class);
    }
	

}
