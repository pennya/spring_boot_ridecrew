package com.ridecrew.springbootridecrew.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ridecrew.springbootridecrew.domain.Gallery;

@Repository
public interface GalleryRepository extends CrudRepository<Gallery, Long>{

}
