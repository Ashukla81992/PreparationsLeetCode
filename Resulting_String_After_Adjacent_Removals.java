public class Resulting_String_After_Adjacent_Removals {
    public static void main(String[] args) {
         System.out.println(resultingString("adcbw"));
    }
        public static String resultingString(String s) {

            boolean isClean = false;

            char[] array = s.toCharArray();
            while(isClean == false && !(array==null || array.length == 0)){

                char[] temp = null;
                int count =0;
                for(int i=0;i<array.length;i++){
                    if(i<array.length-1) {
                        if (array[i] != 'A' && (array[i] - array[i + 1] == 1 || array[i] - array[i + 1] == -1
                                || array[i] - array[i + 1] == 25 || array[i] - array[i + 1] == -25)) {
                            count=count+2;
                            array[i]='A';
                            array[i+1]='A';
                        }
                    }
                    else if(i==array.length-1 && count==0){
                        isClean = true;
                    }
                }
                temp = new char[array.length-count];
                int j=0;
                for (char c:array){
                    if(c != 'A' && j<array.length-count) {
                        temp[j] = c;
                        j++;
                    }
                }
                array=temp;
            }
            return String.valueOf(array);
        }

}
