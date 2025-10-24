package library;

public class Project extends Item{
    private int universityYear;
    private String teamWork;

    public Project(int id,String add,int pubY,String spec,int universityYear,String teamWork){
        super(id,add,pubY,spec);
        this.universityYear=universityYear;
        this.teamWork=teamWork;
    }
//
//    public void setUniversityYear(int universityYear){
//        this.universityYear=universityYear;
//    }
//    public void setTeamWork(String teamWork){
//        this.teamWork=teamWork;
//    }

    public int getUniversityYear(){
        return universityYear;
    }
//    public String getTeamWork(){
//        return teamWork;
//    }

    @Override
    public void getDetails(){
        super.print();
        System.out.println("University year:"+universityYear);
        System.out.println("Team Work:"+teamWork+".");
    }
}
