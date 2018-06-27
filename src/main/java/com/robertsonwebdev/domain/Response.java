package com.robertsonwebdev.domain;



public class Response {

    int id;
    String content;

    public int getId(){ return this.id; }
    public String getContent(){ return this.content; }

    public Response(int i, String s){
        this.id = i;
        this.content = s;
    }
}
