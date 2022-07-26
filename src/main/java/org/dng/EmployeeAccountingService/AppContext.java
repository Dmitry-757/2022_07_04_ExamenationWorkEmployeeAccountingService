package org.dng.EmployeeAccountingService;

import org.dng.EmployeeAccountingService.Service.DepartmentService;
import org.dng.EmployeeAccountingService.Service.EmployeeService;
import org.dng.EmployeeAccountingService.Service.JobService;
import org.dng.EmployeeAccountingService.repository.DepartmentDataBase;
import org.dng.EmployeeAccountingService.repository.EmployeeDataBase;
import org.dng.EmployeeAccountingService.repository.JobDataBase;

import java.io.IOException;
import java.util.Date;
//import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.*;

public class AppContext {
    //** lets make new empty DB for first-time filling ***
    private static DepartmentDataBase departmentDataBase = new DepartmentDataBase();
    private static JobDataBase jobDataBase = new JobDataBase();
    private static EmployeeDataBase employeeDataBase = new EmployeeDataBase();
//    private static AtomicReference<DepartmentDataBase> departmentDataBase = new AtomicReference<>(new DepartmentDataBase());
//    private static AtomicReference<JobDataBase> jobDataBase = new AtomicReference<>(new JobDataBase());
//    private static AtomicReference<EmployeeDataBase> employeeDataBase = new AtomicReference<>(new EmployeeDataBase());


    private static final DepartmentService departmentService = new DepartmentService();
    private static final JobService jobService = new JobService();
    private static final EmployeeService employeeService = new EmployeeService();

    private static final DBReferenceKeeper dbReferenceKeeper = new DBReferenceKeeper();//for serializing

    //** for logging ***
    //lets make anonymous class ;)
    private static final Formatter myFormatter = new Formatter() {
        @Override
        public String format(LogRecord record) {
//            return "Thread id="+record.getLongThreadID()+"::"+record.getSourceClassName()+"::"
//                    +record.getSourceMethodName()+"::"+"\n"
//                    +"    "+new Date(record.getMillis())+"::"
//                    +record.getMessage()+"\n";
//            return record.getSourceClassName()+"::"
//                    +record.getSourceMethodName()+"::"+"\n"
//                    +"    "+new Date(record.getMillis())+"::"
//                    +record.getMessage()+"\n";
            return "\n"+record.getLevel()+"\n"
                    +new Date(record.getMillis())+"\n"
                    +record.getSourceClassName()+"::"+record.getSourceMethodName()+"\n"
                    +record.getMessage()+"\n";
        }
    };

    private static final Logger logger = getLogger();

    //references to db
    public static DBReferenceKeeper getDbReferenceKeeper() {
        return dbReferenceKeeper;
    }

    public static DepartmentDataBase getDepartmentDataBase() {
        return departmentDataBase;
    }

    public static JobDataBase getJobDataBase() {
        return jobDataBase;
    }

    public static EmployeeDataBase getEmployeeDataBase() {
        return employeeDataBase;
    }


    //Services
    public static DepartmentService getDepartmentService() {
        return departmentService;
    }

    public static JobService getJobService() {
        return jobService;
    }

    public static EmployeeService getEmployeeService() {
        return employeeService;
    }


    //**for serialize/deserialize ***
    public static void setDepartmentDataBase(DepartmentDataBase departmentDataBase) {
        AppContext.departmentDataBase = departmentDataBase;
    }
    public static void setJobDataBase(JobDataBase jobDataBase) {
        AppContext.jobDataBase = jobDataBase;
    }
    public static void setEmployeeDataBase(EmployeeDataBase employeeDataBase) {
        AppContext.employeeDataBase = employeeDataBase;
    }

    //**for logging ***
//    private static Logger getLogger(String className) {
    private static Logger getLogger() {
        Handler fileHandler = null;
        try {
            fileHandler = new FileHandler("d:\\myLog.log");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        assert fileHandler != null;
        fileHandler.setFormatter(myFormatter);
//        Logger logger = Logger.getLogger(className);
        Logger logger = Logger.getLogger("");
        //logger.setUseParentHandlers(false);
        logger.addHandler(fileHandler);
        return logger;
    }

    public static Logger getMyLogger(String className){
        return logger;
    }
}
