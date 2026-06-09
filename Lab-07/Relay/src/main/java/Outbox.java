public class Outbox {
  private final Notice[] notices;
  private int count;

  public Outbox(){
      this.notices = new Notice[100];
      this.count = 0;
  }

  public void queue(Notice notice){
      notices[count] = notice;
      count++;
  }

    public void queue(Notice notice, int repeat){
      for(int i=0;i<repeat;i++){
          queue(notice);
      }
}

public int waitingCount(){
      return count;
}
}
