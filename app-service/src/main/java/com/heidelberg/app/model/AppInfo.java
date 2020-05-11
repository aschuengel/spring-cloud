package com.heidelberg.app.model;

import com.heidelberg.user.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AppInfo {
    private List<User> users;
}
