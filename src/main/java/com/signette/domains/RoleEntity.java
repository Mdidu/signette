package com.signette.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Role", schema = "public", catalog = "SIGNETTE")
public class RoleEntity {
    private int roleId;
    private String roleType;

    @Id
    @Column(name = "role_id", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_type", nullable = false, length = 20)
    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return roleId == that.roleId && Objects.equals(roleType, that.roleType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleType);
    }
}