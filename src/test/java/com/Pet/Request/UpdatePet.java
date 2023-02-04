package com.Pet.Request;

import com.Common.Clients.RestTrigger;
import com.Pet.Category;
import org.json.JSONObject;

import java.util.ArrayList;
import kong.unirest.HttpResponse;

public class UpdatePet extends CreatePet
{


    public String requestBody(int id,String name,String status)
    {
        Category category=new Category(id,name);

        setId(id);
        setCategory(new Category(id,name));
        setName(name);
        setStatus(status);

        ArrayList<Category> tags=new ArrayList();
        tags.add(category);
        setTags(tags);

        ArrayList<String> url=new ArrayList();
        url.add(name);
        setPhotoUrls(url);
        return new JSONObject(this).toString();
    }

    public HttpResponse<String> sendRequest(int id,String name)
    {
        HttpResponse<String> response=restTrigger.SendRequestPUT(config.getPetBaseURL()+config.getPetBasePath(),requestBody(id,name));
        return response;
    }

    public HttpResponse<String> updateStatus(int id,String name,String status)
    {
        HttpResponse<String> response=restTrigger.SendRequestPUT(config.getPetBaseURL()+config.getPetBasePath(),requestBody(id,name,status));
        return response;
    }
}
