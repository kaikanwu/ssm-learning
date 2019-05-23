package com.kk.learn.ssm.chapter3.mapper;

import com.kk.learn.ssm.chapter3.pojo.Role;

import java.util.List;

/**
 * @author kaikanwu
 * @date 5/22/2019
 */
public interface RoleMapper {

    public int insertRole(Role role);

    public int deleteRole(Long id);

    public int updateRole(Role role);

    public Role getRole(Long id);

    public List<Role> findRoles(String roleName);
}
