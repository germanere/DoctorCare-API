package com.duc.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component("postservice")
@ComponentScan(basePackages = {"com.duc.service"})
public class PostService {

}
