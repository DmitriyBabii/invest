package ua.invest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class GPTMessage {
    private final String role;
    private final String content;

    @Override
    public String toString() {
        return String.format("{\"role\":\"%s\",\"content\":\"%s\"}", role, content);
    }
}
