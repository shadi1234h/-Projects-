package library;
import java.util.Scanner;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        Library lib=new Library();
        System.out.println("Welcome to the Library Management Program.");
        while(true){

            System.out.println("________________________________________");
            System.out.println("1)Add an item to the library (book\\project\\member).");
            System.out.println("2)View a specific item in the library.");
            System.out.println("3)Search for a book or project.");
            System.out.println("4)Request to borrow a book or project.");
            System.out.println("5)Reprint a book or project.");
            System.out.println("6)Exit.");
            System.out.println("________________________________________");
            System.out.print("Choose from 1 to 6:");
            int ch=input.nextInt();
            input.nextLine();


            switch (ch){
                case 1:
                    System.out.println("________________");
                    System.out.println("1)Add Member.");
                    System.out.println("2)Add Book.");
                    System.out.println("3)Add Project.");
                    System.out.println("________________");
                    System.out.print("Choose from 1 to 3:");
                    int chAdd=input.nextInt();
                    input.nextLine();
                    switch (chAdd){
                        case 1:
                            System.out.println("Enter new membership number of member:");
                            int memNum=input.nextInt();
                            input.nextLine();
                            if(lib.membershipNumberIsFoundOrNot(memNum)) {
                                System.out.println("Sorry,The membership number you entered belongs to a member who has already subscribed.");
                            }
                            else{
                                System.out.print("Enter name of member:");
                                String name=input.nextLine();
                                lib.addMember(memNum,name);
                                System.out.println("Add member Successfully.....");
                            }
                            break;

                        case 2:
                            System.out.print("Enter id Book:");
                            int idBook=input.nextInt();
                            input.nextLine();
                            if(lib.idOfBookIsFoundOrNot(idBook)){
                                System.out.println("Sorry, this identifier belongs to a book already registered in the library.");
                            }
                            else{
                                System.out.print("Enter address Book:");
                                String addressB= input.nextLine();
                                System.out.print("Enter publication year Book:");
                                int publicationYearB=input.nextInt();
                                input.nextLine();
                                System.out.print("Enter specialization Book:");
                                String specializationB=input.nextLine();
                                System.out.print("Enter name author Book:");
                                String author=input.nextLine();
                                System.out.print("Enter page number Book:");
                                int pageNumber=input.nextInt();
                                input.nextLine();
                                System.out.print("Enter publishing house Book:");
                                String publishingHouse=input.nextLine();
                                lib.addBook(idBook,addressB,publicationYearB,specializationB,author,pageNumber,publishingHouse);
                                System.out.println("Add book Successfully.....");
                            }
                            break;

                        case 3:
                            System.out.print("Enter id Project:");
                            int idPr=input.nextInt();
                            input.nextLine();
                            if(lib.idOfProjectIsFoundOrNot(idPr)){
                                System.out.println("Sorry, this identifier belongs to a project already registered in the library.");
                            }
                            else{
                                System.out.print("Enter address Project:");
                                String addressP= input.nextLine();
                                System.out.print("Enter publication year Project:");
                                int publicationYearP=input.nextInt();
                                input.nextLine();
                                System.out.print("Enter specialization Project:");
                                String specializationP=input.nextLine();
                                System.out.print("Enter university year:");
                                int universityYear=input.nextInt();
                                input.nextLine();
                                System.out.print("Enter team work:");
                                String teamWork=input.nextLine();

                                lib.addProject(idPr,addressP,publicationYearP,specializationP,universityYear,teamWork);
                                System.out.println("Add project Successfully.....");
                            }
                            break;
                        default:
                            System.out.println("Invalid choose,Please try again...");
                            break;
                    }
                    break;




                case 2:
                    System.out.println("__________________________________________");
                    System.out.println("1)View all member and book loaned for him.");
                    System.out.println("2)View all books in the library.");
                    System.out.println("3)View of third year projects.");
                    System.out.println("4)View members who have borrowed AI books");
                    System.out.println("5)View members who are late in returning books.");
                    System.out.println("6)View all currently borrowed books.");
                    System.out.println("7)View all available projects within a specific specialty.");
                    System.out.println("8)View members who have borrowed a book during a period of time.");
                    System.out.println("__________________________________________");
                    System.out.print("Choose from 1 to 8:");
                    int chView=input.nextInt();
                    input.nextLine();
                    switch (chView){
                        case 1:
                            lib.viewAllMembers();
                            break;
                        case 2:
                            lib.viewAllBook();
                            break;
                        case 3:
                            lib.viewOfThirdYearProjects();
                            break;
                        case 4:
                            lib.viewMembersBorrowedAIBooks();
                            break;
                        case 5:
                            lib.setMemberLateReturnBook();
                            lib.viewMemberLateReturnBook();
                            break;
                        case 6:
                            lib.viewAllCurrentlyBorrowedBooks();
                            break;
                        case 7:
                            System.out.print("Enter the specialty in which you want to view available projects:");
                            String specialization=input.nextLine();
                            lib.projectWithinSpecificSpecialty(specialization);
                            break;
                        case 8:
                            System.out.println("Enter the time period for which you want to view members who have borrowed books during this period:");
                            String date=input.next();
                            LocalDate time=LocalDate.parse(date);
                            lib.viewMemberBorrowedBookDuringPeriodOfTime(time);
                            break;
                        default:
                            System.out.println("Invalid choose,Please try again...");
                            break;
                    }
                    break;



                case 3:
                    System.out.print("Want to search for a book or project?(1_Book,2_Project):");
                    int chBookOrProject=input.nextInt();
                    input.nextLine();
                    if (chBookOrProject<1||chBookOrProject>2)
                        System.out.println("Invalid choose,Please try again later.....");
                    else{
                        System.out.println("1)Search by ID.");
                        System.out.println("2)Search by address.");
                        System.out.println("3)Search by specialization.");
                        System.out.print("Choose from 1 to 3:");
                        int chSear=input.nextInt();
                        input.nextLine();
                        switch (chSear){
                            case 1:
                                if(chBookOrProject==1){
                                    System.out.print("Enter ID of book:");
                                    int id=input.nextInt();
                                    lib.searchBookById(id);
                                }
                                else
                                {
                                    System.out.print("Enter ID of project:");
                                    int id=input.nextInt();
                                    lib.searchProjectById(id);
                                }
                                break;
                            case 2:
                                if(chBookOrProject==1){
                                    System.out.print("Enter address of book:");
                                    String address=input.nextLine();
                                    lib.searchBookByAddress(address);
                                }
                                else{
                                    System.out.print("Enter address of project:");
                                    String address=input.nextLine();
                                    lib.searchProjectByAddress(address);
                                }
                                break;
                            case 3:
                                if(chBookOrProject==1){
                                    System.out.print("Enter specialization of book:");
                                    String specialization=input.nextLine();
                                    lib.searchBookBySpecialization(specialization);
                                }
                                else{
                                    System.out.print("Enter specialization of project:");
                                    String specialization=input.nextLine();
                                    lib.searchProjectBySpecialization(specialization);
                                }
                                break;
                            default:
                                System.out.println("Invalid choose,Please try again...");
                                break;
                        }
                    }
                    break;




                case 4:
                    LocalDate dateOfLoan=LocalDate.now();
                    System.out.print("Enter the membership number of the member who wants to borrow:");
                    int membershipMember=input.nextInt();
                    if(lib.CheckNumOfBorrowedItem(membershipMember)){
                        System.out.println("1)Request to borrow book.");
                        System.out.println("2)Request to borrow project.");
                        System.out.print("Choose 1 or 2:");
                        int chReq=input.nextInt();
                        if(chReq==1){
                            System.out.print("Enter ID of book:");
                            int id=input.nextInt();
                            lib.borrowBook(id,membershipMember,dateOfLoan);

                        }
                        else if(chReq==2){
                            System.out.print("Enter ID of project:");
                            int id=input.nextInt();
                            lib.borrowProject(id,membershipMember,dateOfLoan);
                        }
                        else
                            System.out.println("Invalid choose,Please try again.....");
                    }
                    else{
                        System.out.println("Sorry, this member cannot borrow other items.");
                    }
                    break;



                case 5:
                    LocalDate dateOfReturn=LocalDate.now();
                    System.out.print("Enter the membership number of the member who wants to return:");
                    int membershipMem=input.nextInt();
                        System.out.println("1)Return book.");
                        System.out.println("2)Return project.");
                        System.out.print("Choose 1 or 2:");
                        int chRet=input.nextInt();
                        if(chRet==1){
                            System.out.print("Enter ID of book:");
                            int id=input.nextInt();
                            lib.returnBook(id,membershipMem,dateOfReturn);
                        }
                        else if(chRet==2){
                            System.out.print("Enter ID of project:");
                            int id=input.nextInt();
                            lib.returnProject(id,membershipMem,dateOfReturn);
                        }
                        else
                            System.out.println("Invalid choose,Please try again.....");
                    break;




                default:
                    if(ch==6)
                        break;
                    System.out.println("Invalid choose,Please try again...");
                    break;
            }
            if(ch==6){
                System.out.println("Exiting.......");
                break;
            }
        }
    }
}