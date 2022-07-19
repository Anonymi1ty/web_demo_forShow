package utils;

import javax.servlet.http.Cookie;

public class Cookie_Utils {
    /**
     * 查找指定名称的Cookie对象
     * @param name Cookie的名称
     * @param cookies Cookie数组
     * @return 结果正常返回cookie，没有返回null
     */
    public static Cookie findCookie(String name,Cookie[] cookies){
        if (name==null || cookies==null || cookies.length==0)
            return null;

        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
