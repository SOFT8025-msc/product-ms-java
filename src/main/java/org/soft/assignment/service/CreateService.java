package org.soft.assignment.service;

import org.soft.assignment.model.BaseObject;

public interface CreateService<T extends BaseObject> {
    T create(T object);
}
