package com.moviebs.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebs.model.*;


@Repository

//inherits a set of CRUD operations
public interface TicketRepository extends JpaRepository<Ticket, Integer>
{

}
