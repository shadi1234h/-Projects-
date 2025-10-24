package library;
import java.time.LocalDate;
import java.util.ArrayList;
public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Project> projects = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Book>lateReturnBook=new ArrayList<>();


    public void addBook(int id, String add, int pubY, String spec, String author, int pageNumber, String publishingHouse) {
            Book book=new Book(id,add,pubY,spec,author,pageNumber,publishingHouse);
            books.add(book);
    }
    public boolean idOfBookIsFoundOrNot(int id){
        for(Book book:books){
            if(book.getId()==id){
                return true;
            }
        }
        return false;
    }


    public void addProject(int id, String add, int pubY, String spec, int universityYear, String teamWork) {
            Project project=new Project(id,add,pubY,spec,universityYear,teamWork);
            projects.add(project);
    }
    public boolean idOfProjectIsFoundOrNot(int id){
        for(Project project:projects){
            if(project.getId()==id){
                return true;
            }
        }
        return false;
    }


    public void addMember(int membershipNumber, String name) {
            Member member=new Member(membershipNumber,name);
            members.add(member);
    }
    public boolean membershipNumberIsFoundOrNot(int membershipNumber){
        for(Member member:members){
            if(member.getMembershipNumber()==membershipNumber)
                return true;
        }
        return false;
    }



    public void setMemberLateReturnBook(){
        for(Book book:books){
            LocalDate dateOfReturn=book.getLoanTime().plusDays(7);
            if (book.getLoanedOrNot()){
                LocalDate currentDate=LocalDate.now();
                if(dateOfReturn.isBefore(currentDate))
                    lateReturnBook.add(book);
            }
            else{
                if(dateOfReturn.isBefore(book.getReturnTime()))
                    lateReturnBook.add(book);
            }
        }
    }
    public void viewMemberLateReturnBook(){
        for(Book lateReturnBook:lateReturnBook){
            lateReturnBook.getDetails();
        }
    }

    public boolean CheckNumOfBorrowedItem(int membershipNumber) {
        for (Member member : members) {
            if (member.getMembershipNumber() == membershipNumber) {
                if ((member.getLoanedBookFrMem().toArray().length+member.getLoanedProjectFrMem().toArray().length ) < 3)
                    return true;
            }
        }
        return false;
    }

    public void viewAllBook() {
        int count = 1;
        for (Book book : books) {
            System.out.println("Book " + count + ":");
            book.getDetails();
            count++;
            book.printIfLoanedOrNot();
        }
    }
    public void viewAllMembers() {
        int count = 1;
        for (Member member : members) {
            System.out.println("Member " + count + ":");
            member.printInfo();
            count++;
        }
    }
    /// /////
    public void viewOfThirdYearProjects() {
        for (Project thirdProject : projects) {
            if (thirdProject.getUniversityYear() == 3)
                thirdProject.getDetails();
        }
    }
    public void viewMembersBorrowedAIBooks() {
        for (Member member : members) {
            if (member.searchOfAILoanedBook())
                System.out.println("Name:" + member.getName());
        }
    }
    /// /////
    public void viewAllCurrentlyBorrowedBooks() {
        for (Member member : members) {
            member.printAllLoanBook();
        }
    }
    public void viewMemberBorrowedBookDuringPeriodOfTime(LocalDate time) {
        for (Member member : members) {
            if (member.searchLoanTime(time)) {
                System.out.println("Name member:" + member.getName());
            }
        }
    }

    public void projectWithinSpecificSpecialty(String specialization) {
        for (Project specProject : projects) {
            if (specProject.getSpecialization()== specialization)
                if (!specProject.getLoanedOrNot())
                    specProject.getDetails();
        }
    }

    public void searchBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.getDetails();
                book.printIfLoanedOrNot();
            }
        }
    }
    public void searchProjectById(int id) {
        for (Project project : projects) {
            if (project.getId() == id) {
                project.getDetails();
                project.printIfLoanedOrNot();
            }
        }
    }

    public void searchBookByAddress(String address) {
        for (Book book : books) {
            if (book.getAddress()== address) {
                book.getDetails();
                book.printIfLoanedOrNot();
            }
        }
    }
    public void searchProjectByAddress(String address) {
        for (Project project : projects) {
            if (project.getAddress()== address) {
                project.getDetails();
                project.printIfLoanedOrNot();
            }
        }
    }

    public void searchBookBySpecialization(String specialization) {
        for (Book book : books) {
            if (book.getSpecialization()== specialization) {
                book.getDetails();
                book.printIfLoanedOrNot();
            }
        }
    }
    public void searchProjectBySpecialization(String specialization) {
        for (Project project : projects) {
            if (project.getSpecialization()== specialization) {
                project.getDetails();
                project.printIfLoanedOrNot();
            }
        }
    }

    public void borrowBook(int id, int membershipNumber, LocalDate dateOfLoan) {
        for (Book book : books) {
            if (book.getId() == id) {
                if (book.getLoanedOrNot()) {
                    System.out.println("Sorry,The book is currently on loan.");
                } else {
                    for (Member member : members) {
                        if (member.getMembershipNumber() == membershipNumber) {
                            member.loanBook(book, dateOfLoan);
                        }
                    }
                    System.out.println("Success.....");
                }
            }
        }
    }
    public void borrowProject(int id, int membershipNumber, LocalDate dateOfLoan) {
        for (Project project : projects) {
            if (project.getId() == id) {
                if (project.getLoanedOrNot()) {
                    System.out.println("Sorry,The project is currently on loan.");
                } else {
                    for (Member member : members) {
                        if (member.getMembershipNumber() == membershipNumber) {
                            member.loanProject(project, dateOfLoan);
                        }
                    }
                    System.out.println("Success.....");
                }
            }
        }
    }

    public void returnBook(int id, int membershipNumber, LocalDate dateOfReturn) {
        for (Book book : books) {
            if (book.getId() == id) {
                for (Member member : members) {
                    if (member.getMembershipNumber() == membershipNumber) {
                        member.returnBook(book, dateOfReturn);
                        System.out.println("Success.....");
                    }
                }
            }
        }
    }
    public void returnProject(int id,int membershipNumber,LocalDate dateOfReturn){
        for(Project project:projects){
            if(project.getId()==id){
                for (Member member : members) {
                    if (member.getMembershipNumber() == membershipNumber)
                        member.returnProject(project, dateOfReturn);
                    System.out.println("Success.....");
                }
            }
        }
    }
}