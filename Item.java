package library;
import java.time.LocalDate;
public abstract class Item {
    private int id;
    private String address;
    private int publicationYear;
    private String specialization;
    private boolean loanedOrNot;
    private LocalDate loanTime;
    private LocalDate returnTime;

    public Item(int id,String address,int publicationYear,String specialization){
        this.id=id;
        this.specialization=specialization;
        this.address=address;
        this.publicationYear=publicationYear;
        }

//    public void setId(int id){
//        this.id=id;
//    }
//    public void setAddress(String address){
//        this.address=address;
//    }
//    public void setPublicationYear(int publicationYear){
//        this.publicationYear=publicationYear;
//    }
//    public void setSpecialization(String specialization){
//        this.specialization=specialization;
//    }
    public void setLoanedOrNot(boolean loanedOrNot){
        this.loanedOrNot=loanedOrNot;
    }
    public void setLoanTime(LocalDate loanTime){
        this.loanTime=loanTime;
    }
    public void setReturnTime(LocalDate returnTime){
        this.returnTime=returnTime;
    }

    public int getId(){
        return id;
    }
    public String getAddress(){
        return address;
    }
//    public int getPublicationYear(){
//        return publicationYear;
//    }
    public String getSpecialization(){
        return specialization;
    }
    public boolean getLoanedOrNot(){
        return loanedOrNot;
    }
    public LocalDate getLoanTime(){
        return loanTime;
    }
    public LocalDate getReturnTime(){
        return returnTime;
    }

    public void print(){
        System.out.println("ID:"+id);
        System.out.println("Address:"+address+".");
        System.out.println("Publication year:"+publicationYear);
        System.out.println("Specialization:"+specialization+".");
    }
    public void printIfLoanedOrNot(){
        if(loanedOrNot)
            System.out.println("The project is currently on loan.");
        else
            System.out.println("The project is currently available.");
    }

    public abstract void getDetails();

}
