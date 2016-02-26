/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upgradescript;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author acalbaza
 */
public class UpgradeScript {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String dir_path = "D:\\ladwp\\ladwp-17.06.2015\\src\\sql\\Revisions\\build228";
        File folder = new File(dir_path);
        File[] listOfFiles = folder.listFiles();

  
        ArrayList<File> coreScripts = new ArrayList();
        ArrayList<File> ladwpScripts =  new ArrayList();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                // System.out.println("File " + listOfFiles[i].getName());
                if (listOfFiles[i].getName().contains("core")){
                    coreScripts.add(listOfFiles[i]);
                }
                if (listOfFiles[i].getName().contains("ladwp")){
                    ladwpScripts.add(listOfFiles[i]);
                }
                //System.out.println("@" + listOfFiles[i].getAbsolutePath() + ";");
            } else if (listOfFiles[i].isDirectory()) {
                // System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
        

        coreScripts.sort(new AlphanumComparator());
        
        
        for (int i = 0; i < coreScripts.size(); i++) {
            File f = (File)coreScripts.get(i);
            System.out.println("@" + f.getAbsolutePath()    + ";");

        }
        
        
        ladwpScripts.sort(new AlphanumComparator());
        
        
        for (int i = 0; i < ladwpScripts.size(); i++) {
            File f = (File)ladwpScripts.get(i);
            System.out.println("@" + f.getAbsolutePath()    + ";");

        }
        
        

    }
    
    
    
    

}
