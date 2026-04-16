package com.sprint.mission.findex.domain.indexinfo.service;

import com.sprint.mission.findex.domain.autosync.repository.AutoSyncConfigRepository;
import com.sprint.mission.findex.domain.indexdata.repository.IndexDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class IndexInfoService {

  private final IndexDataRepository indexDataRepository;
  private final AutoSyncConfigRepository autoSyncConfigRepository;
}
