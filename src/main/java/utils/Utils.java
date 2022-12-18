package utils;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.configs.ConfigHtml;
import utils.configs.SSLHelper;

import java.io.IOException;

import static javafx.css.StyleOrigin.USER_AGENT;

public class Utils {

    public static String removeComments(String s) {
        if (s == null) return "";
        if (s.length() == 0) return "";
        int start = s.indexOf("[");
        int end = s.indexOf("]");
        if (start == -1) return s.replace("\u2013", "-").replace("\u2014", "-");
        if (end + 1 >= s.length() - 1) return s.substring(0, start).replace("\u2013", "-").replace("\u2014", "-");
        return (s.substring(0, start) + removeComments(s.substring(end + 1))).replace("\u2013", "-").replace("\u2014", "-");
    }

    public static boolean isNumeric(String c){
        try {
            Integer.parseInt(c);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
