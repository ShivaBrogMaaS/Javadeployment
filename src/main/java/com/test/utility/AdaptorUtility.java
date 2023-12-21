package com.test.utility;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;
import com.test.log.TSTCoreLog;
import com.test.log.TSTCoreUtility;



public class AdaptorUtility 
{

public static ConfigurationSettings getProperties(String adaptorExecutionPath) throws JSONException, IOException 
{
Map<String, String> configProperties = new HashMap<String, String>();

String configurationFilePath = adaptorExecutionPath + "\\input\\body.xml";

String inputAsXml = FileUtils.readFileToString(new File(configurationFilePath));

JSONObject xmlJSONObj = XML.toJSONObject(inputAsXml);

JSONArray reports = new JSONArray("[" + xmlJSONObj + "]");

JSONObject root = reports.getJSONObject(0);

JSONObject input = root.getJSONObject("input");

String scriptAction = input.getString("scriptaction");

configProperties.put("scriptAction", scriptAction);

JSONObject wsps = input.getJSONObject("wsps");

JSONObject wsp = wsps.getJSONObject("wsp");

String serverIp = wsp.getString("workloadip");

configProperties.put("serverIp", serverIp);

JSONObject firewall = wsp.getJSONObject("firewall");

if (firewall.get("rule") instanceof JSONArray)
{

JSONArray rule = (JSONArray) firewall.get("rule");

JSONObject value = (JSONObject) rule.get(0);

configProperties.put("port", value.get("port").toString());
}
else 
{

JSONObject rule = firewall.getJSONObject("rule");

configProperties.put("port", rule.get("port").toString());
    
}
JSONObject properties = wsp.getJSONObject("properties");

if (properties.get("property") instanceof JSONArray)
{
    
JSONArray property = (JSONArray) properties.get("property");
//for (Object object : property) {

for (int i = 0; i < property.length(); i++)
{

JSONObject objects = property.getJSONObject(i);

//JSONObject objects = (JSONObject) object;

if (!objects.isNull("content")) 
{
    
Object valueObject = objects.get("content");

if (valueObject instanceof String)
{
configProperties.put(objects.getString("key"), objects.getString("content"));
}
if (valueObject instanceof Integer)
{
configProperties.put(objects.getString("key"), String.valueOf(objects.getInt("content")));
}
if (valueObject instanceof Boolean)
{
configProperties.put(objects.getString("key"),String.valueOf(objects.getBoolean("content")));
}
continue;
}
configProperties.put(objects.getString("key"), "");
}

}
else
{
JSONObject property = properties.getJSONObject("property");

if (property.toString().contains("content"))
{
configProperties.put(property.getString("key"), property.getString("content"));
}
    
}

return new ConfigurationSettings(configProperties, adaptorExecutionPath);
}

public static void writeOutput(String outputContent, String outputFilePath) 
{
try
{
File xmlReportFile = new File(outputFilePath + "\\output\\output.xml");

xmlReportFile.createNewFile();

String xmlPrettyFormat = TSTCoreUtility.getInstance().xmlPrettyFormat("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><Output>" + outputContent + "</Output>");

Files.write(Paths.get(xmlReportFile.getPath(), new String[0]), xmlPrettyFormat.getBytes(), new OpenOption[]{StandardOpenOption.TRUNCATE_EXISTING});

} 
catch (Exception e)
{
TSTCoreLog.LOG.error(AdaptorUtility.class.getName() + " - " + e.getMessage());
TSTCoreLog.LOG_E.error(AdaptorUtility.class.getName() + " - " + e.getMessage());
e.printStackTrace();
}
}

public static String xmlPrettyFormat(String xml)
{
try 
{
InputSource src = new InputSource(new StringReader(xml));
Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();
Boolean keepDeclaration = Boolean.valueOf(xml.startsWith("<?xml"));
DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
LSSerializer writer = impl.createLSSerializer();
writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);
writer.getDomConfig().setParameter("xml-declaration", keepDeclaration);
return writer.writeToString(document);
} 
catch (Exception e) 
{
TSTCoreLog.LOG.error(AdaptorUtility.class.getName() + " - " + e.getMessage());
TSTCoreLog.LOG_E.error(AdaptorUtility.class.getName() + " - " + e.getMessage());
throw new RuntimeException(e);
}
}


}
