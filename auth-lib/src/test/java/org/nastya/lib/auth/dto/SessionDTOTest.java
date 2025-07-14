package org.nastya.lib.auth.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SessionDTOTest {
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void test() throws JsonProcessingException {
        String sessionDtoJson = "{\"id\": 1, \"sessionId\": \"sfhsw14hfqw\", \"userId\": 12}";
        SessionDTO sessionDTO = objectMapper.readValue(sessionDtoJson, SessionDTO.class);
        Assertions.assertNotNull(sessionDTO);
        Assertions.assertEquals(1, sessionDTO.getId());
        Assertions.assertEquals("sfhsw14hfqw", sessionDTO.getSessionId());
        Assertions.assertEquals(12, sessionDTO.getUserId());
    }
}