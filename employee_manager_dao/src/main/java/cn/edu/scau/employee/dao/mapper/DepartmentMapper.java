package cn.edu.scau.employee.dao.mapper;

import cn.edu.scau.employee.common.entity.Department;

/**
 * 部门管理Mapper接口
 *
 * @author chen.jiale
 * @date 2019/12/03
 */
public interface DepartmentMapper {
    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 添加部门
     *
     * @param record
     * @return
     */
    int insert(Department record);

    /**
     * 查询部门
     *
     * @param id
     * @return
     */
    Department selectById(Integer id);

    /**
     * 修改部门
     *
     * @param record
     * @return
     */
    int updateById(Department record);
}