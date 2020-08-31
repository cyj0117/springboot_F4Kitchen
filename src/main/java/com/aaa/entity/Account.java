package com.aaa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Date;

@Data
public class Account implements UserDetails {

    private Integer aid;

    private String account;

    private String pwd;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    private Integer enable;

    private Integer isaccountnonexpired;

    private Integer isaccountnonlocked;

    private Integer iscredentialsnonexpired;

    private Integer isenabled;

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.pwd;
    }

    @Override
    public String getUsername() {
        return this.account;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isaccountnonexpired == 1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isaccountnonlocked == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.iscredentialsnonexpired == 1;
    }

    @Override
    public boolean isEnabled() {
        return this.enable == 1;
    }
}