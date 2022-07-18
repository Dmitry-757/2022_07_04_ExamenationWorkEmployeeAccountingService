package org.dng.EmployeeAccountingService.Service;

import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.repository.DepartmentDataBase;
import org.dng.EmployeeAccountingService.repository.EmployeeDataBase;
import org.dng.EmployeeAccountingService.repository.JobDataBase;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class SaveDataBase {
    private static void saveDBDepartment() {
        DepartmentDataBase dataBase = AppContext.getDepartmentDataBase();
        try (FileOutputStream fos = new FileOutputStream(AppContext.fileNameDBDepartment);
             ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(dataBase);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void saveDBJob() {
        JobDataBase dataBase = AppContext.getJobDataBase();
        try (FileOutputStream fos = new FileOutputStream(AppContext.fileNameDBJob);
             ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(dataBase);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void saveDBEmployee() {
        EmployeeDataBase dataBase = AppContext.getEmployeeDataBase();
        try (FileOutputStream fos = new FileOutputStream(AppContext.fileNameDBEmployee);
             ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(dataBase);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void readDBDepartment() {
        DepartmentDataBase dataBase = null;
        if (!Files.exists(Path.of(AppContext.fileNameDBDepartment))){
            System.out.println("File with save was not found! Create new pet.");
        }

        try(FileInputStream fis = new FileInputStream(AppContext.fileNameDBDepartment);
            ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            dataBase = (DepartmentDataBase) ois.readObject();
            AppContext.setDepartmentDataBase(dataBase);
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

    private static void readDBJob() {
        JobDataBase dataBase = null;
        if (!Files.exists(Path.of(AppContext.fileNameDBJob))){
            System.out.println("File with save was not found! Create new pet.");
        }

        try(FileInputStream fis = new FileInputStream(AppContext.fileNameDBJob);
            ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            dataBase = (JobDataBase) ois.readObject();
            AppContext.setJobDataBase(dataBase);
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


    private static void readDBEmployee() {
        EmployeeDataBase dataBase = null;
        if (!Files.exists(Path.of(AppContext.fileNameDBEmployee))){
            System.out.println("File with save was not found! Create new pet.");
        }

        try(FileInputStream fis = new FileInputStream(AppContext.fileNameDBEmployee);
            ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            dataBase = (EmployeeDataBase) ois.readObject();
            AppContext.setEmployeeDataBase(dataBase);
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
        saveDBDepartment();
        saveDBJob();
        saveDBEmployee();
    }

    public static void readDB(){
        readDBJob();
        readDBDepartment();
        readDBEmployee();
    }
}
