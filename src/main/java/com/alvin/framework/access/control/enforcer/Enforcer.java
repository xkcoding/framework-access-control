package com.alvin.framework.access.control.enforcer;

import com.alvin.framework.access.control.group.Group;
import com.alvin.framework.access.control.hierarchy.Hierarchy;
import com.alvin.framework.access.control.model.Resource;
import com.alvin.framework.access.control.model.Subject;
import com.alvin.framework.access.control.policy.Policy;
import com.alvin.framework.access.control.result.Result;

import java.util.List;

/**
 * datetime 2019/5/16 20:04
 *
 * @author sin5
 */
public interface Enforcer {

    /**
     * enforce access
     *
     * @param subject subject
     * @param resource resource
     * @param action action
     * @param <S> class extends Subject
     * @param <R> class extends Resource
     * @return Result
     */
    <S extends Subject, R extends Resource> Result enforce(S subject, R resource, String action);

    /**
     * list all permitted actions
     *
     * @param subject subject
     * @param resource resource
     * @param <S> class extends Subject
     * @param <R> class extends Resource
     * @return list of action
     */
    <S extends Subject, R extends Resource> List<String> permittedActions(S subject, R resource);

    /**
     * list all denied actions
     *
     * @param subject subject
     * @param resource resource
     * @param <S> class extends Subject
     * @param <R> class extends Resource
     * @return list of action
     */
    <S extends Subject, R extends Resource> List<String> deniedActions(S subject, R resource);

    /**
     * add policy
     *
     * @param policy policy
     */
    void addPolicy(Policy policy);

    /**
     * add role hierarchy
     * superior get all permission of inferior
     *
     * @param hierarchy hierarchy
     */
    void addRoleHierarchy(Hierarchy hierarchy);

    /**
     * add data group
     *
     * @param group group
     */
    void addDataGroup(Group group);

    /**
     * add action group
     *
     * @param group group
     */
    void addActionGroup(Group group);
}