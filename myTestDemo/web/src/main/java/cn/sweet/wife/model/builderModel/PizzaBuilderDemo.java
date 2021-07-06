package cn.sweet.wife.model.builderModel;

/**
 * @author ziqiang.xia
 */
public class PizzaBuilderDemo {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder hawaiianPizzabuilder = new HawaiianPizzaBuilder();
        waiter.setPizzaBuilder( hawaiianPizzabuilder );
        waiter.constructPizza();
        Pizza pizza = waiter.getPizza();

        System.out.println("$10:"+pizza);

    }
}
