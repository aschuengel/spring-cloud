package com.heidelberg.app.service;

import com.heidelberg.app.client.UserClient;
import com.heidelberg.app.model.AppInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AppServiceImpl implements AppService {
    private final UserClient userClient;

    public AppServiceImpl(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public AppInfo getAppInfo() {
        return AppInfo.builder().users(userClient.getUsers()).build();
    }
}
