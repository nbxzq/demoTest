package cn.sweet.wife.model.builderModel;

/**
 * @author ziqiang.xia
 *
 * ConcreteBuilder
 */

public class HawaiianPizzaBuilder extends PizzaBuilder{
    @Override
    public void buildDough() {
        pizza.setDough("cross");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("mild");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping("ham+pineapple");
    }
}
