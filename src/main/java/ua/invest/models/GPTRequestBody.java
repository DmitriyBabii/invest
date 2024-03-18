package ua.invest.models;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
public class GPTRequestBody {
    private final String model = "gpt-3.5-turbo";
    private final List<GPTMessage> messages;

    @Override
    public String toString() {
        return String.format("{\"model\":\"%s\",\"messages\":%s}", model, messages.toString());
    }
}