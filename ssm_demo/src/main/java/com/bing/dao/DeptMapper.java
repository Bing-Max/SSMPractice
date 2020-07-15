package com.bing.dao;

import com.bing.entity.Department;
import java.util.List;

public interface DeptMapper {

    public List<Department> getAll();

    public void add(Department department);

    public Department getById(int id);
}
