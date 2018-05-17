package org.soft.assignment.service;

import org.soft.assignment.model.BaseObject;

public interface DeleteService<T extends BaseObject> {
    void delete(T object);

    void delete(String id);
}
