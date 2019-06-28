package com.rezzobg.services;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.http.HttpServletRequest;

@Getter
@Setter
public class UserStory {

    public static boolean isUserLogged(HttpServletRequest request) {
        return request.getSession().getAttribute("userId") != null;
    }

    public static  boolean isAdminLogged(HttpServletRequest request) {
        return request.getSession().getAttribute("isAdmin").equals(true);
    }
}
