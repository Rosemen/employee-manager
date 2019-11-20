package cn.edu.scau.employee.interfaces.service;

import cn.edu.scau.employee.common.entity.Resource;

import java.util.List;


/**
 * 资源业务接口
 *
 * @author chen.jiale
 * @date 2019/11/20 10:53
 */
public interface ResourceService {

    /**
     * 查询资源
     *
     * @param roleId
     * @return
     */
    List<Resource> findByRoleId(Integer roleId);
}
