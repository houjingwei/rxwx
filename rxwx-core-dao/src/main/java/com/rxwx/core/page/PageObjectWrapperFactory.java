package com.rxwx.core.page;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectionException;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;

import com.github.pagehelper.PageInfo;
public class PageObjectWrapperFactory extends DefaultObjectWrapperFactory{

    @Override
    public boolean hasWrapperFor(Object object) {
        if(object instanceof PageInfo){
            return true;
        }
        return false;
    }

    @SuppressWarnings("rawtypes")
	@Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        if(object instanceof PageInfo){
            return new PageObjectWrapper((PageInfo)object);
        }
        throw new ReflectionException("The DefaultObjectWrapperFactory should never be called to provide an ObjectWrapper.");
    }
}