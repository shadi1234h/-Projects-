package library;
import java.time.LocalDate;
import java.util.ArrayList;
public class Member {
    private int membershipNumber;
    private String name;
    private ArrayList<Book> loanedBookFrMem=new ArrayList<>();
    private ArrayList<Project>loanedProjectFrMem=new ArrayList<>();

    public Member(int membershipNumber,String name){
        this.membershipNumber=membershipNumber;
        this.name=name;
    }

//    public void setName(String name){
//        this.name=name;
//    }
//    public void setMembershipNumber(int membershipNumber){
//        this.membershipNumber=membershipNumber;
//    }
//    public void setLoanedBookFrMem(ArrayList<Book>loanedBookFrMem){this.loanedBookFrMem=loanedBookFrMem;}
//    public void setLoanedProjectFrMem(ArrayList<Project>loanedProjectFrMem){this.loanedProjectFrMem=loanedProjectFrMem;}

    public String getName(){
        return name;
    }
    public int getMembershipNumber(){
        return membershipNumber;
    }
    public ArrayList<Book> getLoanedBookFrMem(){
        return loanedBookFrMem;
    }
    public ArrayList<Project> getLoanedProjectFrMem(){
        return loanedProjectFrMem;
    }

    public void loanBook(Book book,LocalDate dateOfLoan){
        loanedBookFrMem.add(book);
        book.setLoanTime(dateOfLoan);
        book.setLoanedOrNot(true);
    }
    public void loanProject(Project project,LocalDate dateOfLoan){
        loanedProjectFrMem.add(project);
        project.setLoanTime(dateOfLoan);
        project.setLoanedOrNot(true);
    }

    public void returnBook(Book book,LocalDate dateOfReturn){
        loanedBookFrMem.remove(book);
        book.setReturnTime(dateOfReturn);
        book.setLoanedOrNot(false);
    }
    public void returnProject(Project project,LocalDate dateOfReturn){
        loanedProjectFrMem.remove(project);
        project.setReturnTime(dateOfReturn);
        project.setLoanedOrNot(false);
    }

    public void printInfo(){
        System.out.println("Name:"+name);
        System.out.println("Member ship number:"+membershipNumber);
        System.out.println("List of books and projects loaned to this member:");
        for(Book book:loanedBookFrMem){
            book.getDetails();
        }
        for(Project project:loanedProjectFrMem){
            project.getDetails();
        }
    }

    public boolean searchOfAILoanedBook(){
        for(Book book:loanedBookFrMem){
            if(book.getSpecialization()=="AI")
                return true;
        }
        return false;
    }

    public void printAllLoanBook(){
        for(Book loanBook:loanedBookFrMem){
            int count=1;
            System.out.println("Book "+count+":");
            loanBook.getDetails();
            count++;
        }
    }

    public boolean searchLoanTime(LocalDate time){
        for(Book book:loanedBookFrMem)
            if(book.getLoanTime()==time)
                return true;
        return false;
    }
}
