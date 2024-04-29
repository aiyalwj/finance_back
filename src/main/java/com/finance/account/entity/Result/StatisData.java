package com.finance.account.entity.Result;

import lombok.Data;

@Data
public class StatisData implements Comparable<StatisData>{
    private String name;
    private String value;

    @Override
    public int compareTo(StatisData o) {
        // 按照 name 字段的自然顺序进行比较
        return this.name.compareTo(o.name);
    }
}
