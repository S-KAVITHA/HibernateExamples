package com.javatpoint.mypackage;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name="categories")
public class Categories {
            @Id
            @Column(name="c_id")
            private int cate_id;
            
            @Column(name="c_name")
            private String cate_name;
            
            @ManyToMany(targetEntity=Items.class, cascade=CascadeType.ALL, fetch = FetchType.LAZY)
            @JoinTable(name="cate_items",joinColumns=@JoinColumn(name="c_id_fk",referencedColumnName="c_id"),inverseJoinColumns=@JoinColumn(name="item_id_fk",referencedColumnName="i_id"))
            private Set items;
            
            public int getCate_id() {
                        return cate_id;
            }
            public void setCate_id(int cate_id) {
                        this.cate_id = cate_id;
            }
            public String getCate_name() {
                        return cate_name;
            }
            public void setCate_name(String cate_name) {
                        this.cate_name = cate_name;
            }
            public Set getItems() {
                        return items;
            }
            public void setItems(Set items) {
                        this.items = items;
            }
  } 

