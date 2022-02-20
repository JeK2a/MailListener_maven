package service;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

// Получение настроек из XML файла
public class SettingsMail {

    private String user;
    private String password;
    private String host;
    private String port;
    private String schema;
    private String usessl;
    private String useunicode;
    private String characterencoding;

    private String table_users;
    private String table_emails;

    private String  mail_debug;
    private boolean session_debug;

    private boolean wait_folder;
    private boolean wait_user;

    public SettingsMail() {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc = null;

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File("config_my.xml");
            doc = builder.parse(file);
        } catch (SAXException | ParserConfigurationException | IOException ex) {
            ex.printStackTrace();
        }

        assert doc != null;
        Element root = doc.getDocumentElement();
        NodeList children = root.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {

            Node child = children.item(i);

            if (child instanceof Element) {
                Element childElement = (Element) child;
                Text textNode = (Text) childElement.getFirstChild();
                String text = textNode.getData().trim();

                switch (childElement.getTagName()) {
                    case "user"              : user              = text; break;
                    case "password"          : password          = text; break;
                    case "host"              : host              = text; break;
                    case "port"              : port              = text; break;
                    case "schema"            : schema            = text; break;
                    case "usessl"            : usessl            = text; break;
                    case "useunicode"        : useunicode        = text; break;
                    case "characterencoding" : characterencoding = text; break;
                    case "table_users"       : table_users       = text; break;
                    case "table_emails"      : table_emails      = text; break;
                    case "mail_debug"        : mail_debug        = text; break;
                    case "session_debug"     : session_debug     = Boolean.parseBoolean(text); break;
                    case "wait_folder"       : wait_folder       = Boolean.parseBoolean(text); break;
                    case "wait_user"         : wait_user         = Boolean.parseBoolean(text); break;
                }
            }
        }
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getSchema() {
        return schema;
    }

    public String getUsessl() {
        return usessl;
    }

    public String getUseunicode() {
        return useunicode;
    }

    public String getCharacterencoding() {
        return characterencoding;
    }

    public String getMail_debug() {
        return mail_debug;
    }

    public boolean getSession_debug() {
        return session_debug;
    }

    public String getTable_users() {
        return table_users;
    }

    public boolean getWaitFolder() {
        return wait_folder;
    }

    public boolean getWaitUser() {
        return wait_user;
    }

    public String getTable_emails() {
        return table_emails;
    }
}
