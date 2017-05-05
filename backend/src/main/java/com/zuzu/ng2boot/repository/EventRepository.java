package com.zuzu.ng2boot.repository;

import com.zuzu.ng2boot.domain.Event;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ZPACHOLC on 05.05.2017.
 */
public interface EventRepository extends CrudRepository<Event, Long> {
}
