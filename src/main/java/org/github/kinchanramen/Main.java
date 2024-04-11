package org.github.kinchanramen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Shift を 2 回押して 'どこでも検索' ダイアログを開き、`show whitespaces` と入力して
// Enter キーを押します。これでコードに空白文字が表示されます。
public class Main {
    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int age = 25;
        double weight = 65.5;
        String name = "John";
        if (age >= 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are a minor.");
        }

// メソッドの呼び出し
        int result = add(5, 3);
        System.out.println("Result: " + result);
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("First element: " + numbers[0]);
        //jsonに複数のpersonを入れたいのでList化
        List<Person> personList=new ArrayList<>();
        Person Alice=new Person("Alice",18,"USA","Female");
        Person Bob=new Person("Bob",35,"USA","Female");
        personList.add(Alice);
        personList.add(Bob);
        //jsonの整形
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String json= gson.toJson(personList);
        System.out.println(json);
        try(FileWriter writer=new FileWriter("person.json")) {
            //jsonの書き出し
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
