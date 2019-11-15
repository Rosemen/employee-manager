package cn.edu.scau.employee.service.impl;

import cn.edu.scau.employee.common.entity.User;
import cn.edu.scau.employee.common.entity.dto.UserDto;
import cn.edu.scau.employee.common.entity.dto.UserResultDto;
import cn.edu.scau.employee.common.result.CommonResult;
import cn.edu.scau.employee.common.result.RespConstants;
import cn.edu.scau.employee.common.utils.JsonUtil;
import cn.edu.scau.employee.common.utils.TokenUtil;
import cn.edu.scau.employee.dao.mapper.UserMapper;
import cn.edu.scau.employee.dao.repository.TokenRepository;
import cn.edu.scau.employee.interfaces.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 用户业务类
 *
 * @author chen.jiale
 * @date 2019/11/10 16:56
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public CommonResult login(UserDto userDto) {
        logger.info("==========UserServiceImpl.login===========");
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userDto.getUsername(), userDto.getPassword());
        currentUser.login(token);
        CommonResult result = CommonResult.success();
        if (currentUser.isAuthenticated()) {
            //登录成功，生成并返回token
            User user = (User) currentUser.getPrincipal();
            UserResultDto resultDto = new UserResultDto();
            String tokenStr = TokenUtil.generateToken(user.getUsername());
            tokenRepository.saveUser(tokenStr, JsonUtil.convertToJson(user));
            resultDto.setToken(tokenStr);
            BeanUtils.copyProperties(user, resultDto);
            result.setData(resultDto);
        }
        return result;
    }

    @Override
    public CommonResult logout(String token) {
        logger.info("==========UserServiceImpl.logout===========");
        tokenRepository.clearToken(token);
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return CommonResult.success();
    }

    @Override
    public CommonResult findByUserName(String username) {
        logger.info("==========UserServiceImpl.findByUserName===========");
        User user = userMapper.selectByUsername(username);
        return new CommonResult(RespConstants.SUCCESS, RespConstants.SUCCESS_MSG, user);
    }
}
