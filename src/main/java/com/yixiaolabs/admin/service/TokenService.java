package com.yixiaolabs.admin.service;
import com.yixiaolabs.admin.model.Token;
import com.yixiaolabs.admin.core.Service;


/**
 * Created by CodeGenerator on 2018/02/18.
 */
public interface TokenService extends Service<Token> {

    String genToken(Integer id);
}
