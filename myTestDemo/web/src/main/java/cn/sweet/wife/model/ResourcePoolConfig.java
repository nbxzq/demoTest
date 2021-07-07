package cn.sweet.wife.model;

import org.apache.commons.lang3.StringUtils;

/**
 * @author ziqiang.xia
 */
public class ResourcePoolConfig {
//    private String name;
//    private int maxTotal;
//    private int maxIdle;
//    private int minIdle;
//
//    private ResourcePoolConfig(Builder builder){
//        this.name = builder.name;
//        this.maxTotal = builder.maxTotal;
//        this.maxIdle = builder.maxIdle;
//        this.minIdle = builder.minIdle;
//    }
//    //...省略getter方法...
//    public static class Builder{
//        private static final int DEFAULT_MAX_TOTAL = 8;
//        private static final int DEFAULT_MAX_IDLE = 8;
//        private static final int DEFAULT_MIN_IDLE = 0;
//        private String name;
//        private int maxTotal;
//        private int maxIdle;
//        private int minIdle;
//
//        public ResourcePoolConfig Build(){
//            // 校验逻辑放到这里来做，包括必填项校验、依赖关系校验、约束条件校验等
//            if (minIdle > maxTotal || minIdle > maxIdle) {
//                throw new IllegalArgumentException("...");
//            }
//            return new ResourcePoolConfig(this);
//        }
//        public Builder setName(String name){
//            if (StringUtils.isBlank(name)) {
//                throw new IllegalArgumentException("...");
//            }
//            this.name = name;
//            return this;
//        }
//    }
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;
        private int maxTotal;
        private int maxIdle;
        private int minIdle;

        public ResourcePoolConfig(String name,int maxTotal,int maxIdle,int minIdle){
            if(StringUtils.isEmpty(name)){
                throw new IllegalArgumentException("name should not be null!");
            }
            this.name = name;
            this.maxTotal = maxTotal;
            this.maxIdle = maxIdle;
            this.minIdle = minIdle;
        }

}
