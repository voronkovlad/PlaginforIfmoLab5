import com.intellij.openapi.ui.Messages;

public class Splitter {
    public static String[] split4096(String s){
        int num = s.length() / 4096;
        if (num <= 0) {
            return new String[]{s};
        }
        else{
            String[] ans = new String[num+1];
            for(int i = 0; i< num;++i){
                for(int j = 4095; j>=0;--j){
                    String chek = "" + s.charAt(j);
                    if(System.getProperty("line.separator").equals(chek)){
                        ans[i] = s.substring(0, j);
                        s.substring(j+1, s.length());
                        Messages.showMessageDialog(ans[i], "test", Messages.getInformationIcon());
                        break;
                    }
                }
            }
            return ans;
        }
    }
}
