package com.example.pattern.decorator.passport.upgrede;

import com.example.pattern.decorator.passport.old.ISiginService;
import com.example.pattern.decorator.passport.old.ResultMsg;

/**
 * @author zhangliang
 * @date 2019/11/15 15:58
 */
public interface ISigninForThirdService extends ISiginService {

    public ResultMsg loginForQQ(String openId);

    public ResultMsg loginForWechat(String openId);

    public ResultMsg loginForToken(String token);

    public ResultMsg loginForTelphone(String telphone,String code);

    public ResultMsg loginForRegist(String username,String password);
}
