package cn.sweet.wife.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author ziqiang.xia
 */
public class Apple {
    private final String color;
    private String size;
    private static Double prise;

    Apple(String color, String size) {
        this.color = color;
        this.size = size;
    }

    public static Apple.AppleBuilder builder() {
        return new Apple.AppleBuilder();
    }

    public static class AppleBuilder {
        private String color;
        private String size;
        private static Double prise;

        AppleBuilder() {
        }

        public Apple.AppleBuilder color(String color) {
            this.color = color;
            return this;
        }

        public Apple.AppleBuilder size(String size) {
            this.size = size;
            return this;
        }

        public Apple.AppleBuilder prise(Double prise) {
            Apple.prise = prise;
            return this;
        }

        public Apple build() {
            return new Apple(this.color, this.size);
        }

        @Override
        public String toString() {
            return "Apple.AppleBuilder(color=" + this.color + ", size=" + this.size +", prise="+Apple.prise+ ")";
        }

    }
    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public static Double getPrise() {
        return prise;
    }

    @Override
    public String toString() {
        return "Apple(color=" + this.color + ", size=" + this.size +", prise="+Apple.prise+ ")";
    }
}
