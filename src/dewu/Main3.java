package dewu;

import java.util.*;
public class Main3 {
    public static void main(String[] args) {

    }
}

class Module {
    private int numModules;
    private List<Integer>[] dependencies;

    public Module(int numModules) {
        this.numModules = numModules;
        dependencies = new ArrayList[numModules + 1];
        for (int i = 1; i <= numModules; i++) {
            dependencies[i] = new ArrayList<>();
        }
    }



    /**
     * 添加模块
     * @param module    模块编号
     * @param dependsOn 依赖的模块编号
     */
    public void add(int module, int dependsOn) {
        dependencies[module].add(dependsOn);
    }


}
