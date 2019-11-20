package cn.edu.scau.employee.service.impl;

import cn.edu.scau.employee.common.entity.Resource;
import cn.edu.scau.employee.common.entity.RoleResource;
import cn.edu.scau.employee.dao.mapper.ResourceMapper;
import cn.edu.scau.employee.dao.mapper.RoleResourceMapper;
import cn.edu.scau.employee.interfaces.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 资源业务接口实现类
 *
 * @author chen.jiale
 * @date 2019/11/20 10:55
 */
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Override
    public List<Resource> findByRoleId(Integer roleId) {
        List<RoleResource> roleResources = roleResourceMapper.selectByRoleId(roleId);
        List<Resource> resources = roleResources.stream().map(roleResource -> {
            Resource resource = resourceMapper.selectById(roleResource.getResourceId());
            return resource;
        }).collect(Collectors.toList());
        return resources;
    }
}
