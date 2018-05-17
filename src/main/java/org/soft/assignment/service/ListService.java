package org.soft.assignment.service;

import org.soft.assignment.model.BaseObject;

import java.util.List;

public interface ListService<T extends BaseObject> {
    List<T> list();
}
