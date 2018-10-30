package com.needayeah.elasticsearch.repository;

import com.needayeah.elasticsearch.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    List<Role> findRolesByUserID(long userId);

}
