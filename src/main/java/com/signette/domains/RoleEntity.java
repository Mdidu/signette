package com.signette.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Role", schema = "public", catalog = "SIGNETTE")
public class RoleEntity {
    private int roleId;
    private ERole roleType;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ROLE_SEQ")
    @SequenceGenerator(name = "ROLE_SEQ", sequenceName = "ROLE_SEQ", allocationSize = 1)
    @Column(name = "role_id", unique = true, nullable = false, precision = 22, scale = 0)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "role_type", unique = true, nullable = false, length = 20)
    public ERole getRoleType() {
        return roleType;
    }

    public void setRoleType(ERole roleType) {
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
