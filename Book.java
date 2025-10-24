package library;

public class Book extends Item{
    private String author;
    private int pageNumber;
    private String publishingHouse;


    public Book(int id,String add,int pubY,String spec,String author,int pageNumber,String publishingHouse){
        super(id,add,pubY,spec);
        this.author=author;
        this.pageNumber=pageNumber;
        this.publishingHouse=publishingHouse;
    }

    public void setAuthor(String author){
        this.author=author;
    }
    public void setPageNumber(int pageNumber){
        this.pageNumber=pageNumber;
    }
    public void setPublishingHouse(String publishingHouse){
        this.publishingHouse=publishingHouse;
    }


    public String getAuthor(){
        return author;
    }
    public int getPageNumber(){
        return pageNumber;
    }
    public String getPublishingHouse(){
        return publishingHouse;
    }

    @Override
    public void getDetails(){
        super.print();
        System.out.println("Author:"+author+".");
        System.out.println("Page Number:"+pageNumber);
        System.out.println("Publishing House:"+publishingHouse+".");
    }
}
