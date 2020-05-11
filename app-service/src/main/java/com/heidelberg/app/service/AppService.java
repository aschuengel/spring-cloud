package com.heidelberg.app.service;

import com.heidelberg.app.model.AppInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1/app")
public interface AppService {
    @GetMapping
    AppInfo getAppInfo();
}
