package com.Common.Clients;

import kong.unirest.*;
import org.apache.maven.surefire.shared.lang3.time.StopWatch;


public class RestTrigger
{
    public StopWatch stopwatch=new StopWatch();
    public RequestBodyEntity requestWithBody;

    public  RestTrigger()
    {
        Unirest.shutDown();
        Unirest.config().connectTimeout(1200000);
    }

    public HttpResponse<String> SendRequestPost(String url, String request)
    {
        HttpResponse<String> response = null;
        try
        {
            stopwatch.reset();
            stopwatch.start();
            response = Unirest.post(url)
                .header("Content-Type", "application/json")
                .body(request)
                .asString();
        }
        catch (UnirestException e)
        {
            e.printStackTrace();
        }
        finally
        {
            stopwatch.stop();
        }
        setStopwatch(stopwatch);
        return response;
    }

    public HttpResponse<String> SendRequestPUT(String url, String request)
    {
        HttpResponse<String> response = null;
        try
        {
            stopwatch.reset();
            stopwatch.start();
            response = Unirest.put(url)
                    .header("Content-Type", "application/json")
                    .body(request)
                    .asString();
        }
        catch (UnirestException e)
        {
            e.printStackTrace();
        }
        finally
        {
            stopwatch.stop();
        }
        setStopwatch(stopwatch);
        return response;
    }

    public HttpResponse<String> SendRequestGet(String url) {
        HttpResponse<String> response = null;
        try
        {
            stopwatch.reset();
            stopwatch.start();
            response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .asString();
        }
        catch (UnirestException e)
        {
            e.printStackTrace();
        }
        finally
        {
            stopwatch.stop();
        }
        setStopwatch(stopwatch);
        return response;
    }

    public  HttpResponse<String> SendRequestDelete(String url)
    {
        HttpResponse<String> response =null;
        try
        {
            stopwatch.reset();
            stopwatch.start();
            response = Unirest.delete(url)
                    .header("Content-Type", "application/json")
                    .asString();
        }
        catch (UnirestException e)
        {
            e.printStackTrace();
        } finally
        {
            stopwatch.stop();
        }
        setStopwatch(stopwatch);
        return response;
    }

    public StopWatch getStopwatch() {
        return stopwatch;
    }

    public void setStopwatch(StopWatch stopwatch) {
        this.stopwatch = stopwatch;
    }


}
