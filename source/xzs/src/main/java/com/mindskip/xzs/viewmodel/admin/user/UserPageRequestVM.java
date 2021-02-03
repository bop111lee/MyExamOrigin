package com.mindskip.xzs.viewmodel.admin.user;

import com.mindskip.xzs.base.BasePage;
import io.swagger.annotations.ApiModel;


/**
 * @author 武汉思维跳跃科技有限公司
 */


@ApiModel
public class UserPageRequestVM extends BasePage {

    private String userName;
    private Integer role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
