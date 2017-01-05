package com.rxwx.core.page;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import com.github.pagehelper.PageInfo;

public class PageObjectFactory extends DefaultObjectFactory {

    private static final long serialVersionUID = 3963031299778136554L;

    /**
     * 如果类型为page的话让其也判断为集合
     */
    public <T> boolean isCollection(Class<T> type) {
        if (type == PageInfo.class) {
            return true;
        }
        return super.isCollection(type);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T> T create(Class<T> type) {
        if (type == PageInfo.class) {
            return (T) new PageInfo();
        }
        return create(type, null, null);
    }
}