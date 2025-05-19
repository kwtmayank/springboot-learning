package com.learning.springboot.hateoas;

import org.springframework.hateoas.Link;

import java.util.ArrayList;
import java.util.List;

public class HateoasLinks {

    private List<Link> list = new ArrayList<Link>();

    public void addLink(Link link){
        list.add(link);
    }

    public List<Link> getLinks(){
        return list;
    }

}
