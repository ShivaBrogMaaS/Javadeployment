package com.test.utility;

import java.util.Map;

public class ConfigurationSettings 
{
private Map<String, String> configProperties;

private String adaptorExecutionPath;

public ConfigurationSettings(Map<String, String> configProperties, String adaptorExecutionPath)
{
super();
this.configProperties = configProperties;
this.adaptorExecutionPath = adaptorExecutionPath;
}

public ConfigurationSettings() 
{
throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}


public Map<String, String> getConfigProperties()
{
return configProperties;
}


public void setConfigProperties(Map<String, String> configProperties)
{
this.configProperties = configProperties;
}


public String getAdaptorExecutionPath()
{
return adaptorExecutionPath;
}


public void setAdaptorExecutionPath(String adaptorExecutionPath)
{
this.adaptorExecutionPath = adaptorExecutionPath;
}


@Override
public String toString() 
{
return "ConfigurationSettings [configProperties=" + configProperties + ", adaptorExecutionPath="+ adaptorExecutionPath + "]";
}

public String getConfigProperties(String appIDUrl) 
{
throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

}
