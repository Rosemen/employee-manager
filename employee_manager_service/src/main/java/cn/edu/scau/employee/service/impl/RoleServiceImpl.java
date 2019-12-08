package cn.edu.scau.employee.service.impl;

import cn.edu.scau.employee.common.constant.CommonResult;
import cn.edu.scau.employee.common.dto.RoleAddDto;
import cn.edu.scau.employee.common.dto.RoleResultDto;
import cn.edu.scau.employee.common.entity.Role;
import cn.edu.scau.employee.dao.mapper.ResourceMapper;
import cn.edu.scau.employee.dao.mapper.RoleMapper;
import cn.edu.scau.employee.dao.mapper.RoleResourceMapper;
import cn.edu.scau.employee.interfaces.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色管理业务接口实现类
 *
 * @author chen.jiale
 * @date 2019/11/20 15:30
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Override
    public CommonResult findAll() {
        List<Role> roles = roleMapper.selectAll();
        List<RoleResultDto> roleResultDtos = roles.stream().map(role -> {
            RoleResultDto resultDto = new RoleResultDto();
            BeanUtils.copyProperties(role, resultDto);
            return resultDto;
        }).collect(Collectors.toList());
        return CommonResult.success(roleResultDtos);
    }

    @Override
    public CommonResult add(RoleAddDto roleAddDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleAddDto,role);
        roleMapper.insert(role);
        //TODO 处理角色对应的权限
        return CommonResult.success();
    }

    @Override
    public CommonResult delete(List<Integer> ids) {
        //TODO
        return CommonResult.success();
    }

    @Override
    public CommonResult update(Integer id, RoleAddDto roleAddDto) {
        //TODO
        return CommonResult.success();
    }
}
