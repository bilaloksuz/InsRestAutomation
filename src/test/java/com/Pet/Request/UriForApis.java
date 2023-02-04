package com.Pet.Request;

import com.Common.Base.Config;
import com.Common.Clients.RestTrigger;
import kong.unirest.HttpResponse;

public class UriForApis  {

    transient RestTrigger restTrigger=new RestTrigger();
    transient Config config=Config.getConfig();

    public UriForApis() {
        super();
    }

    public UriForApis(Config config) {
        this.config = config;
    }

    public HttpResponse<String> findById(int id)
    {
        HttpResponse<String> response=restTrigger.SendRequestGet(config.getPetBaseURL()+config.getPetBasePath()+"/"+id);
        return response;
    }

    public HttpResponse<String> findByStatus(String status)
    {
        HttpResponse<String> response=restTrigger.SendRequestGet(config.getPetBaseURL()+config.getPetBasePath()+"?status="+status);
        return response;
    }

    public HttpResponse<String> deleteById(int id)
    {
        HttpResponse<String> response=restTrigger.SendRequestDelete(config.getPetBaseURL()+"/"+id);
        return response;
    }
}
