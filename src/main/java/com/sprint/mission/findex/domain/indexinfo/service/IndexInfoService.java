package com.sprint.mission.findex.domain.indexinfo.service;

import static com.sprint.mission.findex.global.exception.ApiException.ERROR.INDEX_INFO_DUPLICATED;

import com.sprint.mission.findex.domain.autosync.entity.AutoSyncConfig;
import com.sprint.mission.findex.domain.autosync.repository.AutoSyncConfigRepository;
import com.sprint.mission.findex.domain.indexinfo.dto.IndexInfoCreateRequest;
import com.sprint.mission.findex.domain.indexinfo.dto.IndexInfoResponse;
import com.sprint.mission.findex.domain.indexinfo.entity.IndexInfo;
import com.sprint.mission.findex.domain.indexinfo.entity.SourceType;
import com.sprint.mission.findex.domain.indexinfo.mapper.IndexInfoMapper;
import com.sprint.mission.findex.domain.indexinfo.repository.IndexInfoRepository;
import com.sprint.mission.findex.global.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class IndexInfoService {

  private final IndexInfoRepository indexInfoRepository;
  private final AutoSyncConfigRepository autoSyncConfigRepository;

  private final IndexInfoMapper mapper;

  @Transactional
  public IndexInfoResponse createByUser(IndexInfoCreateRequest req) {
    IndexInfo indexInfo = create(req, SourceType.USER);
    return mapper.toResponse(indexInfo);
  }

  @Transactional
  public IndexInfo createByOpenAPI(IndexInfoCreateRequest req) {
    return create(req, SourceType.OPEN_API);
  }

  private IndexInfo create(IndexInfoCreateRequest req, SourceType sourceType) {
    if (indexInfoRepository.existsByIndexClassificationAndIndexName(
        req.indexClassification(), req.indexName())) {
      throw new ApiException(INDEX_INFO_DUPLICATED);
    }
    IndexInfo indexInfo = new IndexInfo(
        req.indexClassification(),
        req.indexName(),
        req.employedItemsCount(),
        req.basePointInTime(),
        req.baseIndex(),
        sourceType,
        req.favorite()
    );
    indexInfoRepository.save(indexInfo);
    autoSyncConfigRepository.save(new AutoSyncConfig(indexInfo));
    return indexInfo;
  }
}
