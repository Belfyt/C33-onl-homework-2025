package homework23;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        String jsonString = "{ \"id\": 1, \"name\": \"Стас\", \"age\": 20 }";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            User user = objectMapper.readValue(jsonString, User.class);

            System.out.println("ID: " + user.getId());
            System.out.println("Name: " + user.getName());
            System.out.println("Age: " + user.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}