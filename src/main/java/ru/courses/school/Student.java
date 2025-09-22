package ru.courses.school;

import lombok.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.List;
import java.util.ArrayList;

@ToString
@EqualsAndHashCode
public class Student {

    @Getter
    @Setter
    private String name;
    private List<Integer> grades = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    @SneakyThrows
    public void addGrade(int grade) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:5352/checkGrade?grade="+grade);
        CloseableHttpResponse httpResponse = httpClient.execute(request);
        HttpEntity entity = httpResponse.getEntity();
        if(!Boolean.parseBoolean(EntityUtils.toString(entity))){
            throw new IllegalArgumentException(grade + " is wrong grade");
        }
        grades.add(grade);
    }

    @SneakyThrows
    public int raiting() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:5352/educ?sum="+grades.stream().mapToInt(x->x).sum());
        CloseableHttpResponse httpResponse = httpClient.execute(request);
        HttpEntity entity = httpResponse.getEntity();
        return Integer.parseInt(EntityUtils.toString(entity));
    }
}