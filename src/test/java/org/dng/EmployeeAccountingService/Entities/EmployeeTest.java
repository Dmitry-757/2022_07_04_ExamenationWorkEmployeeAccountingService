package org.dng.EmployeeAccountingService.Entities;


import org.dng.EmployeeAccountingService.AppContext;
import org.junit.jupiter.api.*;


import java.time.LocalDate;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EmployeeTest {
    public Job job;
    public Department department;
    public Employee empl;

    //@BeforeEach
    @BeforeAll
    void makeEmployee() {
        try {
            job = new Job("manager");
            department = new Department("Sale department");
            empl = new Employee("Pupkin Ivan Ivanovich",
                    12345678,
                    LocalDate.of(1970, 6, 1),
                    Gender.MALE,
                    "912-1234567",
                    job, department,
                    LocalDate.of(2022, 7, 8),
                    null,
                    50000, "abc@gmail.com","password=qwerty");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

//    @Disabled
//    @Test
//    void addDuplicatedEmployeeToDB() {
//        final Employee empl2 = empl;
//        EmployeeDataBase.getEmployeeHashMap().entrySet().forEach(s -> System.out.println(s.getKey() +" => "+ s.getValue()));
//        Assertions.assertThrows(AddDuplicatedObjException.class, ()-> EmployeeDataBase.add(empl2),"Exception must be thrown!");
//    }

    @Test
    void createEmployeeTest(){
        Assertions.assertSame(empl.getName(),"Pupkin Ivan Ivanovich");
        Assertions.assertEquals(empl.getInn(),12345678);
        Assertions.assertEquals(empl.getBirthDate(), LocalDate.of(1970, 6, 1));
        Assertions.assertSame(empl.getGender(), Gender.MALE);
        Assertions.assertSame(empl.getJob(), job);
        Assertions.assertSame(empl.getDepartment(), department);
        Assertions.assertEquals(empl.getRecruitDate(), LocalDate.of(2022, 7, 8));
        Assertions.assertSame(empl.getDismissDate(), null);
        Assertions.assertEquals(50000, empl.getSalary());
    }

    @Test
    void duplicateEmployeeTest(){
        Assertions.assertThrows(AddDuplicatedObjException.class,
                ()-> new Employee("Pupkin Ivan Ivanovich",
                        12345678,
                        LocalDate.of(1970, 6, 1),
                        Gender.MALE,
                        "912-1234567",
                        job, department,
                        LocalDate.of(2022, 7, 8),
                        null,
                        50000, "abc@gmail.com","password=qwerty")
                );
    }


    @Test
    void putToDateBaseAndFindEmployeeTest(){
        Assertions.assertSame(AppContext.getEmployeeService().getByName("Pupkin Ivan Ivanovich"), empl);
    }

    @Test
    void changeEmployeeTest(){
        //lets change name and gender of employee ;))
        Employee emplChng = null;
        try {
            emplChng = new Employee("Saler Ivan Petrovich",
                    11111111,
                    LocalDate.of(1970, 6, 1),
                    Gender.MALE,
                    "912-1234567",
                    job, department,
                    LocalDate.of(2022, 7, 8),
                    null,
                    50000, "abc@gmail.com","password=qwerty");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        AppContext.getEmployeeService().change(emplChng, "Ivanov Ivan Michailovich",
                11111111,
                LocalDate.of(1970, 6, 1),
                Gender.FEMALE,
                "912-1234567",
                job, department,
                LocalDate.of(2022, 7, 8),
                null,
                50000, "abc@gmail.com", "password=qwerty" );

        Employee empl2 = AppContext.getEmployeeService().getByName("Ivanov Ivan Michailovich");

        Assertions.assertSame(empl2.getName(),"Ivanov Ivan Michailovich");
        Assertions.assertEquals(empl2.getInn(),11111111);
        Assertions.assertEquals(empl2.getBirthDate(), LocalDate.of(1970, 6, 1));
        Assertions.assertSame(empl2.getGender(), Gender.FEMALE);
        Assertions.assertSame(empl2.getJob(), job);
        Assertions.assertSame(empl2.getDepartment(), department);
        Assertions.assertEquals(empl2.getRecruitDate(), LocalDate.of(2022, 7, 8));
        Assertions.assertSame(empl2.getDismissDate(), null);
        Assertions.assertEquals(50000, empl2.getSalary());

    }

}