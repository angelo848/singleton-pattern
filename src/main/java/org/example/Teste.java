package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Teste {
    public static void main(String[] args) {
      String line;
      ExecutorService executorService = Executors.newFixedThreadPool(8);
      try (BufferedReader br = new BufferedReader(new InputStreamReader(
          Objects.requireNonNull(Teste.class.getResourceAsStream("/devices.csv"))))) {
        br.readLine(); // Skip header
        while ((line = br.readLine()) != null) {
          String finalLine = line;
          executorService.submit(() ->
            System.out.println(finalLine), line);
        }

      } catch (IOException e) {
        throw new RuntimeException(e);
      }

      executorService.close();


//      String line;
//      try (BufferedReader br = new BufferedReader(new InputStreamReader(
//          Objects.requireNonNull(Teste.class.getResourceAsStream("/devices.csv"))))) {
//        br.readLine(); // Skip header
//        while ((line = br.readLine()) != null) {
//          System.out.println(line);
//        }
//      } catch (IOException e) {
//        throw new RuntimeException(e);
//      }

    }
}
