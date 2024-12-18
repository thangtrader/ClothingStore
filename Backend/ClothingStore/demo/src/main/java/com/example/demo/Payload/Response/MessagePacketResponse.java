package com.example.demo.Payload.Response;

import com.example.demo.Payload.Request.CreateMessageRequest;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessagePacketResponse extends CreateMessageRequest {
    private long createAt;

    @Override
    public String toString() {
        return "MessagePacketResponse{" +
                "senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", content='" + content + '\'' +
                ", time=" + createAt +
                '}';
    }
}
