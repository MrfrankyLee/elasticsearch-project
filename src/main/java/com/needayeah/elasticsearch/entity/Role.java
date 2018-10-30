package com.needayeah.elasticsearch.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lixiaole
 * @date 2018/10/30
 * @Description
 */

@Table(name = "role")
@ApiModel(value = "角色")
@Entity
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ApiModelProperty(value = "用户id")
    @Column(name = "user_id")
    private long userID;
    @ApiModelProperty(value = "角色名称")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

