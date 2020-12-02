package com.simbirsoft.spring_demo.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(Permission.AUTHOR_READ, Permission.BOOK_READ, Permission.PUBLISHER_READ)),
    ADMIN(Set.of(Permission.AUTHOR_READ, Permission.BOOK_READ, Permission.PUBLISHER_READ,
            Permission.AUTHOR_WRITE, Permission.BOOK_WRITE, Permission.PUBLISHER_WRITE));

    private Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }
    public Set<Permission>getPermissions(){
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}