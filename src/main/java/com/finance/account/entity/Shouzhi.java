package com.finance.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 收支明细表
 * @TableName shouzhi
 */
@TableName(value ="shouzhi")
@Data
public class Shouzhi implements Serializable {
    /**
     * 收支id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 时间(YYYY-MM-DD HH：MM：SS)
     */
    @TableField(value = "time")
    private Date time;

    /**
     * 收入
     */
    @TableField(value = "income")
    private String income;

    /**
     * 支出
     */
    @TableField(value = "expenses")
    private String expenses;

    /**
     * 类别
     */
    @TableField(value = "category")
    private String category;

    /**
     * 备注
     */
    @TableField(value = "notes")
    private String notes;

    /**
     * 隶属于
     */
    @TableField(value = "belong")
    private String belong;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Shouzhi other = (Shouzhi) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getIncome() == null ? other.getIncome() == null : this.getIncome().equals(other.getIncome()))
            && (this.getExpenses() == null ? other.getExpenses() == null : this.getExpenses().equals(other.getExpenses()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getNotes() == null ? other.getNotes() == null : this.getNotes().equals(other.getNotes()))
            && (this.getBelong() == null ? other.getBelong() == null : this.getBelong().equals(other.getBelong()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getIncome() == null) ? 0 : getIncome().hashCode());
        result = prime * result + ((getExpenses() == null) ? 0 : getExpenses().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getNotes() == null) ? 0 : getNotes().hashCode());
        result = prime * result + ((getBelong() == null) ? 0 : getBelong().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", time=").append(time);
        sb.append(", income=").append(income);
        sb.append(", expenses=").append(expenses);
        sb.append(", category=").append(category);
        sb.append(", notes=").append(notes);
        sb.append(", belong=").append(belong);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}