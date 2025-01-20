package com.sample.ui;


import com.sample.utils.ReadJSON;
import com.sample.utils.SystemProperties;
import org.json.JSONObject;

public class WebDriverSteps extends WebDriverSession{
    public static final int FIVE_SECOND_MILLISECOND = 5000;
    private String url;

    public static void closeTheBrowser() {
        WebDriverSession.getWebDriverSession().quit();
        map.clear();
    }

    public String getApplicationURL(String appName) {
        JSONObject jsonFile = new JSONObject(ReadJSON.parse("Environments.json"));
        JSONObject env = jsonFile.getJSONObject(SystemProperties.EXECUTION_ENVIRONMENT);
        return ReadJSON.getString(env, appName);
    }

    public void navigateToApplication(String appName) {
        String url = getApplicationURL(appName);
        setUrl(url);
//        WebDriverSession.getWebDriverSession().Navigate().get(this.url);
        WebDriverSession.getWebDriverSession().navigate().to(this.url);
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
