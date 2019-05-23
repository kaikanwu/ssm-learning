package com.kk.learn.ssm.chapter3.mapper;

import com.kk.learn.ssm.chapter3.pojo.Role;
import org.apache.ibatis.annotations.Select;

/**
 * @author kaikanwu
 * @date 5/22/2019
 */
public interface RoleMapper2 {


    @Select("select id, role_name as roleName, note from t_role where id = #{id}")
    public Role getRole(Long id);
}
