package com.sunny.enterprise.general.general.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartBeatController {

  @RequestMapping("/readiness")
  public ResponseEntity<String> getLiveness() {
    return ResponseEntity.ok("Ready");
  }
}
