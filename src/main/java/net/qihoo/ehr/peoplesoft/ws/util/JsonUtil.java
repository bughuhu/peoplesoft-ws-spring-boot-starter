package net.qihoo.ehr.peoplesoft.ws.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import net.sf.json.JSONObject;

/**
 * @author Carrot
 * @date 2020/09/14 ---------------------------------------------------- 版本 描述
 *       v1.0 Json转换工具类
 *       <p>
 *       ----------------------------------------------------
 */
public class JsonUtil {

	/**
	 * Json多层数据结构转换成xml
	 * 
	 * @param json
	 * @return
	 */
	public static String Json2XmlString(String jsonStr) {

		JSONObject json = JSONObject.fromObject(jsonStr);

		StringBuffer sb = new StringBuffer();
		for (Object key : json.keySet()) {

			sb.append("<").append(key).append(">");
			Object value = json.get(key);

			sb.append(iteraorJson(value));
			sb.append("</").append(key).append(">");

		}

		return sb.toString();
	}

	/**
	 * 迭代判断value是否还包含jSONObject
	 * 
	 * @param value
	 * @return
	 */
	public static String iteraorJson(Object value) {

		StringBuffer sb = new StringBuffer("");
		if ((value.toString().contains(":"))) {
			JSONObject json = ((JSONObject) value);
			for (Object key : json.keySet()) {
				if (!("REQUEST").equalsIgnoreCase(key.toString())) {
					sb.append("<").append(key).append(">");
					Object value2 = json.get(key);
					sb.append(iteraorJson(value2));
					sb.append("</").append(key).append(">");
				}else {
					Object value2 = json.get(key);
					sb.append("<").append(key).append(">").append(value2).append("</").append(key).append(">");
				}
			}
		} else {
			sb.append(value);
		}
		return sb.toString();
	}

	
	
	/**
	 * xml string字符串转换成JSON
	 * @param xmlStr
	 * @return
	 */
	public static JSONObject xmlString2Json(String xmlStr){	
		JSONObject json = new JSONObject();  
        try {  
            InputStream is = new ByteArrayInputStream(xmlStr.getBytes("utf-8"));  
            SAXBuilder sb = new SAXBuilder();  
            Document doc = sb.build(is);  
            Element root = doc.getRootElement();  
            json.put(root.getName(), iterateElement(root));  
            
            return json;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;
        }
	}
	
	
	 /**
	  * 迭代 
	  * @param element
	  * @return
	  */
   @SuppressWarnings("unchecked")
	private static Map<String,Object>  iterateElement(Element element) {  
       List<Element> jiedian = element.getChildren();  
       Element et = null;  
       Map<String,Object> obj = new HashMap<String,Object>();  
       List<Object> list = null;  
       for (int i = 0; i < jiedian.size(); i++) {  
           list = new LinkedList<Object>();  
           et = (Element) jiedian.get(i);  
           if (et.getTextTrim().equals("")) {  
               if (et.getChildren().size() == 0)  
                   continue;  
               if (obj.containsKey(et.getName())) {  
                   list = (List<Object>) obj.get(et.getName());  
               }  
               list.add(iterateElement(et));  
               obj.put(et.getName(), list);  
           } else {  
               if (obj.containsKey(et.getName())) {  
                   list = (List<Object>) obj.get(et.getName());  
               }  
               list.add(et.getTextTrim());  
               obj.put(et.getName(), list);  
           }  
       }  
       return obj;  
   } 
}
