package com.valcos98.inventoryjavatry.repositories;

import org.springframework.data.repository.CrudRepository;

import com.valcos98.inventoryjavatry.Entities.UserTable;

public interface UserRepository extends CrudRepository<UserTable,Long>{    }
