package com.sprint.mission.findex.domain.indexinfo.controller;

import com.sprint.mission.findex.domain.indexinfo.service.IndexInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/index-infos")
@RequiredArgsConstructor
@RestController
public class IndexInfoController {

  private final IndexInfoService indexInfoService;
}
