package com.Common.Base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Config{
    private Map<String, String> pet;

    public static Config config;

    public Map<String, String> getPet() {
        return pet;
    }

    public void setPet(Map<String, String> pet) {
        this.pet = pet;
    }

    public static Config getConfig() {
        return config;
    }

    public static void setConfig(Config config) {
        Config.config = config;
    }

    public String getPetBaseURL() { return pet.get("BaseUrl"); }
    public String getPetBasePath() { return pet.get("BasePath"); }
    public String getPetFindByStatusPath() { return pet.get("FindByStatus"); }
    public String getPetUploadImagePath() { return pet.get("UploadImage"); }
    public String getValidationMessagePositive() { return pet.get("ValidationMessagePositive"); }
    public String getValidationMessageNegative() { return pet.get("ValidationMessageNegative"); }
    public String getResponseCodePositive() { return pet.get("ResponseCodePositive"); }
    public String getResponseCodeNegative() { return pet.get("ResponseCodeNegative"); }

    public Config()
    {

    }


    public Config config(String env)
    {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Config config = null;
        try
        {
            config=mapper.readValue(new File(System.getProperty("user.dir")+"/Config-"+env+".yaml"),Config.class);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        config.setConfig(config);
        return  config;

    }



}
