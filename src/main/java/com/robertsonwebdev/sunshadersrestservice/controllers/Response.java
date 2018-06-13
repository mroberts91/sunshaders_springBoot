package com.robertsonwebdev.sunshadersrestservice.controllers;


public class Response {

    int id;
    String content;

    public int getId(){ return this.id; }
    public String getContent(){ return this.content; }

    public Response(int num, String str){
        this.id = num;
        this.content = str;
    }
}
