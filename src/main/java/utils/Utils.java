package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Utils {

    private static String[] VietnameseSigns =
            {
                    "aAeEoOuUiIdDyY",
                    "áàạảãâấầậẩẫăắằặẳẵ",
                    "ÁÀẠẢÃÂẤẦẬẨẪĂẮẰẶẲẴ",
                    "éèẹẻẽêếềệểễ",
                    "ÉÈẸẺẼÊẾỀỆỂỄ",
                    "óòọỏõôốồộổỗơớờợởỡ",
                    "ÓÒỌỎÕÔỐỒỘỔỖƠỚỜỢỞỠ",
                    "úùụủũưứừựửữ",
                    "ÚÙỤỦŨƯỨỪỰỬỮ",
                    "íìịỉĩ",
                    "ÍÌỊỈĨ",
                    "đ",
                    "Đ",
                    "ýỳỵỷỹ",
                    "ÝỲỴỶỸ"
            };

    public static String removeComments(String s) {
        if (s == null) return "";
        if (s.length() == 0) return "";
        int start = s.indexOf("[");
        int end = s.indexOf("]");
        if (start == -1) return s.replace("\u2013", "-").replace("\u2014", "-");
        if (end + 1 >= s.length() - 1) return s.substring(0, start).replace("\u2013", "-").replace("\u2014", "-");
        return (s.substring(0, start) + removeComments(s.substring(end + 1))).replace("\u2013", "-").replace("\u2014", "-");
    }

    public static boolean isNumeric(String c) {
        try {
            Integer.parseInt(c);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String removeSign4VietnameseString(String str) {
        for (int i = 1; i < VietnameseSigns.length; i++) {
            for (int j = 0; j < VietnameseSigns[i].length(); j++)
                str = str.replace(VietnameseSigns[i].charAt(j), VietnameseSigns[0].charAt(i - 1));
        }
        return str;
    }

    public static String removepunctuation(String str) {
        return str.replaceAll("\\p{Punct}", "");
    }

    public static List<String> getSentenceHasInfo(StringTokenizer stringTokenizer, String info) {
        List<String> infos = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            String str = stringTokenizer.nextToken();
            if (str.contains(info)) {
                infos.add(str);
            }
        }
        return infos;
    }

    public static boolean checkStringContainString(String str, String strSearch){
        if (Utils.removeSign4VietnameseString(str).toLowerCase().contains(Utils.removeSign4VietnameseString(strSearch).toLowerCase())) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            List<String> infos = Utils.getSentenceHasInfo(stringTokenizer, strSearch);
            if (infos.size() != 0) {
                System.out.print(strSearch + " - ");
                int p = 0;
                while (p < infos.size()) {
                    if (infos.get(p) != null && !infos.get(p).equals(""))
                        System.out.print(infos.get(p) + "  ");
                    p++;
                }
            }
            System.out.println();
            return true;
        }
        return false;
    }
}
