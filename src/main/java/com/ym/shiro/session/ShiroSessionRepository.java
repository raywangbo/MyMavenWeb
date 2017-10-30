package com.ym.shiro.session;

import org.apache.shiro.session.Session;

import java.io.Serializable;
import java.util.Collection;

/**
 * Session操作
 *
 * @auther Administrator Ray
 * @create 2017/10/30
 */
public interface ShiroSessionRepository {

    /**
     * 存储Session
     * @param session
     */
    void saveSession(Session session);

    /**
     * 删除Session
     * @param session
     */
    void deleteSession(Session session);

    /**
     * 获取Session
     * @param sessionId
     * @return
     */
    Session getSession(Serializable sessionId);

    /**
     * 获取所有Session
     * @return
     */
    Collection<Session> getAllSession();
}
