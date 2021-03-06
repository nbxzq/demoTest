package cn.sweet.wife.model;

import org.apache.commons.lang3.StringUtils;

/**
 * @author ziqiang.xia
 */
public class ResourcePoolConfig {
    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    private ResourcePoolConfig(Builder builder){
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }
    public static ResourcePoolConfig.Builder builder(){
        return new ResourcePoolConfig.Builder();
    }
    //...省略getter方法...
    public static class Builder{
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;
        private String name;
        private int maxTotal;
        private int maxIdle;
        private int minIdle;

        public ResourcePoolConfig build(){
            // 校验逻辑放到这里来做，包括必填项校验、依赖关系校验、约束条件校验等
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("...");
            }
            return new ResourcePoolConfig(this);
        }
        public Builder setName(String name){
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("...");
            }
            this.name = name;
            return this;
        }
    }
}
