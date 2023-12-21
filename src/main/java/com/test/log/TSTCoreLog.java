package com.test.log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TSTCoreLog 
{

private static TSTCoreLog tstCoreLog = new TSTCoreLog();



public TSTCoreLog()
{

}

public static Logger LOG =   Logger.getLogger(TSTCoreLog.class.getName());
public static Logger LOG_D = Logger.getLogger(Log4jConstants.LOGGER_DEBUG);
public static Logger LOG_I = Logger.getLogger(Log4jConstants.LOGGER_INFO);
public static Logger LOG_W = Logger.getLogger(Log4jConstants.LOGGER_WARN);
public static Logger LOG_E = Logger.getLogger(Log4jConstants.LOGGER_ERROR);

public static void createOutputFolder(String logFolderLocation)
{
String outputsFolder= logFolderLocation + Log4jConstants.OUTPUT_FOLDER_NAME;
File outputFolder = new File(outputsFolder);
boolean isOutFolderExist = outputFolder.exists();
if (!isOutFolderExist)
{
	outputFolder.mkdir();
}

}

public void createLogFolder(String logFolderLocation)
{

String logsFolder = logFolderLocation + Log4jConstants.LOGS_FOLDER_NAME;





File logFolder = new File(logsFolder);





boolean isLogFolderExist = logFolder.exists();



if (!isLogFolderExist)
{
logFolder.mkdir();
}



Properties props = new Properties();
try 
{
InputStream configStream = TSTCoreLog.class.getResourceAsStream(Log4jConstants.LOG4J_PROPERTIES_FILE);

props.load(configStream);

configStream.close();

}
catch (IOException e) 
{
System.out.println("Error: Cannot laod log4j configuration file ");
}
props.setProperty(Log4jConstants.PROPERTY_EXECUTION, logsFolder + Log4jConstants.LOG_FILE_EXECUTION);
props.setProperty(Log4jConstants.PROPERTY_DEBUG, logsFolder + Log4jConstants.LOG_FILE_DEBUG);
props.setProperty(Log4jConstants.PROPERTY_INFO, logsFolder + Log4jConstants.LOG_FILE_INFO);
props.setProperty(Log4jConstants.PROPERTY_WARN, logsFolder + Log4jConstants.LOG_FILE_WARN);
props.setProperty(Log4jConstants.PROPERTY_ERROR, logsFolder + Log4jConstants.LOG_FILE_ERROR);
PropertyConfigurator.configure(props);

try 
{

String statusFileName = logsFolder + TSTCoreUtilityConstants.DOUBLE_SLASH+ Log4jConstants.LOG_FILE_STATUS;

File statusFile = new File(statusFileName);

boolean isStatusFileExist = statusFile.exists();

if (!isStatusFileExist)
{
statusFile.createNewFile();
}

String messageFileName = logsFolder + TSTCoreUtilityConstants.DOUBLE_SLASH+ Log4jConstants.LOG_FILE_MESSAGE;
File messageFile = new File(messageFileName);
boolean isMessageFileExist = messageFile.exists();
if (!isMessageFileExist)
{
messageFile.createNewFile();
}

System.setProperty(TSTCoreUtilityConstants.KEY_NAME_STATUS, statusFileName);

System.setProperty(TSTCoreUtilityConstants.KEY_NAME_MESSAGE, messageFileName);

}
catch (Exception e)
{
e.printStackTrace();
		
}

}


public void writeStatus(String status)
{

String statusFileName = System.getProperty(TSTCoreUtilityConstants.KEY_NAME_STATUS);

System.out.println("The Status File Name =========>"+statusFileName);

try 
{
Files.write(Paths.get(statusFileName), status.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
} 
catch (IOException e)
{
e.printStackTrace();
}

}


public void writeMessage(String message)
{

String messageFileName = System.getProperty(TSTCoreUtilityConstants.KEY_NAME_MESSAGE);

try
{
Files.write(Paths.get(messageFileName), message.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
} 
catch (IOException e)
{
e.printStackTrace();
}

}

public static TSTCoreLog getInstance()
{
return tstCoreLog;
}

}
