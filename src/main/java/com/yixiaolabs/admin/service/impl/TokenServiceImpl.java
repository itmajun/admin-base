package com.yixiaolabs.admin.service.impl;

import com.yixiaolabs.admin.core.AbstractService;
import com.yixiaolabs.admin.dao.TokenMapper;
import com.yixiaolabs.admin.model.Token;
import com.yixiaolabs.admin.service.TokenService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;


/**
 * Created by CodeGenerator on 2018/02/18.
 */
@Service
@Transactional
public class TokenServiceImpl extends AbstractService<Token> implements TokenService {
    @Resource
    private TokenMapper tokenMapper;

    /** 12小时过期 **/
    private static final int EXPIRE = 3600 * 12;

    @Override
    public String genToken(Integer id) {

        Token token = tokenMapper.selectByPrimaryKey(id);

        Date now = new Date();
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
        String uuToken = UUID.randomUUID().toString();
        if(token == null){
            token = new Token();
            token.setUserId(id);
            token.setToken(uuToken);
            token.setUpdateTime(now);
            token.setExpireTime(expireTime);
            tokenMapper.insert(token);
        }else {
            token.setToken(uuToken);
            token.setUpdateTime(now);
            token.setExpireTime(expireTime);
            tokenMapper.updateByPrimaryKey(token);
        }

        return uuToken;
    }
}
