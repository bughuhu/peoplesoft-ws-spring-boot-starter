package net.qihoo.ehr.peoplesoft.ws.constant;

/**
 * @author Carrot
 * @date 2020/09/14
 * ----------------------------------------------------
 * 版本   描述
 * v1.0   常用HTTP Content-Type常量
 * <p>
 * ----------------------------------------------------
 */
public class ContentType {
    //表单类型Content-Type
    public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded; charset=UTF-8";
    //表单类型Content-Type 带附件
    public static final String CONTENT_TYPE_FORM_FILE = "multipart/form-data; charset=UTF-8";
    // 流类型Content-Type
    public static final String CONTENT_TYPE_STREAM = "application/octet-stream; charset=UTF-8";
    //JSON类型Content-Type
    public static final String CONTENT_TYPE_JSON = "application/json; charset=UTF-8";
    //XML类型Content-Type
    public static final String CONTENT_TYPE_XML = "application/xml; charset=UTF-8";
    //文本类型Content-Type
    public static final String CONTENT_TYPE_TEXT = "application/text; charset=UTF-8";
}
