package com.example.jobrunr.bug.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/jobs")
class JobController(
  val jobService: JobService,
) {
  @GetMapping("/enqueue/normal")
  fun enqueueJob() {
    jobService.enqueueNormalJob(JobPayload(1, 2))
  }

  @GetMapping("/enqueue/bug")
  fun enqueueBugJob() {
    jobService.enqueueBugJob(JobPayload(2, 1))
  }
}
