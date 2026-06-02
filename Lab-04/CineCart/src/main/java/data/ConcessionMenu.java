package data;

import model.ConcessionItem;

public class ConcessionMenu {
    ConcessionItem[] items;
    int count;
    private static final int MAX=3;

     public void add(ConcessionItem c){
      count=0;
      if(count<MAX){
                 items[count]=c;
                 count++;

             }
         }
      public ConcessionItem findByCode(String code) {
          for (int i = 0; i < count; i++) {
              if(items[i].getCode().equals(code)){
                  return items[i];
              }

          }
          return null;
      }


}
