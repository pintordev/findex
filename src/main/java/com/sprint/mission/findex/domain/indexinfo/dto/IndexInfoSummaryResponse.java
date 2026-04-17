package com.sprint.mission.findex.domain.indexinfo.dto;

import java.util.UUID;

public record IndexInfoSummaryResponse(
    UUID id,
    String indexClassification,
    String indexName
) {

}
