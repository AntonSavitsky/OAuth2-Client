package org.springsource.oauth;

import java.util.Enumeration;

/**
 * Created by asavitsky on 6/30/16.
 */
public class Permission {

    private String name;
    private Status status;

    public Permission(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

enum Status {
    granted, declined
}
