package cn.edu.scau.employee.web.config.shiro;

import lombok.Data;

/**
 * shiro常用变量
 *
 * @author chen.jiale
 * @date 2019/11/14 19:32
 */
@Data
public class ShiroProperties {
    private String loginUrl;

    private String logoutUrl;

    private String indexUrl;

    private String allUrl;

    private String webjarsUrl;

    private String swaggerUiUrl;

    private String swaggerResourceUrl;

    private String apiDocsUrl;

    private String authcToken;

    private String anon;

    private int iteration;

    private String algorithm;

}
