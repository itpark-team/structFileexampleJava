package com.company;

import java.io.*;

public class Main {

    static class Man implements Serializable {
        public int age;
        public String name;
        public char gender;

        public Man(int age, String name, char gender) {
            this.age = age;
            this.name = name;
            this.gender = gender;
        }
    }

    static void printlnMan(Man man) {
        System.out.println(String.format("name - %s age - %d gender - %c", man.name, man.age, man.gender));
    }

    static void saveManToTxtFile(String filename, Man man) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(Integer.toString(man.age));
        bufferedWriter.newLine();

        bufferedWriter.write(man.name);
        bufferedWriter.newLine();

        bufferedWriter.write(Character.toString(man.gender));
        bufferedWriter.newLine();

        bufferedWriter.close();
        fileWriter.close();
    }

    static Man loadManFromTxtFile(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int age = Integer.parseInt(bufferedReader.readLine());
        String name = bufferedReader.readLine();
        char gender = bufferedReader.readLine().charAt(0);

        bufferedReader.close();
        fileReader.close();

        return new Man(age, name, gender);
    }

    static void saveManToBinFile(String filename, Man man) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(man);

        objectOutputStream.close();
        fileOutputStream.close();
    }

    static Man loadManFromBinFile(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Man man = (Man) objectInputStream.readObject();

        objectInputStream.close();
        fileInputStream.close();

        return man;
    }


    static void savePeopleToBinFile(String filename, Man[] people) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(people);

        objectOutputStream.close();
        fileOutputStream.close();
    }

    static Man[] loadPeopleFromBinFile(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Man[] people = (Man[]) objectInputStream.readObject();

        objectInputStream.close();
        fileInputStream.close();

        return people;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Man man = new Man(12, "sdfs", 'm');
        //Man man = loadManFromTxtFile("output1.txt");
        //Man man = loadManFromBinFile("output2.txt");
        //printMan(man);
        //saveManToBinFile("output2.txt", man);
        //saveManToTxtFile("output1.txt", man);

        /*Man[] people = new Man[]{
            new Man(12, "sdfs", 'm'),
            new Man(42, "sdgd", 'f'),
            new Man(16, "ssadasdfs", 'x'),
        };

        savePeopleToBinFile("output3.txt", people);*/

        Man[] people = loadPeopleFromBinFile("output3.txt");
        for (int i = 0; i < people.length; i++) {
            printlnMan(people[i]);
        }
    }
}
