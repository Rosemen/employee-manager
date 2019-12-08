package cn.edu.scau.employee.common.constant;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 分页基础信息
 *
 * @author chen.jiale
 * @date 2019/11/29 11:03
 */
@Data
public class PageConstant implements Serializable {
    private static final long serialVersionUID = -8511456784731719710L;

    /**
     * 当前页
     */
    private int currentPage;

    /**
     * 每页记录数
     */
    private int pageSize;

    public PageConstant() {
        this.currentPage = 1;
        this.pageSize = 10;
    }

    public PageConstant(int currentPage, int pageSize) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }
}
