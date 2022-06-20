package com.vn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vn.entities.CinemaRoom;

@Repository
public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, String>{

	@Query("SELECT c FROM CinemaRoom c WHERE CONCAT(c.cinemaRoomName, ' ', c.cinemaRoomId, ' ') LIKE %?1%")
    public List<CinemaRoom> search(String keyword);
}
