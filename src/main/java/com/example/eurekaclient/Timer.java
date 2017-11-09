package com.example.eurekaclient;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@EnableScheduling
public class Timer {
	private final Logger logger = Logger.getLogger(getClass());
	
    @Autowired
    private RestTemplate restTemplate;
    
	@Scheduled(fixedDelay = 2000)
	public void run() {
		logger.info(restTemplate.getForEntity("http://music-service/music", String.class).getBody());
    }

}
