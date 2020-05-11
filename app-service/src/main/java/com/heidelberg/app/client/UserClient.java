package com.heidelberg.app.client;

import com.heidelberg.user.service.UserService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("user-service")
public interface UserClient extends UserService {
}
