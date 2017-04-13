/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mack.entity;

import java.io.Serializable;

/**
 *
 * @author 31595472
 */
public class Actor implements Serializable{
    private String name;

    public Actor() {
    }

    public Actor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Actor{" + "name=" + name + '}';
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
