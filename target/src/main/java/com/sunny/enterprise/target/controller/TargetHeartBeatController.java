package com.sunny.enterprise.target.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heartbeat")
public class TargetHeartBeatController {

  @RequestMapping("/liveness")
  public ResponseEntity<String> getLiveness() {
    return ResponseEntity.ok("Alive");
  }
}
