package com.smile.admin.common;

import com.smile.admin.bean.dto.SecurityUser;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Set;

/**
 * 
 * @author gaowenjin
 * @date 2021/1/28
 * @description:
 */
public class PrincipalUtils {

    private PrincipalUtils() {
    }

    private static final String PRINCIPAL_ID = "principal.id";
    private static final String PRINCIPAL_ROLES = "principal.roles";

    public static void login(SecurityUser user) {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        requestAttributes.setAttribute(PRINCIPAL_ID, user.getId(), RequestAttributes.SCOPE_SESSION);
        requestAttributes.setAttribute(PRINCIPAL_ROLES, user.getRoles(), RequestAttributes.SCOPE_SESSION);

    }

    public static <T> T get(String key, Class<T> clazz) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return (T) requestAttributes.getAttribute(key, RequestAttributes.SCOPE_SESSION);
    }

    public static String id() {
        return get(PRINCIPAL_ID, String.class);
    }

    public static Set<String> roles() {
        return get(PRINCIPAL_ROLES, Set.class);
    }

}
