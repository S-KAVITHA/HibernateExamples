package com.javatpoint.mypackage;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name="items")
public class Items {
 
            @Id
            @Column(name="i_id")
            private int item_id;
            
            @Column(name="i_name")
            private String item_name;
            
            @ManyToMany(targetEntity=Categories.class,mappedBy="items", fetch = FetchType.LAZY)
            private Set categories;
            
            public int getItem_id() {
                        return item_id;
            }
            public void setItem_id(int item_id) {
                        this.item_id = item_id;
            }
            public String getItem_name() {
                        return item_name;
            }
            public void setItem_name(String item_name) {
                        this.item_name = item_name;
            }
            public Set getCategories() {
                        return categories;
            }
            public void setCategories(Set categories) {
                        this.categories = categories;
            }
  } 
