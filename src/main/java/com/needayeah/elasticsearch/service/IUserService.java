package com.needayeah.elasticsearch.service;

import com.needayeah.elasticsearch.entity.User;

/**
 * @author lixiaole
 * @date 2018/10/30
 * @Description
 */
public interface IUserService {
    User findUserByName(String name);
}
