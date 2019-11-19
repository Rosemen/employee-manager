package cn.edu.scau.employee.service.impl;

import cn.edu.scau.employee.common.entity.User;
import cn.edu.scau.employee.common.entity.dto.UserDto;
import cn.edu.scau.employee.common.entity.dto.UserExcelDto;
import cn.edu.scau.employee.common.entity.dto.UserResultDto;
import cn.edu.scau.employee.common.result.CommonResult;
import cn.edu.scau.employee.common.result.RespConstants;
import cn.edu.scau.employee.common.utils.EncryptUtil;
import cn.edu.scau.employee.common.utils.ExcelUtil;
import cn.edu.scau.employee.common.utils.JsonUtil;
import cn.edu.scau.employee.common.utils.TokenUtil;
import cn.edu.scau.employee.dao.mapper.UserMapper;
import cn.edu.scau.employee.dao.repository.TokenRepository;
import cn.edu.scau.employee.interfaces.service.UserService;
import cn.edu.scau.employee.service.handler.TableStyleStrategy;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.DateUtils;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;


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

    @Override
    public CommonResult importExcel(byte[] bytes) {
        logger.info("===========UserServiceImpl.importExcel============");
        EasyExcel.read(new ByteArrayInputStream(bytes), UserExcelDto.class,
                ExcelUtil.getListener(batchInsert())).sheet().doRead();
        return CommonResult.success();
    }

    @Override
    public CommonResult exportExcel(String fileName) throws Exception {
        logger.info("===========UserServiceImpl.exportExcel============");
        ExcelWriterBuilder writerBuilder = EasyExcel.write(new FileOutputStream(fileName), UserExcelDto.class);
        ExcelWriter excelWriter = writerBuilder.build();
        WriteSheet writeSheet = EasyExcel.writerSheet()
                           .registerWriteHandler(TableStyleStrategy.getStrategy())
                           .build();
        List<UserExcelDto> userExcelDtos = userMapper.selectAll().stream().map(user -> {
            UserExcelDto userExcelDto = new UserExcelDto();
            BeanUtils.copyProperties(user, userExcelDto);
            userExcelDto.setHiredate(DateUtils.format(user.getHiredate(),"yyyy-MM-dd"));
            userExcelDto.setBirthday(DateUtils.format(user.getBirthday(),"yyyy-MM-dd"));
            return userExcelDto;
        }).collect(Collectors.toList());
        excelWriter.write(userExcelDtos, writeSheet);
        excelWriter.finish();
        return CommonResult.success();
    }

    private Consumer<List<UserExcelDto>> batchInsert() {
        return userExcelDtos -> {
            try {
                for (UserExcelDto userExcelDto : userExcelDtos) {
                    User user = new User();
                    BeanUtils.copyProperties(userExcelDto, user);
                    user.setHiredate(DateUtils.parseDate(userExcelDto.getHiredate()));
                    user.setBirthday(DateUtils.parseDate(userExcelDto.getBirthday()));
                    user.setPassword(EncryptUtil.getEncryptedPassword(user.getUsername()));
                    user.setRoleId(2);
                    userMapper.insert(user);
                }
            } catch (Exception ex) {
                logger.error("Dto转换实体类失败", ex);
            }
        };
    }
}
