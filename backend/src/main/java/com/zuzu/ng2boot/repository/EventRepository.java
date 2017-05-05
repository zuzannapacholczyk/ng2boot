package com.zuzu.ng2boot.repository;

import com.zuzu.ng2boot.domain.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by ZPACHOLC on 05.05.2017.
 */
public interface EventRepository extends CrudRepository<Event, Long> {

    @Query("from Event e where not(e.end < :from and e.start > :to)")
    public List<Event> findBetween(@Param("from") LocalDateTime start, @Param("to") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) LocalDateTime end);
}
