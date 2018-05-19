package com.e3.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SMD on 2018/5/14.
 */
public class PagesInfo implements Serializable{

    private Integer total;

    private List<?> rows;


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
