public class fjsd {

     public static int camelcase(String s) {
 String string = new String();
int count =0;
 for(count = 0 ; count<= s.length(); count++){
    int asciii = (char)count;
     if (asciii >90 && asciii <123 ){
     count = count+1;
     System.out.println(count);
 }
    else {
    System.out.println("1");
}
 
    }
       
        return count; 
}

}