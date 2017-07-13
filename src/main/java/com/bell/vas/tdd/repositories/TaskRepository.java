package com.bell.vas.tdd.repositories;

import org.springframework.data.repository.CrudRepository;
import com.bell.vas.tdd.domain.Task;

import java.util.Optional;

/**
 * Created by Boualem on 2017-07-12.
 */
public interface TaskRepository extends CrudRepository<Task, Integer> {

    Optional<Task> findOneByName (String name);
}
