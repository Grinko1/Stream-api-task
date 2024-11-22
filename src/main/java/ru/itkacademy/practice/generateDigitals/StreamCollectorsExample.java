package ru.itkacademy.practice.generateDigitals;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
* Создайте список заказов с разными продуктами и их стоимостями.
* Группируйте заказы по продуктам.
* Для каждого продукта найдите общую стоимость всех заказов.
* Отсортируйте продукты по убыванию общей стоимости.
Выберите три самых дорогих продукта.
Выведите результат: список трех самых дорогих продуктов и их общая стоимость.
* */

public class StreamCollectorsExample {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0),
                new Order("Watch", 1500.0),
                new Order("Watch", 500.0),
                new Order("Watch", 900.0)
        );
        // Группируем заказы по продуктам
        Map<String,List<Order>> groupList =  orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct));

        //Для каждого продукта найдите общую стоимость всех заказов
        Map<String, Double> totalCostPerProduct = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct,
                        Collectors.summingDouble(Order::getCost)));

        // Сортируем по убыванию общей стоимости
        List<Map.Entry<String, Double>> sortedProducts = totalCostPerProduct.entrySet().stream()
                .sorted((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()))
                .collect(Collectors.toList());
        System.out.println(sortedProducts);

        // Выбираем три самых дорогих продукта
        List<Map.Entry<String, Double>> topProducts = sortedProducts.stream()
                .limit(3)
                .collect(Collectors.toList());

        // три самых дорогих продукта и их общая стоимость
        System.out.println("Top 3 most expensive products:");
        System.out.println(topProducts);
    }

}
