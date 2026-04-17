package com.sprint.mission.findex.domain.indexinfo.repository.querydsl.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sprint.mission.findex.domain.indexinfo.repository.querydsl.IndexInfoCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class IndexInfoCustomRepositoryImpl implements IndexInfoCustomRepository {

  private final JPAQueryFactory queryFactory;
}
