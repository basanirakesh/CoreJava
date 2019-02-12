package com.br.random;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map<Employee, String> map = new HashMap<>();

        Employee e1 = new Employee();
        e1.id = 1;
        e1.name = "Rakesh";

        map.put(e1, "XYZ");

        Employee e2 = new Employee();
        e2.id = 2;
        e2.name = "Rakesh";

        map.put(e2, "ABC");

        System.out.println(map);
    }

    static class Employee {
        int id;
        String name;
        String department;

        @Override
        public boolean equals(Object obj) {
            Employee emp = (Employee) obj;
            return this.name.equals(emp.name);
//            return this.id == emp.id;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }
}
