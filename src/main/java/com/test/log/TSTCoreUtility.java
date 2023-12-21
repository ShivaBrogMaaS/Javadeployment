package com.test.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

public class TSTCoreUtility 
{
private static TSTCoreUtility tstCoreUtility = new TSTCoreUtility();

public TSTCoreUtility()
{

}

public void copyFileUsingStream(File source, File dest)
{

InputStream is = null;
OutputStream os = null;
try 
{
is = new FileInputStream(source);
os = new FileOutputStream(dest);
byte[] buffer = new byte[1024];
int length;
while ((length = is.read(buffer)) > 0)
{
os.write(buffer, 0, length);
}
} 
catch (IOException e)
{
e.printStackTrace();     
} 
finally
{
try 
{
    is.close();
} 
catch (IOException e)
{
    e.printStackTrace();
}
try 
{
    os.close();
} 
catch (IOException e)
{
    e.printStackTrace();
}
}
}

public String xmlPrettyFormat(String xml)
{

try
{
final InputSource src = new InputSource(new StringReader(xml));
final Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();
final Boolean keepDeclaration = Boolean.valueOf(xml.startsWith("<?xml"));
final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
final LSSerializer writer = impl.createLSSerializer();
// Set this to true if the output needs to be beautified.
writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);

// Set this to true if the declaration is needed to be outputted.
writer.getDomConfig().setParameter("xml-declaration", keepDeclaration);

return writer.writeToString(document);
}
catch (Exception e)
{
TSTCoreLog.LOG.error(TSTCoreUtility.class.getName() + " - " + e.getMessage());
TSTCoreLog.LOG_E.error(TSTCoreUtility.class.getName() + " - " + e.getMessage());
throw new RuntimeException(e);
}

}

public boolean isFileExists(String filePathName)
{
boolean checkStatus = true;
File file = new File(filePathName);
if (!file.exists()) 
{
    checkStatus = false;
}
return checkStatus;
}

public void moveFile(String filePath, String sourceFileName)
{
try
{
File sourceFile = new File(filePath + sourceFileName);

TSTCoreLog.LOG.info("Moving log file " + sourceFile.getAbsolutePath());

if (sourceFile.exists())
{

if (sourceFile.renameTo(new File(filePath + "\\logs\\" + sourceFile.getName()))) 
{
    TSTCoreLog.LOG.info(sourceFile.getAbsolutePath() + " file is moved successful!");
TSTCoreLog.LOG_I.info(sourceFile.getAbsolutePath() + " file is moved successful!");
} 

else 
{
    TSTCoreLog.LOG.warn(sourceFile.getAbsolutePath() + " file is failed to move!");
TSTCoreLog.LOG_W.warn(sourceFile.getAbsolutePath() + " file is failed to move!");
}
            }
        } catch (Exception e) {
            TSTCoreLog.LOG.error(TSTCoreUtility.class.getName() + " - " + e.getMessage());
TSTCoreLog.LOG_E.error(TSTCoreUtility.class.getName() + " - " + e.getMessage());
            e.printStackTrace();
        }
    }

public void deleteFile(String filePath)
 {
try 
{

File sourceFile = new File(filePath);

TSTCoreLog.LOG.info("Delete file " + sourceFile.getAbsolutePath());

if (sourceFile.exists()) {

    if (sourceFile.delete()) {	
        TSTCoreLog.LOG.info(sourceFile.getAbsolutePath() + " file is deleted successful!");
TSTCoreLog.LOG_I.info(sourceFile.getAbsolutePath() + " file is deleted successful!");
} else {
    TSTCoreLog.LOG.warn(sourceFile.getAbsolutePath() + " file is failed to delete!");
TSTCoreLog.LOG_W.warn(sourceFile.getAbsolutePath() + " file is failed to delete!");
        }
    }
} catch (Exception e) {
    TSTCoreLog.LOG.error(TSTCoreUtility.class.getName() + " - " + e.getMessage());
TSTCoreLog.LOG_E.error(TSTCoreUtility.class.getName() + " - " + e.getMessage());
        e.printStackTrace();
    }
}

public void zipFolder(String folderToZip, String zipName) 
{

    final Path sourceFolderPath = Paths.get(folderToZip);
    Path zipPath = Paths.get(zipName);

    try {
        final ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath.toFile()));
        Files.walkFileTree(sourceFolderPath, new SimpleFileVisitor<Path>() {
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                try {
                    zos.putNextEntry(new ZipEntry(sourceFolderPath.relativize(file).toString()));
                    Files.copy(file, zos);
                    zos.closeEntry();
                } catch (IOException e) {
                    TSTCoreLog.LOG.error(TSTCoreUtility.class.getName() + " - " + e.getMessage());
TSTCoreLog.LOG_E.error(TSTCoreUtility.class.getName() + " - " + e.getMessage());
                e.printStackTrace();
            }

            return FileVisitResult.CONTINUE;
        }
    });
    zos.close();
} catch (Exception e) {
    TSTCoreLog.LOG.error(TSTCoreUtility.class.getName() + " - " + e.getMessage());
TSTCoreLog.LOG_E.error(TSTCoreUtility.class.getName() + " - " + e.getMessage());
        e.printStackTrace();
    }

}

public static TSTCoreUtility getInstance() 
{
    return tstCoreUtility;
}

public String askPassword(String userName) 
{

        String password = "";
System.out.println("Please Enter a Password for " + userName);
@SuppressWarnings("resource")
Scanner sc = new Scanner(System.in);
password = sc.nextLine();
if (!password.isEmpty()) {

} else {
    System.out.println("You donot not provided a password . So we cannot procced further");
        }
        return password;
    }

}
