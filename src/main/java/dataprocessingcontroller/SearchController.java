package dataprocessingcontroller;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class SearchController extends BaseController implements ISearchController {
    @Override
    public List<?> searchByKeyWord(String keyWord) {
        return null;
    }

    public int levenshteinDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] d = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            d[i][0] = i;
        }

        for (int j = 1; j <= n; j++) {
            d[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = 0;
                if (str1.charAt(i - 1) != str2.charAt(j - 1)) {
                    cost = 1;
                }
                d[i][j] = Math.min(
                        Math.min(d[i - 1][j] + 1,
                                d[i][j - 1] + 1),
                        d[i - 1][j - 1] + cost
                );
            }
        }
        return d[m][n];
    }

    public double getSimilarity(String str1, String str2) {
        int maxTotalChars = max(str1.length(), str2.length());
        return ((double) (maxTotalChars - levenshteinDistance(str1, str2))) / (maxTotalChars);
    }

    public double getSimilarityKeyWordInString(String keyWord, String str) {
        keyWord = Utils.removeSign4VietnameseString(Utils.removepunctuation(keyWord.trim()));
        str = Utils.removeSign4VietnameseString(Utils.removepunctuation(str.trim()));

        StringTokenizer stringTokenizerKeyWord = new StringTokenizer(keyWord, " ");
        StringTokenizer stringTokenizer = new StringTokenizer(str, " ");

        if (stringTokenizerKeyWord.countTokens() >= stringTokenizer.countTokens())
            return getSimilarity(keyWord, str);

        keyWord = keyWord.replaceAll(" ", "");
        int countTokensKeyWord = stringTokenizerKeyWord.countTokens();
        int countTokens = stringTokenizer.countTokens();
        List<String> list = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens()) {
            list.add(stringTokenizer.nextToken());
        }

        int k = 0;
        double maxTotalChars = 0.0;

        while (k <= countTokens - countTokensKeyWord) {
            String s = "";
            int p = k;
            while (p < k + countTokensKeyWord) {
                s += list.get(p);
                p++;
            }
            maxTotalChars = max(maxTotalChars, getSimilarity(keyWord, s));
            k++;
        }
        return maxTotalChars;
    }
}
