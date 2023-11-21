package org.sopt.cdsserver.heart.controller.dto.response;

import org.sopt.cdsserver.heart.domain.Heart;

import java.util.Optional;

public record HeartPutResponse(
        boolean isMade
) {
    public static HeartPutResponse of( Heart heart){
        return new HeartPutResponse(heart != null);  //not null 일때가 true
    }


}
