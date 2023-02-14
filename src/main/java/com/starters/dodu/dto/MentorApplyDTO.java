package com.starters.dodu.dto;

import com.starters.dodu.domain.Apply;
import com.starters.dodu.domain.Mentee;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class MentorApplyDTO {
  private UUID id;
  private Timestamp matchTime1;
  private Timestamp matchTime2;
  private Timestamp matchTime3;
  private String status;
  private LocalDateTime indate;
  private Mentee mentee;

  public MentorApplyDTO(Apply entity) {
    this.id = entity.getId();
    this.matchTime1 = entity.getMatchTime1();
    this.matchTime2 = entity.getMatchTime2();
    this.matchTime3 = entity.getMatchTime3();
    this.status = entity.getStatus();
    this.indate = entity.getIndate();
    this.mentee = entity.getMentee();
  }
}
