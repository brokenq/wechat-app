package com.yihua.wechat.utils;

import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import org.springframework.util.StringUtils;

/**
 * Created by brokenq on 2015/7/21.
 */
public class XStreamMapperWrapper extends MapperWrapper {

    public XStreamMapperWrapper(Mapper wrapped) {
        super(wrapped);
    }

    @Override
    public String serializedMember(Class type, String memberName) {
        if (!StringUtils.isEmpty(memberName)) {
            memberName = memberName.substring(0, 1).toUpperCase() + memberName.substring(1);
        }
        return super.serializedMember(type, memberName);
    }

}
