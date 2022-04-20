package Assignment6;

public class Vampire2 {

    public static boolean isVampire(int i){

        return false;
    }

    public static void main(String[] args) {
//        int count = 0;
//        int i = 10;
//        while(count<100 && i<1003){
////            System.out.print(i + " ");
//            if(isVampire(i)){
//                System.out.print(i+" ");
//            }
//            i = i+2;
//            if(((int)Math.log10(i)+1)%2!=0){
//                i = i*10;
//            }
//            count++;
//        }
        boolean alp[] = new boolean[10];
        int count = 0;
        for (int i = 0; i < 1000 && count<100; i+=2) {
            for (int j = i; j < 1000 && count<100; j++) {
                boolean flag = true;
                int v = i*j;
                String vStr = String.valueOf(v);
                String xStr = String.valueOf(i);
                String yStr = String.valueOf(j);
                int n = vStr.length();
                if(n%2==0 && v%2==0 && xStr.length()==n/2 && yStr.length()==n/2 && (vStr.charAt(n-1)!='0' || vStr.charAt(n/2-1)!='0')){
                    for(char c: xStr.toCharArray()){
                        alp[c-'0'] = true;
                    }
                    for(char c: yStr.toCharArray()){
                        alp[c-'0'] = true;
                    }
                    for(char c: vStr.toCharArray()){
                        if(alp[c-'0']==false){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        System.out.println("v:"+vStr+" x:" + xStr + " y:" + yStr);
                        count++;
                    }
                }
            }
        }
    }
}
