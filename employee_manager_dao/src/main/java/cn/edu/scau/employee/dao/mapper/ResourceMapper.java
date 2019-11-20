package cn.edu.scau.employee.dao.mapper;

import cn.edu.scau.employee.common.entity.Resource;

/**
 * 资源Mapper
 *
 * @author chen
 * @date 2019/11/20
 */
public interface ResourceMapper {
    /**
     * 添加资源
     *
     * @param record
     * @return
     */
    int insert(Resource record);

    /**
     * 删除资源
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 修改资源
     *
     * @param record
     * @return
     */
    int updateById(Resource record);

    /**
     * 查询资源
     *
     * @param id
     * @return
     */
    Resource selectById(Integer id);
}