public class Outbox {
      private Notice[] queue;
      private int count;

      public Outbox(int capacity){
          queue = new Notice[capacity];
          count = 0;
      }

      public void queue(Notice notice){
          queue[count++] = notice;
      }

      public void queue(Notice notice, int repeat){
          for(int i = 0; i < repeat; i++){
              queue[count++] = notice;
          }
      }
      public int waitingCount(){
          return count;
      }
      public double totalCost(){
          double total = 0;
          for(int i = 0; i < count; i++){
              total += queue[i].cost();
          }
          return total;
      }

      public String flush(){
          String result = "";
          for(int i = 0; i < count; i++){
              result += queue[i].deliver();
          }
          count = 0;
          return result;
      }
}
