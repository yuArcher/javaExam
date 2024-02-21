package com.test.exam;

public class ApplicationDemo {

    private long applePrice = 8l;
    private long stawberryPrice = 13l;
    private long mangoPrice = 20l;

    public static void main(String[] args) {

        ApplicationDemo run = new ApplicationDemo();

        // 第一题结果
        long firstTotalPrices = run.firstQuestion(5, 3);
        System.out.println("A 购买的水果斤数总价："+firstTotalPrices);

        // 第二题结果
        long secondTotalPrices = run.secondQuestion(5, 3,4);
        System.out.println("B 购买的水果斤数总价："+secondTotalPrices);

        // 第三题结果
        double thirdTotalPrices = run.thirdQuestion(5, 3,4);
        System.out.println("C 购买的水果斤数总价："+thirdTotalPrices);

        // 第四题结果
        double fourthTotalPrices = run.fourthQuestion(5, 3,4);
        System.out.println("D 购买的水果斤数总价："+fourthTotalPrices);


    }

    /**
     * 第一题
     * 1、有一家超市，出售苹果和草莓。其中苹果 8 元/斤，草莓 13 元/斤。
     * 现在顾客 A 在超市购买了若干斤苹果和草莓，需要计算一共多少钱？
     * 请编写函数，对于 A 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
     * @return
     */
    public long firstQuestion(int appleWeight, int stawberryWeight) {
        if (appleWeight < 0 || stawberryWeight < 0) {
            throw new Error("苹果跟草莓的重量必须大于等于0");
        }
        return appleWeight * applePrice + stawberryWeight * stawberryPrice;
    }

    /**
     * 第二题
     * 2、超市增加了一种水果芒果，其定价为 20 元/斤。
     * 现在顾客 B 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
     * 请编写函数，对于 B 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
     * @return
     */
    public long secondQuestion (int appleWeight, int stawberryWeight, int mangoWeight) {
        if (appleWeight < 0 || stawberryWeight < 0 || mangoWeight < 0) {
            throw new Error("苹果、草莓、芒果的重量必须大于等于0");
        }
        return firstQuestion(appleWeight,stawberryWeight) + mangoWeight * mangoPrice;
    }

    /**
     * 第三题
     * 3、超市做促销活动，草莓限时打 8 折。
     * 现在顾客 C 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
     * 请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
     */
    public double thirdQuestion (int appleWeight, int stawberryWeight, int mangoWeight) {
        if (appleWeight < 0 || stawberryWeight < 0 || mangoWeight < 0) {
            throw new Error("苹果、草莓、芒果的重量必须大于等于0");
        }
        return appleWeight*applePrice + stawberryWeight*stawberryPrice*0.8 + mangoWeight*mangoPrice;
    }

    /**
     * 第四题
     * 4、促销活动效果明显，超市继续加大促销力度，购物满 100 减 10 块。
     * 现在顾客 D 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
     * 请编写函数，对于 D 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
     */
    public double fourthQuestion (int appleWeight, int stawberryWeight, int mangoWeight) {
        if (appleWeight < 0 || stawberryWeight < 0 || mangoWeight < 0) {
            throw new Error("苹果、草莓、芒果的重量必须大于等于0");
        }
        double total = thirdQuestion(appleWeight, stawberryWeight, mangoWeight);
        if (total % 100 < 92) {
            // 根据实际情况，满100减10，一般顾客都会选择分段付费，即如果总价大于200，会选择分两次付款，每次付款的数额都大于100而且还可以得到优惠
            return Math.floor(total / 100) * 90 + total % 100;
        } else if (total % 100 >= 92) {
            // 如果金额差8块以内就会超过100，那么顾客会选择再购买一斤苹果，从而还会得到减10的优惠，即总价会减2元
            return Math.floor(total / 100) * 90 + total % 100 - 2;
        }
        return total;
    }
}
