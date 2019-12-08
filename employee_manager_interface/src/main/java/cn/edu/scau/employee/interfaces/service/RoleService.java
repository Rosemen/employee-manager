package cn.edu.scau.employee.interfaces.service;

import cn.edu.scau.employee.common.constant.CommonResult;
import cn.edu.scau.employee.common.dto.RoleAddDto;

import java.util.List;

/**
 * 角色管理业务接口
 *
 * @author chen.jiale
 * @date 2019/11/20 15:26
 */
public interface RoleService {
    /**
     * 查询所有角色
     *
     * @return
     */
    CommonResult findAll();

    /**
     * 添加角色
     *
     * @param roleAddDto
     * @return
     */
    CommonResult add(RoleAddDto roleAddDto);

    /**
     * 批量删除角色
     *
     * @param ids
     * @return
     */
    CommonResult delete(List<Integer> ids);

    /**
     * 更新角色
     *
     * @param id
     * @param roleAddDto
     * @return
     */
    CommonResult update(Integer id,RoleAddDto roleAddDto);
}
