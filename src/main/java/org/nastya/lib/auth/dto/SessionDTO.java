package org.nastya.lib.auth.dto;

import lombok.Value;

@Value
public class SessionDTO {
    int id;
    String sessionId;
    int userId;

    public SessionDTO(int id,
                      String sessionId,
                      int userId) {
        this.id = id;
        this.sessionId = sessionId;
        this.userId = userId;
    }

    public SessionDTO(SessionDTO dto, String sessionId){
        this.id = dto.id;
        this.userId = dto.userId;
        this.sessionId = sessionId;
    }
}
