package com.assignment.roomba.entities;

public class RequestResponse {
    public InputJson inputJson;
    public OutputJson outputJson;
    
    public RequestResponse(){
    }
    
    public RequestResponse(InputJson input, OutputJson output){
        this.inputJson = input;
        this.outputJson = output;
    }

    @Override
    public String toString() {
        return "RequestResponse{" + "inputJson=" + inputJson + ", outputJson=" + outputJson + '}';
    }
    
    
}
