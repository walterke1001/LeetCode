import java.util.ArrayList;

public class LC_71 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/../"));
    }

    public static String simplifyPath(String path) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        String[] split = path.split("/");
        for (String str : split) {
            if (str.isEmpty()) continue;
            if (str.equals(".")) continue;
            if (str.equals("..") && !list.isEmpty()) {
                list.remove(list.size() - 1);
            } else {
                if (!"..".equals(str))
                    list.add(str);
            }
        }
        if(list.isEmpty()) res.append("/");
        list.forEach(each -> {
            each = "/" + each;
            res.append(each);
        });
        return res.toString();
    }
}
