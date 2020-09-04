package casia.isiteam.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * ClassName: DataReadUtil
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/7/10
 * Email: zhiyou_wang@foxmail.com
 */
public class DataReadUtil {

    public static Map<String, Double[]> loadLexicon(){
        Map<String, Double[]> maps = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines( Paths.get("dict/emotion.d"));
            lines.forEach(s->{
                String[] loadLexiconInfo = s.split("\t");
                Double[] sets = new Double[loadLexiconInfo.length-1];
                for(int i=1;i<loadLexiconInfo.length;i++){
                    sets[i-1]=Double.parseDouble(loadLexiconInfo[i]);
                }
                if(maps.containsKey(loadLexiconInfo[0])){
                    double count_ne = sets[1]+sets[2]+sets[4]+sets[1]+sets[5]+sets[7];
                    Double[] count_ne_old =  maps.get(loadLexiconInfo[0]);
                    if( count_ne>(count_ne_old[1]+count_ne_old[2]+count_ne_old[4]+count_ne_old[1]+count_ne_old[5]+count_ne_old[7]) ){
                        maps.put( loadLexiconInfo[0],sets);
                    }
                }else {
                    maps.put(loadLexiconInfo[0],sets);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maps;
    }

    public static List<String> readUserBlog(String path){
        try {
            return Files.readAllLines( Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
