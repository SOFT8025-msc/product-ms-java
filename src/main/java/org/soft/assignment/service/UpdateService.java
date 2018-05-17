package org.soft.assignment.service;

import org.soft.assignment.model.BaseObject;

public interface UpdateService<T extends BaseObject> {
    T update(T object);
}
