package com.sangwon.springlv3backoffice.admin.enums;

public enum Role {
    STAFF(Authority.USER),  // 사용자 권한
    MANAGER(Authority.ADMIN);  // 관리자 권한

    private final String authority;

    Role(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }

    public static class Authority {
        public static final String USER = "ROLE_STAFF";
        public static final String ADMIN = "ROLE_MANAGER";
    }
}
