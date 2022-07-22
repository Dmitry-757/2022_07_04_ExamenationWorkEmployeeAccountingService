package org.dng.EmployeeAccountingService.Service;

import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.DBReferenceKeeper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class SaveReadDataBase {

    private static void saveDBReferenceKeeper() {
        DBReferenceKeeper dbReferenceKeeper = AppContext.getDbReferenceKeeper();
        dbReferenceKeeper.setJobDataBase(AppContext.getJobDataBase());
        dbReferenceKeeper.setDepartmentDataBase(AppContext.getDepartmentDataBase());
        dbReferenceKeeper.setEmployeeDataBase(AppContext.getEmployeeDataBase());

        try (FileOutputStream fos = new FileOutputStream(DBReferenceKeeper.fileNameDBReferenceKeeper);
             ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(dbReferenceKeeper);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
            e.printStackTrace();
        }
    }


    private static void readDBReferenceKeeper() {
        DBReferenceKeeper dataBase = null;
        if (!Files.exists(Path.of(DBReferenceKeeper.fileNameDBReferenceKeeper))){
            System.out.println("File with save was not found! ");
            return;
        }

        try(FileInputStream fis = new FileInputStream(DBReferenceKeeper.fileNameDBReferenceKeeper);
            ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            dataBase = (DBReferenceKeeper) ois.readObject();
            AppContext.setDepartmentDataBase(dataBase.getDepartmentDataBase());
            AppContext.setJobDataBase(dataBase.getJobDataBase());
            AppContext.setEmployeeDataBase(dataBase.getEmployeeDataBase());
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException "+e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException "+e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException "+e.getMessage());
            e.printStackTrace();
        }
    }

    public static void saveDB(){
        saveDBReferenceKeeper();
    }

    public static void readDB(){
        readDBReferenceKeeper();
    }
}
