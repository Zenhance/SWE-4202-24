public class Notice {
     private String notice_text;
     public String recipient;
     public Notice(String notice_text, String recipient){
         this.notice_text = notice_text;
         this.recipient = recipient;
     }
    public String getRecipient() {
        return recipient;
    }
    public String getNotice_text() {
        return notice_text;
    }
}
