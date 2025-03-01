package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class Handler extends TextWebSocketHandler {
    private static List<WebSocketSession> list = new ArrayList<>();
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload : " + payload + list.size());
        //페이로드란 전송되는 데이터를 의미한다.
        for(WebSocketSession sess: list) {
            sess.sendMessage(message);
        }
    }
    /* Client가 접속 시 호출되는 메서드1 */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        list.add(session);
        log.info(session.getId()+ " 클라이언트 접속");
        for (WebSocketSession sess : list) {
            sess.sendMessage(new TextMessage("!@3"));
        }
    }
    /* Client가 접속 해제 시 호출되는 메서드드 */

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info(session.getId() + " 클라이언트 접속 해제" + list.size());
        list.remove(session);
    }
}
