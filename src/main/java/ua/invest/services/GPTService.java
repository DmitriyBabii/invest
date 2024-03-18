package ua.invest.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GPTService {
    private static final String URL = "https://api.openai.com/v1/chat/completions";
    private static final String MODEL = "gpt-3.5-turbo";
    @Value("${openai.key}")
    private String API_KEY;

    public String send() {
//        try {
//            URL obj = new URL(URL);
//            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
//            connection.setRequestMethod("POST");
//            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
//            connection.setRequestProperty("Content-type", "application/json");
//            connection.setDoOutput(true);
//
//            GPTRequestBody body = new GPTRequestBody(Arrays.asList(
//                    new GPTMessage("system", "You are a poetic assistant, skilled in explaining complex programming concepts with creative flair"),
//                    new GPTMessage("user", "Compose a poem that explains the concept of recursion in programming")
//            ));
//
//            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
//            writer.write(body.toString());
//            writer.flush();
//            writer.close();
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String readLine;
//            StringBuffer response = new StringBuffer();
//            while ((readLine = reader.readLine()) != null) {
//                response.append(readLine);
//            }
//            reader.close();
//
//            return (response.toString());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return "";

        // TODO write a GPT realization
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(
                (request, body, execution) -> {
                    request.getHeaders().add("Authorization", "Bearer" + API_KEY);
                    return execution.execute(request, body);
                }
        );
        return "";
    }
}

