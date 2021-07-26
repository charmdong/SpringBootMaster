package com.donggun.persistence;

import org.springframework.data.repository.CrudRepository;

import com.donggun.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

}
